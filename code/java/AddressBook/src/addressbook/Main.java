/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbook;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.handler.DefaultHandler;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

/**
 *
 * @author mariano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        org.mortbay.jetty.Server server;
        ServletHolder holder;
        Context contextWS;
        
        holder = new ServletHolder(ServletContainer.class);
        
        holder.setInitParameter("com.sun.jersey.config.property.packages", 
            "addressbook.ws");
        
        server = new org.mortbay.jetty.Server(9999);
        
        contextWS = new Context(server, "/ws", Context.SESSIONS);
        contextWS.addServlet(holder, "/*");
        ContentHandler resource_handler = new ContentHandler();
        resource_handler.setResourceBase("/resources");
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resource_handler, contextWS, new DefaultHandler()});
        server.setHandler(handlers);
        addressbook.ws.AddressBook.fill();
        server.start();
    }

}
