package classes;

public class Facad {

    private Patient patient;
    private static Facad facadeObject;

    private Facad() {
        patient = Patient.getInstance();
    }

    public static Facad getFacadObject() {
        if (facadeObject == null) {
            facadeObject = new Facad();
        }
        return facadeObject;
    }
    
    public void showMessage() {
        patient.showMessage();
    }
    
    public void setId(int id) {
        patient.setId(id);
    }

    public void setName(String Name) {
        patient.setName(Name);
    }

    public void setAge(int Age) {
        patient.setAge(Age);
    }

    public void setAddress(String Address) {
        patient.setAddress(Address);
    }

    public void setPhone(int Phone) {
        patient.setPhone(Phone);
    }

    public void setGinder(String Ginder) {
        patient.setGinder(Ginder);
    }

    public void setState(String State) {
        patient.setState(State);
    }

    public void setMail(String Mail) {
        patient.setMail(Mail);
    }
}
