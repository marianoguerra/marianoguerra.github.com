/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbook.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariano
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="addressBookEntry")
public class AddressBookEntry implements Serializable{
    private String firstName;
    private String lastName;
    private String address;
    private String homePhone;
    private String workPhone;
    private String cellPhone;

    public AddressBookEntry() {
    }

    public AddressBookEntry(String firstName, String LastName, String address, String homePhone, String workPhone, String cellPhone) {
        this.firstName = firstName;
        this.lastName = LastName;
        this.address = address;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.cellPhone = cellPhone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
    
    
}
