package hotel.system;

import java.util.ArrayList;

public class BookingService {

    private ArrayList<Booking> bookings;

    // Initialize the bookings list
public BookingService() {
    bookings = new ArrayList<>();
}
    
    // Add a new booking to the list
    public void createBooking(Booking booking) {
        bookings.add(booking);
    System.out.println("Booking created successfully!");
    }
    
// Cancel a booking using its ID
    public void cancelBooking(int bookingId) {    
        
        Booking booking = searchBooking(bookingId);
        
    if (booking != null) {
        booking.cancelBooking();
    } else {
        System.out.println("Booking not found!");
    }
    }
    
// Search for a booking using its ID
    public Booking  searchBooking(int bookingId) {
        for (Booking booking : bookings) {

        if (booking.getBookingId() == bookingId) {
            return booking;
        }
    }
    return null;
    }
    
// Display all bookings
    public void displayBookings() {
        for (Booking booking : bookings) {

        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Guest Name: " + booking.getGuest().getName());
        System.out.println("Room Number: " + booking.getRoom().getRoomNumber());
        System.out.println("Check-in: " + booking.getCheckInDate());
        System.out.println("Check-out: " + booking.getCheckOutDate());
        System.out.println("Status: " + booking.getStatus());
        System.out.println("Total Price: " + booking.calculateTotalPrice());
        System.out.println("-------------------");
    }
    }

    // gets and sets
    
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

}
