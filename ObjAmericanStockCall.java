package javaapplication31;

import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.String;


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

