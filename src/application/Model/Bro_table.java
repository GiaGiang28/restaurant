package application.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Bro_table {
    private StringProperty idBooking;
    private StringProperty Name;
    private StringProperty CMND;
    private StringProperty Phone;
    private StringProperty table;
    private StringProperty BookingDate;
    private StringProperty StartHours;
    private StringProperty EndHours;

    public StringProperty getIdBooking() {
        return idBooking;
    }

    public StringProperty getName() {
        return Name;
    }

    public StringProperty getCMND() {
        return CMND;
    }

    public StringProperty getPhone() {
        return Phone;
    }

    public StringProperty getTable() {
        return table;
    }

    public StringProperty getBookingDate() {
        return BookingDate;
    }

    public StringProperty getStartHours() {
        return StartHours;
    }

    public StringProperty getEndHours() {
        return EndHours;
    }

    public Bro_table() {

    }

    public Bro_table(String idBooking, String Name, String CMND, String Phone, String table, String BookingDate,
            String StartHours, String EndHours) {
        this.idBooking = new SimpleStringProperty(idBooking);
        this.Name = new SimpleStringProperty(Name);
        this.CMND = new SimpleStringProperty(CMND);
        this.Phone = new SimpleStringProperty(Phone);
        this.table = new SimpleStringProperty(table);
        this.BookingDate = new SimpleStringProperty(BookingDate);
        this.StartHours = new SimpleStringProperty(StartHours);
        this.EndHours = new SimpleStringProperty(EndHours);
    }
}
