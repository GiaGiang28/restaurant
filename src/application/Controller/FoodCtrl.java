package application.Controller;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import application.Item;
import application.interact;
import application.Item;
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

public class FoodCtrl implements Initializable {
    @FXML
    private TableView<Item> staffTable;
    @FXML
    private TableColumn<Item, String> idColumn, NameColumn, EmailColumn, CMNDColumn;
    @FXML
    private TextField t1Name, t2Name, t1Email, t2Email, t1CMND, t2CMND;
    private ObservableList<Item> dataFood = interact.getFood();
    private int a = dataFood.size();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Item, String> p) {
                        return (ObservableValue<String>) p.getValue().getIdProperty();
                    }
                });
        NameColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Item, String> p) {
                        return (ObservableValue<String>) p.getValue().getNameProperty();
                    }
                });
        EmailColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Item, String> p) {
                        return (ObservableValue<String>) p.getValue().getDVTTProperty();
                    }
                });
        CMNDColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Item, String> p) {
                        return (ObservableValue<String>) p.getValue().getPriceProperty();
                    }
                });
        staffTable.setItems(dataFood);

        TableViewSelectionModel selectionModel = staffTable.getSelectionModel();
        ObservableList<Item> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener(new ListChangeListener<Item>() {
            @Override
            public void onChanged(Change<? extends Item> change) {
                t2Name.setText(change.getList().get(0).getNameProperty().get());
                t2Email.setText(change.getList().get(0).getDVTTProperty().get());
                t2CMND.setText(change.getList().get(0).getPriceProperty().get());
            }
        });
    }

    @FXML
    public void btnaddClick(MouseEvent e) {
        Item p = getItem();
        staffTable.getItems().add(p);
        clearFields();
        // Thêm database
    }

    @FXML
    public void deleteSelectedRows() {
        TableViewSelectionModel<Item> tsm = staffTable.getSelectionModel();
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
        Item abc = staffTable.getSelectionModel().getSelectedItem();
        abc.setName(a);
        abc.setDVTT(b);
        abc.setPrice(c);
        staffTable.setItems(dataFood);
    }

    public Item getItem() {
        return new Item(String.valueOf(a + 1), t1Name.getText(), t1Email.getText(), t1CMND.getText(), 1);
    }

    public void clearFields() {
        t1Name.setText(null);
        t1Email.setText(null);
        t1CMND.setText(null);
    }
}
