package application.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Staffs {
    private StringProperty idStaff;
    private StringProperty Name;
    private StringProperty Email;
    private StringProperty NumberCMND;
    private StringProperty Phone;

    public StringProperty getIdStaffProperty() {
        return idStaff;
    }

    public StringProperty getNameProperty() {
        return Name;
    }

    public StringProperty getEmailProperty() {
        return Email;
    }

    public StringProperty getNumberCMNDProperty() {
        return NumberCMND;
    }

    public StringProperty getPhoneProperty() {
        return Phone;
    }

    public Staffs() {
        this.idStaff = new SimpleStringProperty();
        this.Name = new SimpleStringProperty();
        this.Email = new SimpleStringProperty();
        this.NumberCMND = new SimpleStringProperty();
        this.Phone = new SimpleStringProperty();
    }

    public Staffs(String id, String name, String email, String CMND, String Phone) {
        this.idStaff = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(name);
        this.Email = new SimpleStringProperty(email);
        this.NumberCMND = new SimpleStringProperty(CMND);
        this.Phone = new SimpleStringProperty(Phone);
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    public void setCMND(String CMND) {
        this.NumberCMND.set(CMND);
    }

    public void setPhone(String Phone) {
        this.Phone.set(Phone);
    }
}
