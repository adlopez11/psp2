package edu.uniandes.ecos.control;

import edu.uniandes.ecos.exception.GammaException;
import junit.framework.TestCase;

/**
 *
 * @author Alvaro
 */
public class SimpsonControlTest extends TestCase {
    
    public SimpsonControlTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    /**
     * Test of getP method, of class SimpsonControl.
     * @throws edu.uniandes.ecos.exception.GammaException
     */
    public void testGetP1() throws GammaException {
        double x = 1.1d;
        double dof = 9d;

        System.out.println("\nValores x=" + x + " dof="+dof+"\n");

        SimpsonControl control = new SimpsonControl(x, dof);
        control.operar();

        double p = control.getP();

        System.out.println("Valor Integral: " + p+"\n");

        double expResult = 0.35006d;

        assertEquals(expResult, p, 0.00001);
    }
    
    public void testGetP2() throws GammaException {
        double x = 1.1812d;
        double dof = 10d;

        System.out.println("\nValores x=" + x + " dof="+dof+"\n");

        SimpsonControl control = new SimpsonControl(x, dof);
        control.operar();

        double p = control.getP();

        System.out.println("Valor Integral: " + p+"\n");

        double expResult = 0.36757d;

        assertEquals(expResult, p, 0.00001);
    }
    
    public void testGetP3() throws GammaException {
        double x = 2.750d;
        double dof = 30d;

        System.out.println("\nValores x=" + x + " dof="+dof+"\n");

        SimpsonControl control = new SimpsonControl(x, dof);
        control.operar();

        double p = control.getP();

        System.out.println("Valor Integral: " + p+"\n");

        double expResult = 0.495d;

        assertEquals(expResult, p, 0.00001);
    }
    
}
