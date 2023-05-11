package application.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Payment {
    @FXML
    private Label Category;
    @FXML
    private AnchorPane Root;

    @FXML
    private void Tien(MouseEvent e) {
        Category.setText("Tiền Mặt");
    }

    @FXML
    private void Bank(MouseEvent e) {
        Category.setText("Banking");
    }

    @FXML
    private void VN(MouseEvent e) {
        Category.setText("VNPay");
    }

    @FXML
    private void Mo(MouseEvent e) {
        Category.setText("MoMo");
    }

    @FXML
    private void XacNhan(MouseEvent e) {
        Stage stage = (Stage) Root.getScene().getWindow();
        stage.close();
    }
}
