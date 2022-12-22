/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class CalculatorModel {

    private int cong, tru, nhan, chia;

    public CalculatorModel() {
    }

    public CalculatorModel(int cong, int tru, int nhan, int chia) {
        this.cong = cong;
        this.tru = tru;
        this.nhan = nhan;
        this.chia = chia;
    }

    public void phepcong(int so1, int so2) {
        cong = add(so1,so2);
    }

    public void pheptru(int so1, int so2) {
        tru = subtract(so1, so2);
    }

    public void phepnhan(int so1, int so2) {
        nhan = multiply(so1, so2);
    }

    public void phepchia(int so1, int so2) {
        chia = divide(so1, so2);
    }

    public int getCong() {
        return cong;
    }

    public int getTru() {
        return tru;
    }

    public int getNhan() {
        return nhan;
    }

    public int getChia() {
        return chia;
    }

    private static int add(int intA, int intB) {
        org.tempuri.Calculator service = new org.tempuri.Calculator();
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap();
        return port.add(intA, intB);
    }

    private static int subtract(int intA, int intB) {
        org.tempuri.Calculator service = new org.tempuri.Calculator();
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap();
        return port.subtract(intA, intB);
    }

    private static int multiply(int intA, int intB) {
        org.tempuri.Calculator service = new org.tempuri.Calculator();
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap();
        return port.multiply(intA, intB);
    }

    private static int divide(int intA, int intB) {
        org.tempuri.Calculator service = new org.tempuri.Calculator();
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap();
        return port.divide(intA, intB);
    }
    
}
