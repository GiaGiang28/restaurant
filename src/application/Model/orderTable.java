package application.Model;

import javafx.collections.ObservableList;

public class orderTable {
    private String idTable;
    private String Capacity;
    private ObservableList<orderdetail> bill;

    public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public ObservableList<orderdetail> getBill() {
        return bill;
    }

    public void setBill(ObservableList<orderdetail> bill) {
        this.bill = bill;
    }
}
