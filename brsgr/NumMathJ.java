/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication31;
/**
 *
 * @author kingsleyoteng
 */
public class NumMathJ {
    public static double N(double d)
    {
        double rr = d<0.0?d * -1:d;
        double k = 0.0;
        double y = 0.0;

        k = (1 / (1 + 0.2316419 * rr));
        y = ((((1.330274429*k-1.821255978)*k+1.781477937)*k-0.356563782)*k+0.319381530)*k;
        y = 1.0 - 0.398942280401*Math.exp(-0.5*rr*rr)*y;

        return y=y<0?(1-y):y;
    }
}
