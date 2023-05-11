package application.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class orderdetail {
    private StringProperty NameFood;
    private StringProperty Quantity;
    private StringProperty Price;
    private StringProperty Money;

    public StringProperty getNameFood() {
        return NameFood;
    }

    public StringProperty getQuantity() {
        return Quantity;
    }

    public StringProperty getPrice() {
        return Price;
    }

    public StringProperty getMoney() {
        return Money;
    }

    public orderdetail() {

    }

    public orderdetail(String NameFood, String Quantity, String Price) {
        this.NameFood = new SimpleStringProperty(NameFood);
        this.Quantity = new SimpleStringProperty(Quantity);
        this.Price = new SimpleStringProperty(Price);
        int a = Integer.parseInt(this.Quantity.get()) * Integer.parseInt(this.Price.get());
        this.Money = new SimpleStringProperty(String.valueOf(a));
        // this.Money = new SimpleStringProperty();
    }
}
