/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication30;
import java.io.IOException;

/*****************************************************************************/
/**** Forward Obj
 *
 * @author kingsleyoteng
 * @date July/15/2014
 * @eqn F = S.e((r + c - d)T)
 */

class ForwardObj extends Obj implements Runnable
{
    private ForwardObj FO;
    static { Ctx = new String("Forward Bond"); }
        /** constructors **/
    ForwardObj() {};
    ForwardObj(ForwardObj fob)
       { this.FO = fob;};

    private void setObj(ForwardObj fob)
       { this.FO = fob;};

    @Override public double getPrice()
       { return Math.max(0.0, V); };

     /***
     * parameter method declaration for standard financial asset futures contract
     */
    public void setParam(String Ct, double t, double s0, double r, double q, double n )
       {
        // update state values
            try  {
                Contract = Ct;
                S0 = s0;
                R = r;
                Q = q;
                T = t;
                N = n;
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        };

    @Override public String getParam()
       { return (Contract + "|" + T + "|" + S0 + "|" + R + "|" + Q + "|" + SC + "|" +  Math.round(N) + "|" ); };

    public void run()
       {
            setPrice();
            getPrice();
            getParam();
       };

    /*** have one method to handle all price return for all futures types ***/
}

/*****************************************************************************/
/**** OTC forward
 *
 * @author kingsleyoteng
 * @date July/26/2014
 * @eqn F = S.e((r - d)T)
 */
 
class Forward extends ForwardObj
{
    private ForwardObj FO;
    static { Ctx = "Forward";};
        /** constructors **/
    Forward() {};
    Forward(ForwardObj fob)
       { this.FO = fob;};

    private void setObj(ForwardObj fob)
       { this.FO = fob;};


    public void setParam(String Ct, double t, double s0, double r, double q, double sc, double n )
       {
        // update state values
            try  {
                Contract = Ct;
                S0 = s0;
                R = r;
                Q = q;
                SC = sc;
                T = t;
                N = n;
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        };

    @Override public void setPrice()
        {
            try {
               V = (FO.N * FO.S0 * Math.exp((FO.R - FO.Q) * FO.T));
            }
            catch (Exception e) {
            }
        };


    @Override public String getParam()
       { return (Contract + "|" + T + "|" + S0 + "|" + R + "|" + Q + "|" + SC + "|" +  Math.round(N) + "|" ); };

    /*** have one method to handle all price return for all futures types ***/ 
}

/*****************************************************************************/
/**** Real Asset/Commodity forwards
 *
 * @author kingsleyoteng
 * @eqn F = S.e((r + c - d)T)
 * @date July/26/2014
 */
class commForward extends ForwardObj
{
    private ForwardObj FO;
    static { Ctx = "commForward";};
    /** constructors **/

    commForward() {};
    commForward(ForwardObj fob)
        { this.FO = fob;};

    private void setObj(ForwardObj fob)
        { this.FO = fob;};
//
//    /***
//     *
//     * F = S.e((r + sc - d)*T)
//     */
    @Override public void setPrice()
    {
        try {
            V = (FO.N * FO.S0 * Math.exp((FO.R  + FO.SC - FO.Q) * FO.T));
        }
        catch (Exception e) {
        }
    };

@Override public String toString() { return (Contract + "|"  +  T + "|" + S0 + "|"  + R + "|" + CY + "|"  + SC + "|" + Math.round(N) + "|" ); }

}

/*****************************************************************************/
/**** Currency forwards
 *
 * @author kingsleyoteng
 * @date July/15/2014
 * @edited July/26/2004, price using IRP
 * @param F = So.exp((r - rf) * T)
 */
class currForwards extends commForward
{
    private ForwardObj FO;
    static { Ctx = "currForwards";};

    currForwards() {};
    currForwards(ForwardObj fob)
        { this.FO = fob;};

    @Override public void setParam(String ct, double t, double s0, double r, double rf, double n)
        {
        // update state values
            try {
                Contract=ct==""? Ctx : ct;
                T = t;
                S0 = s0;
                R = r;
                Rf = rf;
                N = n;
            }
            catch(Exception ex) {
                System.out.println(ex.toString());
            }

        };

    private void setObj(ForwardObj FO)
        { this.FO = FO;};

    /**** F = S.e((r - q)*T) */
    @Override public void setPrice()
        {
            try {
                V = (FO.N * FO.S0 * Math.exp((FO.R - FO.Rf) * FO.T));
            } catch (Exception e) {

            }
        };

     @Override public String toString() { return (Contract + "|"  + T + "|" + S0 + "|"  + R + "|" + Rf + "|"  + Math.round(N) + "|" ); }

    /*** have one method to handle all price return for all futures types ***/
}