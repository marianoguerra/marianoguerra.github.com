/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbook;

import java.io.IOException;
import java.net.MalformedURLException;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.resource.Resource;

/**
 *
 * @author mariano
 */
public class ContentHandler extends ResourceHandler{
    @Override
    public Resource getResource(String path) throws MalformedURLException
    {
        System.out.println(path);
        try
        {
            System.out.println(getResourceBase().replaceAll("file:", "") + path);
            return Resource.newResource(this.getClass().getResource(getResourceBase().replaceAll("file:", "") + path));
        }
        catch(IOException ex)
        {
            return null;
        }
    }
}
