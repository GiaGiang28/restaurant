package application.Controller;

import java.io.IOException;

import application.Model.orderTable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class smallTable {
    @FXML
    private HBox box;
    @FXML
    private ImageView imagetable;

    @FXML
    private Label labCapacity, labtable, Status;

    public void setData(orderTable a) {
        labtable.setText("Bàn thứ " + a.getIdTable());
        labCapacity.setText(a.getCapacity() + " chỗ");
        // box.setStyle("-fx-background-color: #03ffff");
    }

    @FXML
    public void hover(MouseEvent e) {
        if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {

        } else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
            box.setStyle("-fx-background-color: #7a4ce4");
        } else {
            box.setStyle("-fx-background-color: #03ffff");
        }
    }
}
