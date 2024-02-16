package edu.ucalgary.oop;

public class Inquirer {

    private final String FIRST_NAME;
    private final String LAST_NAME;
    private final String INFO;
    private final String SERVICES_PHONE;

    public Inquirer(String firstName, String lastName, String servicesPhone, String info){
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.SERVICES_PHONE = servicesPhone;
        this.INFO = info;
    }

    public String getFirstName() {return this.FIRST_NAME; }
    public String getLastName() {return this.LAST_NAME; }
    public String getInfo() {return this.INFO; }
    public String getServicesPhone() {return this.SERVICES_PHONE; }
}