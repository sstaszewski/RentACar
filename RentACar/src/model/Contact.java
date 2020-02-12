package model;

public class Contact {

    private int contactID;
    private String email;
    private String street;
    private String city;
    private int phone;


    public Contact(int contactID, String email, String street, String city, int phone) {
        this.contactID = contactID;
        this.email = email;
        this.street = street;
        this.city = city;
        this.phone = phone;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
