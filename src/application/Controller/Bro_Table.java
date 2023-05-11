package application.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.interact;
import application.Model.Bro_table;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class Bro_Table implements Initializable {
    @FXML
    private TableView<Bro_table> BookingTable;
    @FXML
    private TableColumn<Bro_table, String> idColumn, NameColumn, CMNDColumn, PhoneColumn, tableColumn, DateColumn,
            StartColumn, EndColumn;
    private ObservableList<Bro_table> dataBooking = interact.getBooking();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Bro_table, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Bro_table, String> p) {
                        return (ObservableValue<String>) p.getValue().getIdBooking();
                    }
                });
        NameColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Bro_table, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Bro_table, String> p) {
                        return (ObservableValue<String>) p.getValue().getName();
                    }
                });
        CMNDColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Bro_table, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Bro_table, String> p) {
                        return (ObservableValue<String>) p.getValue().getCMND();
                    }
                });
        PhoneColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Bro_table, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Bro_table, String> p) {
                        return (ObservableValue<String>) p.getValue().getPhone();
                    }
                });
        tableColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Bro_table, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Bro_table, String> p) {
                        return (ObservableValue<String>) p.getValue().getTable();
                    }
                });
        DateColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Bro_table, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Bro_table, String> p) {
                        return (ObservableValue<String>) p.getValue().getBookingDate();
                    }
                });
        StartColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Bro_table, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Bro_table, String> p) {
                        return (ObservableValue<String>) p.getValue().getStartHours();
                    }
                });
        EndColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Bro_table, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Bro_table, String> p) {
                        return (ObservableValue<String>) p.getValue().getEndHours();
                    }
                });
        BookingTable.setItems(dataBooking);
    }

    @FXML
    public void btnDuyetClick(MouseEvent e) {
        // tác động database
    }

}
