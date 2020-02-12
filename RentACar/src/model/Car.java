package model;

public class Car {

    private int carID;
    private String carName;
    private String price;




    public Car(int carID, String carName, String price) {
        this.carID = carID;
        this.carName = carName;
        this.price = price;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
