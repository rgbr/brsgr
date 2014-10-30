package javaapplication31;

import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.String;


//////////////////////////////////////////////////////////////
/////ObjEuroStockCall
public class ObjEuroStockCall extends ObjXt {

    ObjEuroStockCall() {};
    ObjEuroStockCall(ObjEuroStockCall Objx)
            {   this.Obj = Objx;
                setNdS();
                setNdX();
            };

    ////
    protected double Dt = Math.exp(-this.r*this.t);
    private ObjEuroStockCall Obj;

     /**{ return ((1 / (this.Vol * Math.sqrt(this.T))) * ( Math.log(this.S / this.K ) + (r + ((this.Vol ^ 2)/2))*this.T));};**/
    @Override protected double d1() {
        return NumMathJ.N((1 / (this.vol * Math.sqrt(this.t)))
              * ( ( Math.log(this.s / this.x))
              + (this.r + ((Math.pow(this.vol,2))/2))
              * this.t ));
       };                       //  risk neutral probability ITM
    @Override protected double d2() {
        return NumMathJ.N(this.d1() - (this.vol * Math.sqrt(this.t)));
       };                       //  risk neutral stock strike
    @Override public void setPi() { pi = (this.getS()*this.getNdS() - this.getX()*this.getNdX()*Dt); };
    @Override public String toString() { return ("EuroCall" + contract + " |"); };

};

//////////////////////////////////////////////////////////////
/////ObjEuroStockPut
class ObjEuroStockPut extends ObjEuroStockCall {

    ObjEuroStockPut() {};
    ObjEuroStockPut(ObjEuroStockPut Objx)
            {   this.Obj = Objx;
                setNdS();
                setNdX();
            };

    ////
    private ObjEuroStockPut Obj;

    @Override public void setPi() { pi = (this.getX()*this.getNdX() - this.getS()*this.getNdS()); };
    @Override public String toString() { return ("EuroPut" + contract + " |"); };

};


//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
/////ObjAmericanStockCall
class ObjAmericanStockCall extends ObjXt {

    ObjAmericanStockCall() {};
    ObjAmericanStockCall(ObjAmericanStockCall Objx)
            {   this.Obj = Objx;
                setNdS();
                setNdX();
            };

    private ObjAmericanStockCall Obj;
    @Override public void setPi() { pi = (this.getX()*this.getNdX() - this.getS()*this.getNdS()); };
    @Override public String toString() { return ("AmericanCall" + contract + " |"); };

};

