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
    public double[] LVar (double[] xx);

};

public class ObjParamImpl implements ObjParam {

    public double[] LReturn (double ... xx) {
        // log returns
        double[] sx = new double [xx.length];

        /** log return. BS assumes a log return **/
        for (int xI = 1; xI <= xx.length; xI++)
            {sx [xI] = Math.log(xx [xI] /xx [xI-1] );}

        return sx;
    };

    public double[] LVar (double ... xr) {
        // log variance
        double mux = new double();
        double vx = new double();

        mux = NumMathJ.sum(xr);
        /** log variance **/
        for (int xI = 1; xI <= xr.length; xI++)
             { vx =+ Math.pow((mux - xr),2); };

        return vx / xr.length;
    };
};
