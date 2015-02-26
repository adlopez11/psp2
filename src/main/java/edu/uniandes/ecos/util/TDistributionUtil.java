/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.util;

import edu.uniandes.ecos.exception.GammaException;

/**
 *
 * @author Alvaro
 */
public class TDistributionUtil {
    
    public static double f(final double x, final double dof) throws GammaException{
        return ( GammaUtil.f( (dof+1d) / 2d) / ( Math.pow(dof * Math.PI, 0.5d) * GammaUtil.f(dof/2d) ) ) *
                Math.pow( 1d + ( (x*x) / 2d) , -((dof + 1d)/2d));
    }
}
