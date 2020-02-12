package model;

public class Customer {

    private int customerID;
    private String firstName;
    private String lastName;
    private String pesel;

    //      ******** jeszcze poczeka
    //    public void rentACar(model.Car car) {
    //        if(car.returnDate!=null){
    //            System.out.println("you just rent a car!");
    //        }
    //        System.out.println("this car is taken atm.\nPick another one.");
    //    }

    public Customer(int customerID, String firstName, String lastName, String  pesel) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
