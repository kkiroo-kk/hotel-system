package hotel.system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {

    private int bookingId;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BookingStatus status;
    private Payment payment; // Payment object associated with this booking

    //Constructor
    public Booking(int bookingId, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate, BookingStatus status) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        // Create a payment object for this booking
        this.payment = new Payment(
                bookingId,
                calculateTotalPrice(),
                "Cash"
        );
    }

    // Calculate the number of nights between check-in and check-out
    public long calculateNights() {
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    // Calculate the total booking price
    public double calculateTotalPrice() {
        return calculateNights() * room.getPricePerNight();
    }

    // Confirm the booking if the room is available
    public void confirmBooking() {
        if (status == BookingStatus.PENDING && room.isAvailable()) {

            status = BookingStatus.CONFIRMED;
            room.setisAvailable(false);

            System.out.println("Booking confirmed successfully!");

        } else {

            System.out.println("Cannot confirm this booking.");

        }
    }

    // Cancel a pending or confirmed booking
    public void cancelBooking() {
        if (status == BookingStatus.PENDING
                || status == BookingStatus.CONFIRMED) {

            status = BookingStatus.CANCELLED;
            room.setisAvailable(true);

            System.out.println("Booking cancelled successfully!");

        } else {

            System.out.println("Cannot cancel this booking.");
        }
    }

// Check in the guest if the booking is confirmed
    public void checkIn() {
        if (status == BookingStatus.CONFIRMED) {
            status = BookingStatus.CHECKED_IN;

            System.out.println("Guest checked in successfully!");

        } else {

            System.out.println("Cannot check in. Booking is not confirmed.");
        }
    }

// Check out the guest and make the room availabl
    public void checkOut() {
        if (status == BookingStatus.CHECKED_IN) {
            status = BookingStatus.CHECKED_OUT;
            room.setisAvailable(true);
            System.out.println("Guest checked out successfully!");
        } else {
            System.out.println("Cannot check out. Guest is not checked in.");
        }
    }
// gets and sets

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }
}
