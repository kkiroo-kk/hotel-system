package hotel.system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Entry point used to test the hotel system classes.
 */
public class HotelSystem {

    public static void main(String[] args) {

        // ===== 1. People: inheritance + polymorphism =====
        Guest guest1 = new Guest(1, "Ahmed", "01012345678", "ahmed@gmail.com");
        Guest guest2 = new Guest(2, "Kero", "01012345679", "kero@gmail.com", "Alexandria", "Egyptian");
        Employee employee = new Employee(3, "Ali", "01112345678", "ali@gmail.com");
        Admin admin = new Admin(4, "Omar", "01212345678", "omar@gmail.com");

        Person[] people = {guest1, guest2, employee, admin};
        for (Person p : people) {
            p.displayInfo(); // each class runs its own overridden version
            System.out.println("--------------------");
        }

        // ===== 2. Rooms =====
        Room room1 = new Room(101, 1, 500.0, true, "Single");
        Room room2 = new Room(102, 2, 800.0, true, "Double");
        Room room3 = new Room(201, 4, 1500.0, true, "Suite");

        // ===== 3. Hotel (lists are created here because Hotel has no constructor yet) =====
Hotel hotel = new Hotel(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
hotel.setHotelName("Nile Hotel");

        hotel.getRooms().add(room1);
        hotel.getRooms().add(room2);
        hotel.getRooms().add(room3);
        hotel.getEmployees().add(employee);
        hotel.getEmployees().add(admin);

        System.out.println("Hotel: " + hotel.getHotelName());
        System.out.println("Rooms: " + hotel.getRooms().size());
        for (Room r : hotel.getRooms()) {
            System.out.println("Room " + r.getRoomNumber() + " | " + r.getRoomType()
                    + " | " + r.getPricePerNight() + " EGP | available: " + r.isAvailable());
        }

        // ===== 4. Booking + BookingStatus =====
       Booking booking = new Booking(1, guest1, room2,
        LocalDate.of(2026, 12, 1), LocalDate.of(2026, 12, 4),
        BookingStatus.PENDING);

        System.out.println("\nBooking #" + booking.getBookingId()
                + " for " + booking.getGuest().getName()
                + " | status: " + booking.getStatus());

        booking.setStatus(BookingStatus.CONFIRMED);
        System.out.println("After confirm: " + booking.getStatus());

        // Temporary calculation here until Booking.calculateNights() is implemented
        long nights = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
        double total = nights * booking.getRoom().getPricePerNight();
        System.out.println("Nights: " + nights + " | Total: " + total + " EGP");
    }
}