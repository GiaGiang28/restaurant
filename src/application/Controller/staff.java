package application.Controller;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import application.interact;
import application.Model.Staffs;
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

public class staff implements Initializable {
    @FXML
    private TableView<Staffs> staffTable;
    @FXML
    private TableColumn<Staffs, String> idColumn, NameColumn, EmailColumn, CMNDColumn, PhoneColumn;
    @FXML
    private TextField t1Name, t2Name, t1Email, t2Email, t1CMND, t2CMND, t1Phone, t2Phone;
    private ObservableList<Staffs> dataStaff = interact.getStaff();
    private int a = dataStaff.size();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Staffs, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Staffs, String> p) {
                        return (ObservableValue<String>) p.getValue().getIdStaffProperty();
                    }
                });
        NameColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Staffs, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Staffs, String> p) {
                        return (ObservableValue<String>) p.getValue().getNameProperty();
                    }
                });
        EmailColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Staffs, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Staffs, String> p) {
                        return (ObservableValue<String>) p.getValue().getEmailProperty();
                    }
                });
        CMNDColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Staffs, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Staffs, String> p) {
                        return (ObservableValue<String>) p.getValue().getNumberCMNDProperty();
                    }
                });
        PhoneColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Staffs, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Staffs, String> p) {
                        return (ObservableValue<String>) p.getValue().getPhoneProperty();
                    }
                });

        staffTable.setItems(dataStaff);

        TableViewSelectionModel selectionModel = staffTable.getSelectionModel();
        ObservableList<Staffs> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener(new ListChangeListener<Staffs>() {
            @Override
            public void onChanged(Change<? extends Staffs> change) {
                t2Name.setText(change.getList().get(0).getNameProperty().get());
                t2Email.setText(change.getList().get(0).getEmailProperty().get());
                t2CMND.setText(change.getList().get(0).getNumberCMNDProperty().get());
                t2Phone.setText(change.getList().get(0).getPhoneProperty().get());
            }
        });
    }

    @FXML
    public void btnaddClick(MouseEvent e) {
        Staffs p = getStaffs();
        staffTable.getItems().add(p);
        clearFields();
        // Thêm database
    }

    @FXML
    public void deleteSelectedRows() {
        TableViewSelectionModel<Staffs> tsm = staffTable.getSelectionModel();
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
            staffTable.getItems().remove(selectedIndices[i].intValue());
        }
        // Xóa database
    }

    @FXML
    public void btnUpdateClick(MouseEvent e) {
        String a = t2Name.getText();
        String b = t2Email.getText();
        String c = t2CMND.getText();
        String d = t2Phone.getText();
        Staffs abc = staffTable.getSelectionModel().getSelectedItem();
        abc.setName(a);
        abc.setEmail(b);
        abc.setCMND(c);
        abc.setPhone(d);
        staffTable.setItems(dataStaff);
    }

    public Staffs getStaffs() {
        return new Staffs(String.valueOf(a + 1), t1Name.getText(), t1Email.getText(), t1CMND.getText(),
                t1Phone.getText());
    }

    public void clearFields() {
        t1Name.setText(null);
        t1Email.setText(null);
        t1CMND.setText(null);
        t1Phone.setText(null);
    }

}
