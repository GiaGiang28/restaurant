package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Item {
	private SimpleStringProperty idd;
	private SimpleStringProperty DVTT;
	private SimpleStringProperty nameOfFood;
	private SimpleStringProperty priceOfFood;
	private SimpleStringProperty DescriptionOfFood;
	private SimpleStringProperty linkImage;

	public StringProperty getIdProperty() {
		return idd;
	}

	public StringProperty getDVTTProperty() {
		return DVTT;
	}

	public StringProperty getNameProperty() {
		return nameOfFood;
	}

	public StringProperty getPriceProperty() {
		return priceOfFood;
	}

	public StringProperty getDescriptionProperty() {
		return DescriptionOfFood;
	}

	public StringProperty getLinkImageProperty() {
		return linkImage;
	}

	public Item() {
		this.idd = new SimpleStringProperty();
		this.nameOfFood = new SimpleStringProperty();
		this.priceOfFood = new SimpleStringProperty();
		this.DescriptionOfFood = new SimpleStringProperty();
	}

	public Item(String id, String nameOfFood, String priceOfFood, String DescriptionOfFood, String linkImage) {
		this.idd = new SimpleStringProperty(id);
		this.nameOfFood = new SimpleStringProperty(nameOfFood);
		this.priceOfFood = new SimpleStringProperty(priceOfFood);
		this.DescriptionOfFood = new SimpleStringProperty(DescriptionOfFood);
		this.linkImage = new SimpleStringProperty(linkImage);
	}

	public Item(String id, String nameOfFood, String DVTT, String priceOfFood, int a) {
		this.idd = new SimpleStringProperty(id);
		this.nameOfFood = new SimpleStringProperty(nameOfFood);
		this.priceOfFood = new SimpleStringProperty(priceOfFood);
		this.DVTT = new SimpleStringProperty(DVTT);
	}

	public Item(String id, String nameOfFood, String priceOfFood) {
		this.idd = new SimpleStringProperty(id);
		this.nameOfFood = new SimpleStringProperty(nameOfFood);
		this.priceOfFood = new SimpleStringProperty(priceOfFood);
		this.DescriptionOfFood = new SimpleStringProperty();
	}

	public Item(String id, String nameOfFood, String priceOfFood, String linkImage) {
		this.idd = new SimpleStringProperty(id);
		this.nameOfFood = new SimpleStringProperty(nameOfFood);
		this.priceOfFood = new SimpleStringProperty(priceOfFood);
		this.DescriptionOfFood = new SimpleStringProperty();
		this.linkImage = new SimpleStringProperty(linkImage);
	}

	public void setId(String id) {
		this.idd.set(id);
	}

	public void setName(String name) {
		this.nameOfFood.set(name);
	}

	public void setPrice(String price) {
		this.priceOfFood.set(price);
	}

	public void setDVTT(String DVT) {
		this.DVTT.set(DVT);
	}
	// public ObservableValue<Integer> idProperty() {
	// ObservableValue<Integer> nesObservableValue = new ObservableValue<Integer>()
	// {
	//
	// };
	// }
}
