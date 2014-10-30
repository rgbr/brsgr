/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication31;

/**
 *
 */
interface ObjParam {
    public double[] LReturn (double[] xx);
};

public class ObjParamImpl implements ObjParam {

    public double[] LReturn (double[] xx) {
        
        double[] sx = new double[30];

        /** log return. BS assumes a log return **/
        for (xI = 1; xI <= 100; xI++)
            {sx[xI] = Math.log(xx[xI]/xx[xI-1]);}

        return sx;
    };

};
