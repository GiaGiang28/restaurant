package application.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Food;
import application.Item;
import application.interact;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.IntegerPropertyBase;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.NonReadableChannelException;

import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

public class customer implements Initializable {
	private Rectangle recss = new Rectangle();
	private Parent rootParent;
	private Parent back;
	@FXML
	private Rectangle MenuRec, bookingRec, homeRec, staffRec, supplierRec, Bro_bookingRec, QLRec, Dri, Asi, Eur, Des,
			Wine, Sea, FoodRec, BaoCaoRec;
	@FXML
	private Text drinkText, fastfoodText, europeText, asianText, creamText, cakeText, vegetText;
	@FXML
	private ImageView drinkImg, fastFoodImg, europeImg, asianImg, creamImg, cakeImg, vegetImg;
	@FXML
	private Color color;
	@FXML
	private MenuItem DX, DMK;
	@FXML
	private TableView<Item> Table;
	@FXML
	private TableColumn<Item, String> idColumm;
	@FXML
	private TableColumn<Item, String> nameFoodColumm;
	@FXML
	private TableColumn<Item, String> priceColumm;
	@FXML
	private AnchorPane root1;

	@FXML
	private Pagination pagination;
	@FXML
	private Label nameOfFood;
	@FXML
	private Label price;
	@FXML
	private TextArea Descri;
	private interact testInteract = new interact();
	private int idFirst = 0;
	private int totalBill = 0;
	private ObservableList<Item> dataList = interact.getData();
	private PropertyValueFactory<Item, Integer> testFactory = new PropertyValueFactory<>("id");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			rootParent = FXMLLoader.load(getClass().getResource("../Views/IntroBox.fxml"));
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(85);
			back = rootParent;
			root1.getChildren().add(rootParent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idColumm.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(CellDataFeatures<Item, String> p) {
						return (ObservableValue<String>) p.getValue().getIdProperty();
					}
				});
		nameFoodColumm.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(CellDataFeatures<Item, String> p) {
						return (ObservableValue<String>) p.getValue().getNameProperty();
					}
				});
		priceColumm.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(CellDataFeatures<Item, String> p) {
						return (ObservableValue<String>) p.getValue().getPriceProperty();
					}
				});
		// amountColumm.setCellValueFactory(new
		// Callback<TableColumn.CellDataFeatures<Bill,String>,
		// ObservableValue<String>>() {
		// public ObservableValue<String> call(CellDataFeatures<Bill, String> p){
		// return (ObservableValue<String>) p.getValue().getAmountProperty();
		// }
		// });
		// totalColumm.setCellValueFactory(new
		// Callback<TableColumn.CellDataFeatures<Bill,String>,
		// ObservableValue<String>>() {
		// public ObservableValue<String> call(CellDataFeatures<Bill, String> p){
		// return (ObservableValue<String>) p.getValue().getTotalProperty();
		// }
		// });
		// Table.getColumns().addAll(idColumm, nameFoodColumm, priceColumm);
		DMK.setOnAction(e -> DoiMatKhauHover());
		DX.setOnAction(e -> DangXuatHover());
	}

	public void Init(ObservableList<Item> a) {
		pagination.setPageCount(a.size());
		pagination.setPageFactory((Callback<Integer, Node>) new Callback<Integer, Node>() {
			public Node call(Integer pageIndex) {
				// pageIndex = a.size();
				int b = pageIndex + 1;
				nameOfFood.setText(a.get(pageIndex).getNameProperty().get());
				price.setText(a.get(pageIndex).getPriceProperty().get());
				Descri.setText(a.get(pageIndex).getDescriptionProperty().get());
				VBox box = new VBox(5);
				Image testImage = new Image(
						getClass().getResourceAsStream(a.get(pageIndex).getLinkImageProperty().get()));

				// ImageView[] imgView = new ImageView[10];
				// for (int i = 0; i < pageIndex + 10; i++) {
				// imgView[i] = new ImageView(testImage);
				// imgView[i].setFitWidth(20);
				// imgView[i].setFitHeight(20);
				// imgView[i].setSmooth(true);
				// imgView[i].setCache(true);
				// box.getChildren().add(imgView[i]);
				// }
				ImageView imgView2 = new ImageView(testImage);
				imgView2.setFitHeight(400);
				imgView2.setFitWidth(710);
				box.getChildren().add(imgView2);
				Table.setItems(a);
				return box;
			}
		});
	}

	// Test for cake
	public void Init1(Food a) {
		pagination.setPageCount(a.linkImg.size());
		pagination.setPageFactory((Callback<Integer, Node>) new Callback<Integer, Node>() {
			public Node call(Integer pageIndex) {
				nameOfFood.setText(a.nameFood.get(pageIndex));
				price.setText(a.priceFood.get(pageIndex));
				VBox box = new VBox(5);
				Image testImage = new Image(getClass().getResourceAsStream(a.linkImg.get(pageIndex)));

				// ImageView[] imgView = new ImageView[10];
				// for (int i = 0; i < pageIndex + 10; i++) {
				// imgView[i] = new ImageView(testImage);
				// imgView[i].setFitWidth(20);
				// imgView[i].setFitHeight(20);
				// imgView[i].setSmooth(true);
				// imgView[i].setCache(true);
				// box.getChildren().add(imgView[i]);
				// }
				ImageView imgView2 = new ImageView(testImage);
				imgView2.setFitHeight(400);
				imgView2.setFitWidth(710);
				box.getChildren().add(imgView2);
				return box;
			}
		});
	}

	@FXML
	public void hoverMenu(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			MenuRec.setOpacity(1);
		} else if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(dataList);
			root1.getChildren().remove(back);
		} else {
			MenuRec.setOpacity(0);
		}
	}

	public void hoverDri(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			MenuRec.setOpacity(1);
		} else if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(interact.getTypeItem(1));
			root1.getChildren().remove(rootParent);
		} else {
			MenuRec.setOpacity(0.5);
		}
	}

	public void hoverAsi(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			Asi.setOpacity(1);
		} else if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(interact.getTypeItem(2));
			root1.getChildren().remove(rootParent);
		} else {
			Asi.setOpacity(0.5);
		}
	}

	public void hoverEur(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			Eur.setOpacity(1);
		} else if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(interact.getTypeItem(3));
			root1.getChildren().remove(rootParent);
		} else {
			Eur.setOpacity(0.5);
		}
	}

	public void hoverDes(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			Des.setOpacity(1);
		} else if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(interact.getTypeItem(4));
			root1.getChildren().remove(rootParent);
		} else {
			Des.setOpacity(0.5);
		}
	}

	public void hoverWine(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			Wine.setOpacity(1);
		} else if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(interact.getTypeItem(5));
			root1.getChildren().remove(rootParent);
		} else {
			Wine.setOpacity(0.5);
		}
	}

	public void hoverSea(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			Sea.setOpacity(1);
		} else if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(interact.getTypeItem(6));
			root1.getChildren().remove(rootParent);
		} else {
			Sea.setOpacity(0.5);
		}
	}

	public void homeHover(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			try {
				rootParent = FXMLLoader.load(getClass().getResource("../Views/IntroBox.fxml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			back = rootParent;
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(85);
			root1.getChildren().add(rootParent);
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			homeRec.setOpacity(1);
		} else {
			homeRec.setOpacity(0);
		}
	}

	public void bookingHover(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			root1.getChildren().remove(back);
			try {
				rootParent = FXMLLoader.load(getClass().getResource("../Views/booking.fxml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			back = rootParent;
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(85);
			root1.getChildren().add(rootParent);
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			bookingRec.setOpacity(1);
		} else {
			bookingRec.setOpacity(0);
		}
	}

	public void staffHover(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			root1.getChildren().remove(back);
			try {
				rootParent = FXMLLoader.load(getClass().getResource("../Views/staff.fxml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			back = rootParent;
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(85);
			root1.getChildren().add(rootParent);
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			staffRec.setOpacity(1);
		} else {
			staffRec.setOpacity(0);
		}
	}

	public void supplierHover(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			root1.getChildren().remove(back);
			try {
				rootParent = FXMLLoader.load(getClass().getResource("../Views/Supplier.fxml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			back = rootParent;
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(85);
			root1.getChildren().add(rootParent);
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			supplierRec.setOpacity(1);
		} else {
			supplierRec.setOpacity(0);
		}
	}

	public void Bro_BookingHover(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			root1.getChildren().remove(back);
			try {
				rootParent = FXMLLoader.load(getClass().getResource("../Views/Bro_booking.fxml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			back = rootParent;
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(85);
			root1.getChildren().add(rootParent);
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			Bro_bookingRec.setOpacity(1);
		} else {
			Bro_bookingRec.setOpacity(0);
		}
	}

	public void QLHover(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			root1.getChildren().remove(back);
			try {
				rootParent = FXMLLoader.load(getClass().getResource("../Views/Table.fxml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			back = rootParent;
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(85);
			root1.getChildren().add(rootParent);
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			QLRec.setOpacity(1);
		} else {
			QLRec.setOpacity(0);
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

	public void DoiMatKhauHover() {
		root1.getChildren().remove(back);
		try {
			rootParent = FXMLLoader.load(getClass().getResource("../Views/DoiMatKhau.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		back = rootParent;
		rootParent.setLayoutX(228);
		rootParent.setLayoutY(85);
		root1.getChildren().add(rootParent);
	}

	public void DangXuatHover() {
		Stage stage = (Stage) root1.getScene().getWindow();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../Views/Login.fxml"));
			Scene scene = new Scene(root);
			stage.close();
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			stage2.initStyle(StageStyle.TRANSPARENT);
			stage2.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// //stage.initStyle(StageStyle.DECORATED);
		// stage.setScene(scene);
		// //stage.initStyle(StageStyle.TRANSPARENT);
	}

	public void FoodHover(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			root1.getChildren().remove(back);
			try {
				rootParent = FXMLLoader.load(getClass().getResource("../Views/Food.fxml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			back = rootParent;
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(85);
			root1.getChildren().add(rootParent);
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			FoodRec.setOpacity(1);
		} else {
			FoodRec.setOpacity(0);
		}
	}

	public void BaoCaoHover(MouseEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			root1.getChildren().remove(back);
			try {
				rootParent = FXMLLoader.load(getClass().getResource("../Views/BaoCao.fxml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			back = rootParent;
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(85);
			root1.getChildren().add(rootParent);
		} else if (e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			BaoCaoRec.setOpacity(1);
		} else {
			BaoCaoRec.setOpacity(0);
		}
	}
}
