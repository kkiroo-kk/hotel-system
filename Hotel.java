package hotel.system;

import java.util.ArrayList;

public class Hotel {

    private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Employee> employees;
    private ArrayList<Booking> bookings;

    //Constructor
// Initialize hotel data
    public Hotel(ArrayList<Room> rooms, ArrayList<Employee> employees, ArrayList<Booking> bookings) {
        this.rooms = rooms;
        this.employees = employees;
        this.bookings = bookings;
    }

    // Add a new employee to the hotel
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    // Display general hotel information
    public void displayHotelInfo() {
        System.out.println("Hotel Name: " + hotelName);
        System.out.println("Total Rooms: " + rooms.size());
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Total Bookings: " + bookings.size());
    }

    // Generate a hotel report
    public void generateReport() {

        int availableRooms = 0;
        int occupiedRooms = 0;

        // Count available and occupied rooms
        for (Room room : rooms) {

            if (room.isAvailable()) {
                availableRooms++;
            } else {
                occupiedRooms++;
            }
        }
        // Display hotel report
        System.out.println("\n===== Hotel Report =====");
        System.out.println("Hotel Name: " + hotelName);
        System.out.println("Total Rooms: " + rooms.size());
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println("Occupied Rooms: " + occupiedRooms);
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Total Bookings: " + bookings.size());

    }

    //gets and sets
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

}
