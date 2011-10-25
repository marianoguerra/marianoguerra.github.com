/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbook.model;

import java.util.Vector;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariano
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="addressBook")
public class AddressBook {
    @XmlElement(name="entry")
    private Vector<AddressBookEntry> entries;

    public AddressBook() {
        entries = new Vector<AddressBookEntry>();
    }

    public AddressBook(Vector<AddressBookEntry> entries) {
        this.entries = entries;
    }
    
    public Vector<AddressBookEntry> getEntries() {
        return entries;
    }

    public void setEntries(Vector<AddressBookEntry> entries) {
        this.entries = entries;
    }
   
    public void addEntry(AddressBookEntry entry)
    {
        entries.add(entry);
    }
    
    public boolean removeEntry(AddressBookEntry entry)
    {
        return entries.remove(entry);
    }
    
    public Vector<AddressBookEntry> search(String query)
    {
        Vector<AddressBookEntry> result = new Vector<AddressBookEntry>();
        
        result.addAll(searchByFirstName(query));
        result.addAll(searchByLastName(query));
        return result;
    }
    
    public Vector<AddressBookEntry> searchByFirstName(String query)
    {
        Vector<AddressBookEntry> result = new Vector<AddressBookEntry>();
        for(AddressBookEntry entry: entries)
        {
            if(entry.getFirstName().indexOf(query) != -1)
            {
                result.add(entry);
            }
        }
        
        return result;
    }
    
    public Vector<AddressBookEntry> searchByLastName(String query)
    {
        Vector<AddressBookEntry> result = new Vector<AddressBookEntry>();
        for(AddressBookEntry entry: entries)
        {
            if(entry.getLastName().indexOf(query) != -1)
            {
                result.add(entry);
            }
        }
        
        return result;
    }
}