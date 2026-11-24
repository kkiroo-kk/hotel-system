package hotel.system;

public class Employee extends Person {

    protected double salary;
    protected String position;
    protected String username;
    protected String password;

    public Employee(int id, String name, String phone, String email) {
        super(id, name, phone, email);
    }

    @Override
    public void displayInfo() {
    System.out.println("Employee Name: " + name);
    System.out.println("Employee Email: " + email);
    }

    public void login() {
    }

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
