/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Caculator {
    private int cong;
    private int tru;
    private int nhan;
    private int chia;

    public Caculator(int cong, int tru, int nhan, int chia) {
        this.cong = cong;
        this.tru = tru;
        this.nhan = nhan;
        this.chia = chia;
    }

    public Caculator() {
    }

    public int getCong() {
        return cong;
    }

    public void setCong(int cong) {
        this.cong = cong;
    }

    public int getTru() {
        return tru;
    }

    public void setTru(int tru) {
        this.tru = tru;
    }

    public int getNhan() {
        return nhan;
    }

    public void setNhan(int nhan) {
        this.nhan = nhan;
    }

    public int getChia() {
        return chia;
    }

    public void setChia(int chia) {
        this.chia = chia;
    }

   public void phepcong(int s1,int s2){
       cong =add(s1, s2);
   }
   public void pheptru(int s1,int s2){
       tru= subtract(s1, s2);
   }
   public void phepnhan(int s1,int s2){
       nhan=multiply(s1, s2);
   }
   public void phepchia(int s1,int s2){
       chia=divide(s1, s2);
   }

    private static int add(int intA, int intB) {
        calservice.Calculator service = new calservice.Calculator();
        calservice.CalculatorSoap port = service.getCalculatorSoap();
        return port.add(intA, intB);
    }

    private static int subtract(int intA, int intB) {
        calservice.Calculator service = new calservice.Calculator();
        calservice.CalculatorSoap port = service.getCalculatorSoap();
        return port.subtract(intA, intB);
    }

    private static int multiply(int intA, int intB) {
        calservice.Calculator service = new calservice.Calculator();
        calservice.CalculatorSoap port = service.getCalculatorSoap();
        return port.multiply(intA, intB);
    }

    private static int divide(int intA, int intB) {
        calservice.Calculator service = new calservice.Calculator();
        calservice.CalculatorSoap port = service.getCalculatorSoap();
        return port.divide(intA, intB);
    }
}
