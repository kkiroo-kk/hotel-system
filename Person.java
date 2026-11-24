package hotel.system;

//ganral ........>الاب 
//abstract عشان منعملش منو اوبجيكت مباشر 
public abstract class Person {

    protected int id;
    protected String name;
    protected String phone;
    protected String email;

    //Constructor
    public Person(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Display person information
    public abstract void displayInfo();
    
    
    //gets and sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
