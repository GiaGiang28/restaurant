package application.Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import application.interact;
import javafx.scene.control.Label;

public class signIn {
	@FXML
	private ImageView FbImg, InsImg, GgImg;
	@FXML
	private Text FbText, GgText, InsText;
	@FXML
	private Rectangle FbRec, GgRec, InsRec;
	@FXML
	private ImageView CloseBt;
	@FXML
	private AnchorPane root1;
	@FXML
	private Label alert;
	@FXML
	private Rectangle cusRec, qrRec;
	@FXML
	private Text cusText;
	@FXML
	private Rectangle signinRec1, signinRec2;
	@FXML
	private Text signinText;
	@FXML
	private TextField idTextField;
	@FXML
	private PasswordField passwordField;
	private interact check;

	public void FaceBook(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			FbText.setText("facebook.com");
			FbRec.setWidth(200);
			FbRec.setHeight(30);
			FbText.setOpacity(1);
			FbRec.setOpacity(1);
		} else if (e.getEventType() == MouseEvent.MOUSE_EXITED) {
			FbText.setText("");
			FbRec.setWidth(30);
			FbRec.setHeight(30);
			FbText.setOpacity(0);
			FbRec.setOpacity(0);
		} else {

		}
	}

	public void Google(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			GgText.setText("google.com");
			GgRec.setWidth(200);
			GgRec.setHeight(30);
			GgText.setOpacity(1);
			GgRec.setOpacity(1);
		} else if (e.getEventType() == MouseEvent.MOUSE_EXITED) {
			GgText.setText("");
			GgRec.setWidth(30);
			GgRec.setHeight(30);
			GgText.setOpacity(0);
			GgRec.setOpacity(0);
		} else {

		}
	}

	public void Instagram(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			InsText.setText("instagram.com");
			InsRec.setWidth(200);
			InsRec.setHeight(30);
			InsText.setOpacity(1);
			InsRec.setOpacity(1);
		} else if (e.getEventType() == MouseEvent.MOUSE_EXITED) {
			InsText.setText("");
			InsRec.setWidth(30);
			InsRec.setHeight(30);
			InsText.setOpacity(0);
			InsRec.setOpacity(0);
		} else {

		}
	}

	public void Close(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Stage stage = (Stage) root1.getScene().getWindow();
			stage.close();
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {

		} else {

		}
	}

	public void Customer(MouseEvent e) throws IOException {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Stage stage = (Stage) root1.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
			Scene scene = new Scene(root);
			// //stage.initStyle(StageStyle.DECORATED);
			// stage.setScene(scene);
			// //stage.initStyle(StageStyle.TRANSPARENT);
			stage.close();
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.initStyle(StageStyle.TRANSPARENT);
			stage2.show();
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			cusRec.setOpacity(0.5);
		} else {
			cusRec.setOpacity(0);
		}
	}

	public void qrCode(MouseEvent e) throws IOException {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Parent root = FXMLLoader.load(getClass().getResource("Qrcode.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			// stage.initStyle(StageStyle.TRANSPARENT);
			stage.show();
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			qrRec.setOpacity(0.5);
		} else {
			qrRec.setOpacity(0);
		}
	}

	public void signin(MouseEvent e) throws IOException {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			signinRec2.setLayoutX(500);
			signinRec2.setLayoutY(500);
			signinRec1.setLayoutX(402);
			signinRec1.setLayoutY(431);
			signinText.setLayoutX(449);
			signinText.setLayoutY(467);
			signinRec2.setOpacity(0);
		} else if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			check = new interact();
			String id = idTextField.getText();
			String pass = passwordField.getText();
			if (!check.idEmail(id)) {
				// alert.setText("id doesn't exist");
				alert.setText("id doesn't exist");
			} else {
				if (check.checkPass(id, pass)) {
					// alert.setText("Welcome");
					alert.setText("Welcome " + id);
					Stage stage = (Stage) root1.getScene().getWindow();
					Parent root = FXMLLoader.load(getClass().getResource("../Views/Customer.fxml"));
					Scene scene = new Scene(root);
					// //stage.initStyle(StageStyle.DECORATED);
					// stage.setScene(scene);
					// //stage.initStyle(StageStyle.TRANSPARENT);
					stage.close();
					Stage stage2 = new Stage();
					stage2.setScene(scene);
					stage2.initStyle(StageStyle.TRANSPARENT);
					stage2.show();
				} else {
					// alert.setText("password was false");
					alert.setText("Password was false");
				}
			}
			idTextField.clear();
			passwordField.clear();
		} else {
			signinRec1.setLayoutX(396);
			signinRec1.setLayoutY(426);
			signinRec2.setLayoutX(402);
			signinRec2.setLayoutY(431);
			signinText.setLayoutX(443);
			signinText.setLayoutY(462);
			signinRec2.setOpacity(1);
		}
	}
}
