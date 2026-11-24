package hotel.system;


public class Admin extends Employee {

    protected int permissionLevel;

    public Admin(int id, String name, String phone, String email) {
        super(id, name, phone, email);
    }




    @Override
    public void displayInfo() {System.out.println("Admin Name: " + name);
    System.out.println("Admin Email: " + email);
    }

    public void manageRooms() {
    }

    public void manageEmployees() {
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

}
