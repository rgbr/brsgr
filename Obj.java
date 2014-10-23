
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication30;

import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.String;


/**
 *
 * @author kingsleyoteng
 */
interface Instrument
{
    // you need to clean up the interface. 
    //abstract values
    public void setParam();
    public String getContract();
    public String getParam();
    public double getPrice();

}


class Obj implements Instrument  {
    Obj() {};
   
    /***
     *
     * Instrument parameters
     *
     */

    protected  double T = 0.0;              // time
    // protected  double T0 = 0.0;             // time 0
    // protected  double SC = 0.0;             // storage costs
    // protected  double Q = 0.0;              //
    // protected  double CY = 0.0;             // convinience yield
    // protected  double[] aR;
    // protected  double R = 0.0;              // risk rate
    // protected  double Y = 0.0;
    // protected  double Rf = 0.0;             // risk free rate
    // protected  double Vol = 0.0;            // volatility
    // protected  double Dt = 0.0;
    // protected  double S0 = 0.0;
    // protected  double ST = 0.0;
    protected  double S = 0.0;              // stock
    protected  double K = 0.0;              // strike
    protected  double V = 0.0;
    protected  double N = 1;                // notional
    protected  double C = 0.0;
    protected  double P = 0.0;
    protected  double M = 0.0;              //floating rate
    // protected  double Ff = 0.0;             // fixed rate
    // protected  double SW = 0.0;             // swap frequency
    // protected  double DS = 0.0;             // spread
    protected  int Pd = 0;



    //// static
    protected  static String Contract = new String();
    protected  static String Ctx = new String("Bond");

    //// Time series points
    protected double[][] X_S;
    protected double[] X;
    //

    // implemented interface methods
    public String getContract() { return Contract; };
    public double getPrice() { return V; };
    public String getParam() { return Contract; };
    public void setParam() { };

    /***
     * Object overrides
     * @return toString() returns Contract value;
    */


    protected double getTime() { return T; };
    protected double getR() { return R; };
    protected double getDT() { return (T - T0); };
    protected void setPrice() { V = 0.0; };



     @Override public String toString() { return (Contract + "|"  +  T + "|" + S0 + "|" + R + "|"  + Math.round(N) + "|" ); };

}

