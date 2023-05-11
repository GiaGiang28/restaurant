package application.Controller;

import application.Item;
import application.interact;
import application.Model.orderTable;
import application.Model.orderdetail;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class QLTable implements Initializable {
    private ObservableList<String> Capa = interact.getCapacity();
    private List<orderTable> recent;
    private orderTable[] ordertable = new orderTable[20];
    @FXML
    private FlowPane Pane;
    @FXML
    private Label LabName, LabPrice, STTTable, LableTotal;
    @FXML
    private TextField LabQuantity;
    @FXML
    private TableView<orderdetail> Table;
    @FXML
    private TableColumn<orderdetail, String> MoneyColumn, NameColumn, PriceColumn, QuantityColumn;
    @FXML
    private Pagination pagination;
    private int TotalMoney = 0;
    private ObservableList<Item> dataList = interact.getData();
    private ObservableList<orderdetail> orderDetailList = interact.getOderdetail();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // STTTable.setText("gia giang");
        recent = recentOrders();
        try {
            for (int i = 0; i < recent.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../Views/smalltable.fxml"));
                HBox tablebox = fxmlLoader.load();
                smallTable small = fxmlLoader.getController();
                small.setData(recent.get(i));
                String text = String.valueOf(i + 1);
                tablebox.setOnMouseClicked(e -> {
                    STTTable.setText(text);
                });
                Pane.getChildren().add(tablebox);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Init(dataList);
        NameColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<orderdetail, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<orderdetail, String> p) {
                        return (ObservableValue<String>) p.getValue().getNameFood();
                    }
                });
        QuantityColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<orderdetail, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<orderdetail, String> p) {
                        return (ObservableValue<String>) p.getValue().getQuantity();
                    }
                });
        PriceColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<orderdetail, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<orderdetail, String> p) {
                        return (ObservableValue<String>) p.getValue().getPrice();
                    }
                });
        MoneyColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<orderdetail, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<orderdetail, String> p) {
                        return (ObservableValue<String>) p.getValue().getMoney();
                    }
                });
        Table.setItems(orderDetailList);
        for (orderdetail order : orderDetailList) {
            TotalMoney = TotalMoney + Integer.parseInt(order.getMoney().get());
        }
        LableTotal.setText(String.valueOf(TotalMoney));
    }

    public void Init(ObservableList<Item> a) {
        pagination.setPageCount(a.size());
        pagination.setPageFactory((Callback<Integer, Node>) new Callback<Integer, Node>() {
            public Node call(Integer pageIndex) {
                // pageIndex = a.size();
                int b = pageIndex + 1;
                LabName.setText(a.get(pageIndex).getNameProperty().get());
                LabPrice.setText(a.get(pageIndex).getPriceProperty().get());
                VBox box = new VBox(5);
                Image testImage = new Image(
                        getClass().getResourceAsStream(a.get(pageIndex).getLinkImageProperty().get()));
                ImageView imgView2 = new ImageView(testImage);
                imgView2.setFitHeight(400);
                imgView2.setFitWidth(710);
                box.getChildren().add(imgView2);
                return box;
            }
        });
    }

    @FXML
    public void choseFood(MouseEvent e) {
        if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
            orderdetail order = new orderdetail(LabName.getText(), LabQuantity.getText(), LabPrice.getText());
            orderDetailList.add(order);
            TotalMoney = TotalMoney + Integer.parseInt(order.getMoney().get());
            Table.setItems(orderDetailList);
            LableTotal.setText(String.valueOf(TotalMoney));
        }
    }

    @FXML
    private void btnPayClick(MouseEvent e) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../Views/Payment.fxml"));
            Scene scene = new Scene(root);
            Stage stage2 = new Stage();
            stage2.setScene(scene);
            stage2.initStyle(StageStyle.TRANSPARENT);
            stage2.show();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    private List<orderTable> recentOrders() {
        List<orderTable> ls = new ArrayList<orderTable>();
        for (int i = 0; i < 20; ++i) {
            ordertable[i] = new orderTable();
            ordertable[i].setIdTable(String.valueOf(i + 1));
            ordertable[i].setCapacity(Capa.get(i));
            ls.add(ordertable[i]);
        }
        return ls;
    }
}
