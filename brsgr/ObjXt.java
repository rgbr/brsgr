package javaapplication31;

import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.String;


//////////////////////////////////////////////////////////////
/////ObjXt
public class ObjXt
{
    ObjXt() {};
    ObjXt(ObjXt Objx)
            {   this.Obj = Objx;    };

    private ObjXt Obj;
    protected static double pi = 0.0;          // value
    protected static double s = 0.0;           // asset
    protected static double x = 0.0;
    protected static double vol = 0.0;         // vol
    protected static double rf = 0.0;          // risk free rate
    protected static double t = 0.0;           // time
    protected static double r = 0.0;           // spread risk
    protected static double nds = 0.0;           // risk neutral prob
    protected static double ndh = 0.0;
    public static String contract = "";     // contract title

    protected double d1()
    /**{ return ((1 / (this.Vol * Math.sqrt(this.T))) * ( Math.log(this.S / this.K ) + (r + ((this.Vol ^ 2)/2))*this.T));};**/
       { return 1.0; };

    protected double d2()
       { return 1.0; };

    public void setVol(double in) {  vol = in; };
    public void setrf(double in) { rf = in; };
    public void setT(double in) { t = in; };
    public void setR(double in) { r = in;  };
    public void setS(double in) { s = in; }
    public void setNdS() { nds = 1.0; };
    public void setNdX() { ndh = 1.0; };
    public void setPi() { pi = (this.getS()*this.getNdS() - this.getX()*this.getNdX()); };

    public double getRf() { return rf; };      // payoff
    public double getVol() { return vol; };     // payoff
    public double getT() { return t; };       // T
    public double getR() { return r; };       // r
    public double getNdS() { return nds; };      // nd
    public double getNdX() { return ndh; };      // nd
    public double getS() { return s; };
    public double getX() { return x; };

    public double getPi() { return pi; };

    @Override public String toString() { return (contract + "|"); };
};


//////////////////////////////////////////////////////////////
/////ObjPayOff
class ObjPayOff  {

    private ObjPayOff Obj;
    protected static double Val = 0.0;
    protected static ObjXt S;                           // risk
    protected static ObjXt H ;                          // hedge

    ObjPayOff() {};
    ObjPayOff(ObjXt Sx, ObjXt Hx)
       {
        S = Sx;
        H = Hx;
        S.setPi();
        H.setPi();
        Val = Math.max(0.0, S.getPi() - H.getPi());     // payoff
       };

    protected double getVal()
       { return Val; };
};


//////////////////////////////////////////////////////////////
/////ObjProf
class ObjProf {

    private ObjProf Obj;
    protected static double prof;
    protected static ObjPayOff AM0;                        // payoff 0
    protected static ObjPayOff AM1;                        // payoff t
    
    ObjProf() {};
    ObjProf(ObjPayOff AMy, ObjPayOff AMx)
        {   
          AM0 = AMx;
          AM1 = AMy;
        };

    protected double getProf()                             // profit
        { return prof; };

    protected void setProf()
        { prof = (AM1.getVal() - AM0.getVal()); };         // difference between value of the position at t = 0 and t = T

};
