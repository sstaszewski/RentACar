package rentacar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Car;
import model.Customer;
import model.Rent;

public class RentACar {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:rentacar.db";

    private Connection connection;
    private Statement statement;

    public RentACar() {
        try {
            Class.forName(RentACar.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
        createTables();
    }

    public boolean createTables() {
        String createCustomers = "CREATE TABLE IF NOT EXISTS customers (customerID INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, firstName varchar(255), lastName varchar(255), pesel int)";
        String createCars =
                "CREATE TABLE IF NOT EXISTS cars (carID INTEGER PRIMARY KEY AUTOINCREMENT, " + "carName " + "varchar" + "(255), price double)";
        String createRents = "CREATE TABLE IF NOT EXISTS rentHistory (rentID INTEGER PRIMARY KEY " + "AUTOINCREMENT, "
                + "customerID int, carID int)";
        try {
            statement.execute(createCustomers);
            statement.execute(createCars);
            statement.execute(createRents);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertCustomer(String firstName, String lastName, String pesel) {
        try {
            PreparedStatement prepStmt = connection.prepareStatement("insert into customers values (NULL, ?, ?, ?);");
            prepStmt.setString(1, firstName);
            prepStmt.setString(2, lastName);
            prepStmt.setString(3, pesel);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertCar(String carName, double price) {
        try {
            PreparedStatement prepStmt = connection.prepareStatement("insert into cars values (NULL, ?, ?);");
            prepStmt.setString(1, carName);
            prepStmt.setDouble(2, price);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wypozyczaniu");
            return false;
        }
        return true;
    }

    public boolean insertRent(int customerID, int carID) {
        try {
            PreparedStatement prepStmt = connection.prepareStatement("insert into rentHistory values (NULL, ?, ?);");
            prepStmt.setInt(1, customerID);
            prepStmt.setInt(2, carID);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wypozyczaniu");
            return false;
        }
        return true;
    }

    public List<Customer> selectCustomers() {
        List<Customer> customers = new LinkedList<Customer>();
        try {
            ResultSet result = statement.executeQuery("SELECT * FROM customers");
            int id;
            String firstName, lastName, pesel;
            while (result.next()) {
                id = result.getInt("customerID");
                firstName = result.getString("firstName");
                lastName = result.getString("lastName");
                pesel = result.getString("pesel");
                customers.add(new Customer(id, firstName, lastName, pesel));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return customers;
    }

    public List<Car> selectCars() {
        List<Car> cars = new LinkedList<Car>();
        try {
            ResultSet result = statement.executeQuery("SELECT * FROM cars");
            int id;
            String carName, price;
            while (result.next()) {
                id = result.getInt("carID");
                carName = result.getString("carName");
                price = result.getString("price");
                cars.add(new Car(id, carName, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return cars;
    }

    public List<Rent> selectRents() {
        List<Rent> rents = new LinkedList<Rent>();
        try {
            ResultSet result = statement.executeQuery("SELECT * FROM rentHistory");
            int id, customerID, carID;
            while (result.next()) {
                id = result.getInt("rentID");
                customerID = result.getInt("customerID");
                carID = result.getInt("carID");
                rents.add(new Rent(id, customerID, carID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rents;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}
