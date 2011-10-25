// AddressBook namespace
var AddressBook = new Object();

AddressBook.AddressBookEntry = function(firstName, lastName, address, homePhone, workPhone, cellPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.cellPhone = cellPhone;
}

// serializa a JSON
AddressBook.AddressBookEntry.prototype.serialize = function()
{
    return JSON.stringify(this);
}

AddressBook.AddressBook = function(entries)
{
    this.entries = entries || [];
}

AddressBook.AddressBook.prototype.serialize = function()
{
    return JSON.stringify(this);
}

// devuelve una funcion que hace un request REST a path, usando method, el
// metodo devuelto recibe como primer parametro una entidad que es enviada
// en el *cuerpo* del request, por ello este metodo es util para PUT y POST
AddressBook.buildCreateUpdate = function(method, path)
{
    return function(entity, success_cb, error_cb)
    {
     $.ajax({url: path, type: method, dataType: "text", contentType: "application/json",
        data: entity.serialize(),
       success: success_cb, error: error_cb}); 
    }
}

// devuelve una funcion que hace un request REST a path, usando method, el
// metodo devuelto recibe como primer un string que es agregado al path
// por ello este metodo es util para GET y DELETE
AddressBook.buildGetDelete = function(method, path)
{
    return function(id, success_cb, error_cb)
    {
     $.ajax({url: path + id, type: method, dataType: "text",
       success: success_cb, error: error_cb}); 
    }
}

AddressBook.getAll = function(success_cb, error_cb)
{
    var request = AddressBook.buildGetDelete("GET", "/ws/book/json/all");
    request("", success_cb, error_cb);
}


AddressBook.search = function(type, query, success_cb, error_cb)
{
    var request = AddressBook.buildGetDelete("GET", "/ws/book/json/search");
    request("/" + type + "/" + query, success_cb, error_cb);
}

AddressBook.create = AddressBook.buildCreateUpdate("PUT", "/ws/book/");