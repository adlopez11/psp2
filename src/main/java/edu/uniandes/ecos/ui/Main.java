package edu.uniandes.ecos.ui;


import edu.uniandes.ecos.control.SimpsonControl;
import edu.uniandes.ecos.exception.GammaException;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Main {
    public static void main(String[] args){
        
        System.out.println("Calculo de la Integral de la Distribucion T al punto x\n");
        
        try {
            System.out.println("Digite el valor de x: ");
            Scanner sc1 = new Scanner(System.in);
            String xString = sc1.next();
            double x = Double.parseDouble(xString);
            System.out.println("Digite el valor de dof: ");
            Scanner sc2 = new Scanner(System.in);
            String dofString = sc2.next();
            double dof = Double.parseDouble(dofString);
            
            System.out.println("\nValores x=" + x + " dof="+dof+"\n");
            
            SimpsonControl control = new SimpsonControl(x, dof);
            control.operar();
            
            double p = control.getP();

            System.out.println("Valor Integral: " + p+"\n");


        } catch (GammaException ex) {
            System.out.println(ex.getMessage()+"\n");
        } catch (NumberFormatException ex){
            System.out.println("Error con los valores ingresados, deben estar en formato numero decimal. Se usa el punto como separador de decimales"+"\n");
        }
        System.out.println("\nFin de la aplicacion");
        
    }
}
