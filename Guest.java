package hotel.system;

public class Guest extends Person {

    protected String address;
    protected String nationality;

    
           //Constructor
// Initialize hotel data
    public Guest(int id, String name, String phone, String email, String address, String nationality) {
        super(id, name, phone, email);
        this.address = address;
        this.nationality = nationality;
    }

        //Constructor
// Initialize hotel data
    public Guest(int id, String name, String phone, String email) {
        super(id, name, phone, email);
    }

    // show guest data
    @Override
    public void displayInfo() {
    System.out.println("Guest Name: " + name);
    System.out.println("Guest Email: " + email);
    System.out.println("Guest Address: " + address);
    System.out.println("Guest Nationality: " + nationality);
    }

    
    // Display a booking request message
    public void makeBooking() {
            System.out.println("Guest " + getName() + " is requesting a booking.");
    }

    
// gets and sets
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
