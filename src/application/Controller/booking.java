package application.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import application.interact;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class booking {
    @FXML
    private TextField ttTable, Start, End;
    @FXML
    private DatePicker Date;

    @FXML
    public void btnDat(MouseEvent e) {
        String tt = ttTable.getText();
        String start = Start.getText();
        String end = End.getText();
        LocalDate local = Date.getValue();
        String date = local.toString();
        Connection conn = interact.getJbdcConnection();
    }
}
