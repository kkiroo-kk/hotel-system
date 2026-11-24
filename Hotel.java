package hotel.system;

import java.util.ArrayList;

public class Hotel {

    private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Employee> employees;
    private ArrayList<Booking> bookings;

    public void addEmployee() {
    }

    public Hotel(ArrayList<Room> rooms, ArrayList<Employee> employees, ArrayList<Booking> bookings) {
        this.rooms = rooms;
        this.employees = employees;
        this.bookings = bookings;
    }

    public void displayHotelInfo() {
    }

    public void generateReport() {
    }

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
