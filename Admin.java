package hotel.system;

public class Admin extends Employee {

    protected int permissionLevel;

    //Constructor
// Initialize hotel data
    public Admin(int id, String name, String phone, String email) {
        super(id, name, phone, email);
    }

    //show 
    @Override
    public void displayInfo() {
        System.out.println("Admin Name: " + name);
        System.out.println("Admin Email: " + email);
    }

// Display room management options
    public void manageRooms() {
        System.out.println("===== Room Management =====");
        System.out.println("Admin can manage rooms.");
    }

    // Display employee management options
    public void manageEmployees() {
        System.out.println("===== Employee Management =====");
        System.out.println("Admin can manage employees.");
    }

    // gets and sets
    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

}
