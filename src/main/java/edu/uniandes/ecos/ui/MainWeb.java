package edu.uniandes.ecos.ui;

import edu.uniandes.ecos.control.SimpsonControl;
import edu.uniandes.ecos.exception.GammaException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class MainWeb extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      process(1.1d,9d,resp);
      process(1.1812d, 10,resp);
      process(2.750d, 30,resp);
  }
  
  private void process(double x, double dof, HttpServletResponse resp) throws IOException{

      resp.getWriter().print("Calculo de la Integral de la Distribucion T al punto x\n\n");
        
        try {
            
            resp.getWriter().print("\nValores x=" + x + " dof="+dof+"\n\n");
            
            SimpsonControl control = new SimpsonControl(x, dof);
            control.operar();
            
            double p = control.getP();

            resp.getWriter().print("Valor Integral: " + p+"\n\n");


        } catch (GammaException ex) {
            resp.getWriter().print(ex.getMessage()+"\n");
        } 
        resp.getWriter().print("\nFin de la aplicacion\n");
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new MainWeb()),"/*");
    server.start();
    server.join();
  }
}
