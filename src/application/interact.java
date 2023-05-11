package application;

import java.sql.*;
import java.util.ArrayList;
import application.Food;
import application.Model.Bro_table;
import application.Model.Staffs;
import application.Model.Suppliers;
import application.Model.orderdetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class interact {
	private static String urlString = "jdbc:mysql://localhost:3306/test1234";
	private static String userString = "root";
	private static String passString = "root";

	// private void freeList() {
	// data.clear();
	// }

	public static Connection getJbdcConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				return DriverManager.getConnection(urlString, userString, passString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ObservableList<Item> getData() {
		ObservableList<Item> data = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from item;");
			Item item;
			while (resultSet.next()) {
				item = new Item(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
				data.add(item);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return data;
	}

	public static ObservableList<Item> getTypeItem(int a) {
		ObservableList<Item> data = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from item where TypeItem_idTypeItem = " + a + ";");
			Item item;
			while (resultSet.next()) {
				item = new Item(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
				data.add(item);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return data;
	}

	public static ObservableList<Staffs> getStaff() {
		ObservableList<Staffs> data = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from staff;");
			Staffs staff;
			while (resultSet.next()) {
				staff = new Staffs(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				data.add(staff);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return data;
	}

	public static ObservableList<Suppliers> getSupplier() {
		ObservableList<Suppliers> data = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from supplier;");
			Suppliers supplier;
			while (resultSet.next()) {
				supplier = new Suppliers(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				data.add(supplier);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return data;
	}

	public static ObservableList<Bro_table> getBooking() {
		ObservableList<Bro_table> data = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"select idBooking_table, Name, NumberCMND, Phone,tabless_idTable, BookingDate, StartHour, EndHour from customer inner join booking_table on idCustomer = customer_idCustomer where Status = 0;");
			Bro_table a;
			while (resultSet.next()) {
				a = new Bro_table(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getString(7), resultSet.getString(8));
				data.add(a);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return data;
	}

	public static ObservableList<String> getCapacity() {
		ObservableList<String> data = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT Capacity FROM tabless;");
			String a;
			while (resultSet.next()) {
				a = resultSet.getString(1);
				data.add(a);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return data;
	}

	public static ObservableList<orderdetail> getOderdetail() {
		ObservableList<orderdetail> data = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"select item.Name_FoodItem, Quantily, item.Price from orders inner join orderdetail on idOrders =  orders_idOrders inner join tabless on idTable = tabless_idTable inner join item on Item_idItem = idItem where idOrders = 4;");
			orderdetail a;
			while (resultSet.next()) {
				a = new orderdetail(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
				data.add(a);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return data;
	}

	public static ObservableList<Item> getFood() {
		ObservableList<Item> data = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT idItem, Name_FoodItem, Calculation_Unit, Price FROM item;");
			Item a;
			while (resultSet.next()) {
				a = new Item(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), 1);
				data.add(a);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return data;
	}

	public boolean idEmail(String Email) {
		try {
			String test1 = "0";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select Email from users where Email = '" + Email + "';");
			while (resultSet.next()) {
				test1 = resultSet.getString(1);
			}
			connection.close();
			if (test1.equals("0"))
				return false;
			else
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return false;
	}

	public boolean checkPass(String Email, String pass) {
		try {
			String test1 = "0";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select Passwords from users where Email = '" + Email + "';");
			// while(resultSet.next()) {
			// idList.add(resultSet.getString(1));
			// nameList.add(resultSet.getString(2));
			// passList.add(resultSet.getString(3));
			// }
			while (resultSet.next()) {
				test1 = resultSet.getString(1);
			}
			connection.close();
			if (test1.equals(pass))
				return true;
			else
				return false;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return false;
	}

	public String getName(String id) {
		try {
			int test = Integer.parseInt(id);
			String test1 = "0";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlString, userString, passString);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select namest" + "\nfrom hailonget1.staff" + "\nwhere id = " + test + ";");
			// while(resultSet.next()) {
			// idList.add(resultSet.getString(1));
			// nameList.add(resultSet.getString(2));
			// passList.add(resultSet.getString(3));
			// }
			while (resultSet.next()) {
				test1 = resultSet.getString(1);
			}
			connection.close();
			return test1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return "dont";
	}
}
