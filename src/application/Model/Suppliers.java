package application.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Suppliers {
    private StringProperty idSupplier;
    private StringProperty NameSupplier;
    private StringProperty Email;
    private StringProperty Address;
    private StringProperty Phone;

    public StringProperty getIdSupplierProperty() {
        return idSupplier;
    }

    public StringProperty getNameSupplierProperty() {
        return NameSupplier;
    }

    public StringProperty getEmailProperty() {
        return Email;
    }

    public StringProperty getAddressProperty() {
        return Address;
    }

    public StringProperty getPhoneProperty() {
        return Phone;
    }

    public Suppliers() {
        this.idSupplier = new SimpleStringProperty();
        this.NameSupplier = new SimpleStringProperty();
        this.Email = new SimpleStringProperty();
        this.Address = new SimpleStringProperty();
        this.Phone = new SimpleStringProperty();
    }

    public Suppliers(String idSupplier, String NameSupplier, String Email, String Address, String Phone) {
        this.idSupplier = new SimpleStringProperty(idSupplier);
        this.NameSupplier = new SimpleStringProperty(NameSupplier);
        this.Email = new SimpleStringProperty(Email);
        this.Address = new SimpleStringProperty(Address);
        this.Phone = new SimpleStringProperty(Phone);
    }

    public void setIdSupplier(String idSupplier) {
        this.idSupplier.set(idSupplier);
    }

    public void setNameSupplier(String nameSupplier) {
        this.NameSupplier.set(nameSupplier);
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    public void setAddress(String Address) {
        this.Address.set(Address);
    }

    public void setPhone(String Phone) {
        this.Phone.set(Phone);
    }
}
