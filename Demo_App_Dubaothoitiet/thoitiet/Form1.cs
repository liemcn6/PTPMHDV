using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

using System.Net;
using System.Xml;
using System.IO;
using System.Globalization;

namespace dubaothoitiet
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        
        // http://home.openweathermap.org/users/sign_in -- link đăng ký lấy API
        private const string API_KEY = "c7055ce01673bc05bf8af1cb09e60bd2";

       
        private const string CurrentUrl =
            "http://api.openweathermap.org/data/2.5/weather?" +
            "@QUERY@=@LOC@&mode=xml&units=imperial&APPID=" + API_KEY;
        private const string ForecastUrl =
            "http://api.openweathermap.org/data/2.5/forecast?" +
            "@QUERY@=@LOC@&mode=xml&units=imperial&APPID=" + API_KEY;

        
        private string[] QueryCodes = { "q", "id", };

        
        private void Form1_Load(object sender, EventArgs e)
        {
            cboQuery.Items.Add("Thành Phố");
            cboQuery.Items.Add("ID");

            cboQuery.SelectedIndex = 0;
        }

        
        private void btnForecast_Click(object sender, EventArgs e)
        {
            
            string url = ForecastUrl.Replace("@LOC@", txtLocation.Text);
            url = url.Replace("@QUERY@", QueryCodes[cboQuery.SelectedIndex]);

           
            using (WebClient client = new WebClient())
            {
                
                try
                {
                    DisplayForecast(client.DownloadString(url));
                }
                catch (WebException ex)
                {
                    DisplayError(ex);
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Lỗi không xác định\n" + ex.Message);
                }
            }
        }

      
        private void DisplayForecast(string xml)
        {
           
            XmlDocument xml_doc = new XmlDocument();
            xml_doc.LoadXml(xml);

            
            XmlNode loc_node = xml_doc.SelectSingleNode("weatherdata/location");
            txtCity.Text = loc_node.SelectSingleNode("name").InnerText;
            txtCountry.Text = loc_node.SelectSingleNode("country").InnerText;
            XmlNode geo_node = loc_node.SelectSingleNode("location");
            txtLat.Text = geo_node.Attributes["latitude"].Value;
            txtLong.Text = geo_node.Attributes["longitude"].Value;
            txtId.Text = geo_node.Attributes["geobaseid"].Value;
            
            lvwForecast.Items.Clear();
            char degrees = (char)176;
            
            foreach (XmlNode time_node in xml_doc.SelectNodes("//time"))
            {
               
                DateTime time =
                    DateTime.Parse(time_node.Attributes["from"].Value,
                        null, DateTimeStyles.AssumeUniversal);

                XmlNode weatherNode = time_node.SelectSingleNode("symbol");
                string weather = weatherNode.Attributes["name"].Value;
                XmlNode temp_node = time_node.SelectSingleNode("temperature");
                string temp = temp_node.Attributes["value"].Value;
                double nhietDoC = Math.Round((Convert.ToDouble(temp) - 32) / 1.8, 3);
                temp = nhietDoC.ToString();
                string Date = ChangeDate(time.DayOfWeek.ToString());
                ListViewItem item = lvwForecast.Items.Add(Date);
                item.SubItems.Add(time.ToShortTimeString());
                item.SubItems.Add(temp + degrees);
                item.SubItems.Add(weather);
            }
        }

      
        private void DisplayError(WebException exception)
        {
            try
            {
                StreamReader reader = new StreamReader(exception.Response.GetResponseStream());
                XmlDocument response_doc = new XmlDocument();
                response_doc.LoadXml(reader.ReadToEnd());
                XmlNode message_node = response_doc.SelectSingleNode("//message");
                MessageBox.Show(message_node.InnerText);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Unknown error\n" + ex.Message);
            }
        }
        private string ChangeDate(string Date)
        {
            if (Date.Contains("Monday"))
                Date = "Thứ 2";
            if (Date.Contains("Tuesday"))
                Date = "Thứ 3";
            if (Date.Contains("Wednesday"))
                Date = "Thứ 4";
            if (Date.Contains("Thursday"))
                Date = "Thứ 5";
            if (Date.Contains("Friday"))
                Date = "Thứ 6";
            if (Date.Contains("Saturday"))
                Date = "Thứ 7";
            if (Date.Contains("Sunday"))
                Date = "Chủ nhật";
            return Date;
        }

    }
}
