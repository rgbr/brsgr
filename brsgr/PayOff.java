/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication30;

/**
 *
 * @author kingsleyoteng
 */
public abstract class PayOff {
    private PayOff PO;
    protected double V = 0.0;
    protected double Strike = 0.0;
    protected double P = 0.0;

    PayOff() {};
    PayOff(PayOff poo)
        {   this.PO = poo;  };
    
    public double getPrice()
        {   return this.V;       }
    
    abstract protected void setPrice();

}

class PayOffVanillaCall extends PayOff {
    private PayOffVanillaCall POC;

    PayOffVanillaCall() {};
    PayOffVanillaCall(PayOffVanillaCall poc)
        {   this.POC = poc; }

    protected void setPrice()
        { V =  Math.max(0,Strike  - P); }

}


class PayOffVanillaPut extends PayOff {
    private PayOffVanillaPut POP;

    PayOffVanillaPut() {};
    PayOffVanillaPut(PayOffVanillaPut pop)
        {   this.POP = pop; }

    protected void setPrice()
        { V = Math.max(0,P - Strike); }

}

