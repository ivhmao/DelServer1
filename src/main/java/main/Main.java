package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxa on 28.10.2016.
 *
 *1111
 */
public class Main {
    public static void main(String[] args) throws Exception{
      /*  ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
        */
      //System.out.print("Hello, friend!");

        Server server = new Server(8080);

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(HelloServlet.class, "/mirror");

        server.start();
        System.out.println("Server started");
        //java.util.logging.Logger.getGlobal().info("Server started333");
        server.join();
    }
    @SuppressWarnings("serial")

    public static class HelloServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException{
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            String str = request.getParameter("key");
            response.getWriter().println(str);
        }
    }
}
