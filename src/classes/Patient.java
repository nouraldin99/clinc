/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Hadi
 */
public class Patient {

    private static Patient instance;
    private int id;
    private String Name;
    private int Age;
    private String Address;
    private int Phone;
    private String Ginder;
    private String State;
    private String Mail;

    private Patient() {

    }

    public static Patient getInstance() {
        if (instance == null) {
            instance = new Patient();
        }
        return instance;
    }

    public static void setInstance(Patient instance) {
        Patient.instance = instance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public void setGinder(String Ginder) {
        this.Ginder = Ginder;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getAddress() {
        return Address;
    }

    public int getPhone() {
        return Phone;
    }

    public String getGinder() {
        return Ginder;
    }

    public String getState() {
        return State;
    }

    public String getMail() {
        return Mail;
    }

    

    public void showMessage() {
        System.out.println("Hello");
    }

}
