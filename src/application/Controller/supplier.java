package application.Controller;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import application.interact;
import application.Model.Suppliers;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class supplier implements Initializable {
    @FXML
    private TableView<Suppliers> supplierTable;
    @FXML
    private TableColumn<Suppliers, String> idColumn, NameColumn, EmailColumn, AddressColumn, PhoneColumn;
    @FXML
    private TextField t1Name, t2Name, t1Email, t2Email, t1Address, t2Address, t1Phone, t2Phone;
    private ObservableList<Suppliers> dataSupplier = interact.getSupplier();
    private int a = dataSupplier.size();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Suppliers, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Suppliers, String> p) {
                        return (ObservableValue<String>) p.getValue().getIdSupplierProperty();
                    }
                });
        NameColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Suppliers, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Suppliers, String> p) {
                        return (ObservableValue<String>) p.getValue().getNameSupplierProperty();
                    }
                });
        EmailColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Suppliers, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Suppliers, String> p) {
                        return (ObservableValue<String>) p.getValue().getEmailProperty();
                    }
                });
        AddressColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Suppliers, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Suppliers, String> p) {
                        return (ObservableValue<String>) p.getValue().getAddressProperty();
                    }
                });
        PhoneColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Suppliers, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Suppliers, String> p) {
                        return (ObservableValue<String>) p.getValue().getPhoneProperty();
                    }
                });

        supplierTable.setItems(dataSupplier);
        TableViewSelectionModel selectionModel = supplierTable.getSelectionModel();
        ObservableList<Suppliers> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener(new ListChangeListener<Suppliers>() {
            @Override
            public void onChanged(Change<? extends Suppliers> change) {
                t2Name.setText(change.getList().get(0).getNameSupplierProperty().get());
                t2Email.setText(change.getList().get(0).getEmailProperty().get());
                t2Address.setText(change.getList().get(0).getAddressProperty().get());
                t2Phone.setText(change.getList().get(0).getPhoneProperty().get());
            }
        });
    }

    @FXML
    public void btnaddClick(MouseEvent e) {
        Suppliers p = getSupplier();
        supplierTable.getItems().add(p);
        clearFields();
        // Thêm database
    }

    @FXML
    public void deleteSelectedRows() {
        TableViewSelectionModel<Suppliers> tsm = supplierTable.getSelectionModel();
        if (tsm.isEmpty()) {
            System.out.println("Please select a row to delete.");
            return;
        }
        // Get all selected row indices in an array
        ObservableList<Integer> list = tsm.getSelectedIndices();
        Integer[] selectedIndices = new Integer[list.size()];
        selectedIndices = list.toArray(selectedIndices);
        // Sort the array
        Arrays.sort(selectedIndices);
        // Delete rows (last to first)
        for (int i = selectedIndices.length - 1; i >= 0; i--) {
            tsm.clearSelection(selectedIndices[i].intValue());
            supplierTable.getItems().remove(selectedIndices[i].intValue());
        }
        // Xóa database
    }

    @FXML
    public void btnUpdateClick(MouseEvent e) {
        String a = t2Name.getText();
        String b = t2Email.getText();
        String c = t2Address.getText();
        String d = t2Phone.getText();
        Suppliers abc = supplierTable.getSelectionModel().getSelectedItem();
        abc.setNameSupplier(a);
        abc.setEmail(b);
        abc.setAddress(c);
        abc.setPhone(d);
        supplierTable.setItems(dataSupplier);
    }

    public Suppliers getSupplier() {
        return new Suppliers(String.valueOf(a + 1), t1Name.getText(), t1Email.getText(), t1Address.getText(),
                t1Phone.getText());
    }

    public void clearFields() {
        t1Name.setText(null);
        t1Email.setText(null);
        t1Address.setText(null);
        t1Phone.setText(null);
    }
}
