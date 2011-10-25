/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbook.ws;

import addressbook.model.AddressBookEntry;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author mariano
 */
@Path("book")
public class AddressBook {
    private static addressbook.model.AddressBook addressBook;
    
    public static addressbook.model.AddressBook search(String type, String query)
    {
        if(type.equals("firstName"))
        {
            return new addressbook.model.AddressBook(addressBook.searchByFirstName(query));
        }
        else if(type.equals("lastName"))
        {
            return new addressbook.model.AddressBook(addressBook.searchByLastName(query));
        }
        else
        {
            return new addressbook.model.AddressBook(addressBook.search(query));
        }
    }
    
    public static addressbook.model.AddressBook getAddressBook()
    {
        if(addressBook == null)
            addressBook = new addressbook.model.AddressBook();
        
        return addressBook;
    }
    
    public static void fill()
    {
        getAddressBook();
        addressBook.addEntry(new AddressBookEntry("Bob", "Esponja", "Fondo de Bikini 1", "123", "321", "5551"));
        addressBook.addEntry(new AddressBookEntry("Gary", "Caracol", "Fondo de Bikini 2", "234", "432", "5552"));
        addressBook.addEntry(new AddressBookEntry("Arenita", "Ardilla", "Fondo de Bikini 3", "345", "543", "5553"));
        addressBook.addEntry(new AddressBookEntry("Patricio", "Estrella", "Fondo de Bikini 4", "456", "654", "5554"));
        addressBook.addEntry(new AddressBookEntry("Calamardo", "Calamar", "Fondo de Bikini 5", "567", "765", "5555"));
    }
    
    @GET
    @Path("xml/all")
    @Produces("application/xml")
    public static addressbook.model.AddressBook getAllXml()
    {
        return addressBook;
    }
    
    @GET
    @Path("json/all")
    @Produces("application/json")
    public static addressbook.model.AddressBook getAllJson()
    {
        return addressBook;
    }
    
    @GET
    @Path("xml/search/{type}/{query}")
    @Produces("application/xml")
    public static addressbook.model.AddressBook searchXml(@PathParam("type") String type, @PathParam("query") String query)
    {
        return search(type, query);
    }
    
    @GET
    @Path("json/search/{type}/{query}")
    @Produces("application/json")
    public static addressbook.model.AddressBook searchJson(@PathParam("type") String type, @PathParam("query") String query)
    {
        return search(type, query);
    }
    
    @PUT
    @Consumes({"application/json", "application/xml"})
    public static void add(AddressBookEntry entry)
    {
        addressBook.addEntry(entry);
    }
}
