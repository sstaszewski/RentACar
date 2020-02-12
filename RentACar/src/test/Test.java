package test;
import java.util.List;

import model.Customer;
import model.Car;
import rentacar.RentACar;

public class Test {

    public static void main(String[] args) {
        RentACar rentTest = new RentACar();
        rentTest.insertCustomer("Karol", "Maciaszek", "92873847182");
        rentTest.insertCustomer("Piotr", "Wojtecki", "89273849128");
        rentTest.insertCustomer("Abdul", "Dabdul", "");

        rentTest.insertCar("Maluch", 20.0);
        rentTest.insertCar("Focus", 50);
        rentTest.insertCar("Tesla", 150.4);

        List<Customer> customers = rentTest.selectCustomers();
        List<Car> cars = rentTest.selectCars();

        System.out.println("Lista klientow: ");
        for(Customer c: customers)
            System.out.println(c);

        System.out.println("Lista samochodow: ");
        for(Car k: cars)
            System.out.println(k);

        rentTest.closeConnection();
    }
}