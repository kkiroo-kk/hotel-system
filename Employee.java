package hotel.system;

public class Employee extends Person {

    protected double salary;
    protected String position;
    protected String username;
    protected String password;

        //Constructor
    // Initialize payment details
    public Employee(int id, String name, String phone, String email) {
        super(id, name, phone, email);
    }

    @Override
    public void displayInfo() {
    System.out.println("Employee Name: " + name);
    System.out.println("Employee Email: " + email);
    }
    
// Check employee login credentials
    public boolean login(String username, String password) {
        if (this.username != null && this.password != null
            && this.username.equals(username)
            && this.password.equals(password)) {

        System.out.println("Login successful!");
        return true;

    } else {
        System.out.println("Invalid username or password!");
        return false;
    }
    }
    
    
    
// gets and sets
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
