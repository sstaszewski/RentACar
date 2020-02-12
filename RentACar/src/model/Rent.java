package model;

import java.util.Date;

public class Rent {
    private int rentID;
    private int carID;
    private int customerID;
//    private Date rentDate;
//    private Date returnDate;

    public Rent(int rentID, int carID, int customerID
//            , Date rentDate, Date returnDate
               ) {
        this.rentID = rentID;
        this.carID = carID;
        this.customerID = customerID;
//        this.rentDate = rentDate;
//        this.returnDate = returnDate;
    }

    public int getRentID() {
        return rentID;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

//    public Date getRentDate() {
//        return rentDate;
//    }
//
//    public void setRentDate(Date rentDate) {
//        this.rentDate = rentDate;
//    }
//
//    public Date getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(Date returnDate) {
//        this.returnDate = returnDate;
//    }
}
