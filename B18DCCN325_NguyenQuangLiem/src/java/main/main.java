/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import model.Caculator;
import view.CalculatorForm;

/**
 *
 * @author Admin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic herr
        CalculatorForm view = new CalculatorForm();
        Caculator model = new Caculator();
        Controller controller = new Controller(model, view);
        view.setVisible(true);
    }

}
