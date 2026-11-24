package hotel.system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelSystem {

    // Display the main menu
    public static void printMenu() {

        System.out.println("\n========== HOTEL MANAGEMENT SYSTEM ==========");
        System.out.println("1. Display All Rooms");
        System.out.println("2. Add New Room");
        System.out.println("3. Search Room By Number");
        System.out.println("4. Search Room By Type");
        System.out.println("5. Sort Rooms By Price");
        System.out.println("6. Display All Guests");
        System.out.println("7. Search Guest By ID");
        System.out.println("8. Create New Booking");
        System.out.println("9. Display All Bookings");
        System.out.println("10. Cancel Booking");
        System.out.println("11. Process Booking Payment");
        System.out.println("12. Display Hotel Report");
        System.out.println("13. New Guest");
        System.out.println("14. Check-in");
        System.out.println("15. Check-out");
        System.out.println("16. Employee Login");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===== 1. Create Services =====
        RoomService roomService = new RoomService();
        GuestService guestService = new GuestService();
        BookingService bookingService = new BookingService();

        // ===== 2. Load Sample Rooms =====
        roomService.addRoom(
                new Room(101, 1, 500.0, true, "Single"));

        roomService.addRoom(
                new Room(102, 2, 800.0, true, "Double"));

        roomService.addRoom(
                new Room(201, 4, 1500.0, true, "Suite"));

        // ===== 3. Load Sample Guests =====
        guestService.addGuest(
                new Guest(1, "Ahmed", "01012345678",
                        "ahmed@gmail.com"));

        guestService.addGuest(
                new Guest(2, "Kero", "01012345679",
                        "kero@gmail.com",
                        "Alexandria", "Egyptian"));

        // ===== 4. Create Employees =====
        ArrayList<Employee> employees = new ArrayList<>();

        Employee employee = new Employee(
                3, "Ali", "01112345678", "ali@gmail.com");

        employee.setUsername("admin");
        employee.setPassword("12345");

        employees.add(employee);

        Admin admin = new Admin(
                4, "Omar", "01212345678", "omar@gmail.com");

        employees.add(admin);

        // ===== 5. Create Hotel =====
        // Hotel shares the same lists with the services
        Hotel hotel = new Hotel(
                roomService.getRooms(),
                employees,
                bookingService.getBookings()
        );

        hotel.setHotelName("Nile Hotel");

        int choice;

        // ===== Main Menu Loop =====
        do {

            printMenu();

            choice = sc.nextInt();

            switch (choice) {

                // ===== 1. Display All Rooms =====
                case 1:

                    System.out.println("\n===== All Rooms =====");

                    roomService.displayRooms();

                    break;

                // ===== 2. Add New Room =====
                case 2:

                    System.out.println("\n===== Add New Room =====");

                    System.out.print("Enter Room Number: ");
                    int roomNumber = sc.nextInt();

                    if (roomService.searchRoom(roomNumber) != null) {
                        System.out.println("Room Number Already Exists!");
                        break;
                    }

                    System.out.print("Enter Capacity: ");
                    int capacity = sc.nextInt();

                    System.out.print("Enter Price Per Night: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Room Type: ");
                    String roomType = sc.next();

                    if (roomNumber <= 0 || capacity <= 0 || price <= 0) {
                        System.out.println("Invalid Room Information!");
                        break;
                    }

                    Room newRoom = new Room(
                            roomNumber,
                            capacity,
                            price,
                            true,
                            roomType
                    );

                    roomService.addRoom(newRoom);

                    break;

                // ===== 3. Search Room By Number =====
                case 3:

                    System.out.println("\n===== Search Room =====");

                    System.out.print("Enter Room Number: ");
                    int searchNumber = sc.nextInt();

                    Room foundRoom
                            = roomService.searchRoom(searchNumber);

                    if (foundRoom != null) {

                        System.out.println("\nRoom Found Successfully!");

                        foundRoom.displayRoomInfo();

                    } else {

                        System.out.println("Room Not Found!");

                    }

                    break;

                // ===== 4. Search Room By Type =====
                case 4:

                    System.out.println("\n===== Search Room By Type =====");

                    System.out.print("Enter Room Type: ");
                    String searchType = sc.next();

                    ArrayList<Room> foundRooms
                            = roomService.searchRoom(searchType);

                    if (!foundRooms.isEmpty()) {

                        System.out.println("\nMatching Rooms:");

                        for (Room room : foundRooms) {

                            room.displayRoomInfo();

                            System.out.println("-------------------");
                        }

                    } else {

                        System.out.println("No Rooms Found With This Type!");

                    }

                    break;

                // ===== 5. Sort Rooms By Price =====
                case 5:

                    System.out.println("\n===== Sort Rooms By Price =====");

                    roomService.sortRoomsByPrice();

                    roomService.displayRooms();

                    break;

                // ===== 6. Display All Guests =====
                case 6:

                    System.out.println("\n===== All Guests =====");

                    guestService.displayGuests();

                    break;

                // ===== 7. Search Guest By ID =====
                case 7:

                    System.out.println("\n===== Search Guest =====");

                    System.out.print("Enter Guest ID: ");
                    int guestId = sc.nextInt();

                    Guest foundGuest
                            = guestService.searchGuest(guestId);

                    if (foundGuest != null) {

                        System.out.println("\nGuest Found!");

                        foundGuest.displayInfo();

                    } else {

                        System.out.println("Guest Not Found!");

                    }

                    break;

                // ===== 8. Create New Booking =====
                case 8:

                    System.out.println("\n===== Create New Booking =====");

                    System.out.print("Enter Booking ID: ");
                    int bookingId = sc.nextInt();

                    if (bookingService.searchBooking(bookingId) != null) {

                        System.out.println("Booking ID Already Exists!");

                        break;
                    }

                    System.out.print("Enter Guest ID: ");
                    int bookingGuestId = sc.nextInt();

                    Guest bookingGuest
                            = guestService.searchGuest(bookingGuestId);

                    if (bookingGuest == null) {

                        System.out.println("Guest Not Found!");

                        break;
                    }

                    System.out.print("Enter Room Number: ");
                    int bookingRoomNumber = sc.nextInt();

                    Room bookingRoom
                            = roomService.searchRoom(bookingRoomNumber);

                    if (bookingRoom == null) {

                        System.out.println("Room Not Found!");

                        break;
                    }

                    if (!bookingRoom.isAvailable()) {

                        System.out.println("Room Is Not Available!");

                        break;
                    }

                    System.out.print(
                            "Enter Check-in Date (YYYY-MM-DD): ");

                    String checkInInput = sc.next();

                    System.out.print(
                            "Enter Check-out Date (YYYY-MM-DD): ");

                    String checkOutInput = sc.next();

                    try {

                        LocalDate checkInDate
                                = LocalDate.parse(checkInInput);

                        LocalDate checkOutDate
                                = LocalDate.parse(checkOutInput);

                        if (!checkOutDate.isAfter(checkInDate)) {

                            System.out.println("Invalid Booking Dates!");

                            break;
                        }

                        Booking newBooking = new Booking(
                                bookingId,
                                bookingGuest,
                                bookingRoom,
                                checkInDate,
                                checkOutDate,
                                BookingStatus.PENDING
                        );

                        // Confirm booking and reserve the room
                        newBooking.confirmBooking();

                        if (newBooking.getStatus()
                                == BookingStatus.CONFIRMED) {

                            bookingService.createBooking(newBooking);

                            System.out.println(
                                    "Total Nights: "
                                    + newBooking.calculateNights());

                            System.out.println(
                                    "Total Price: "
                                    + newBooking.calculateTotalPrice()
                                    + " EGP");
                        }

                    } catch (Exception e) {

                        System.out.println(
                                "Invalid Date! Use YYYY-MM-DD format.");

                    }

                    break;

                // ===== 9. Display All Bookings =====
                case 9:

                    System.out.println("\n===== All Bookings =====");

                    bookingService.displayBookings();

                    break;

                // ===== 10. Cancel Booking =====
                case 10:

                    System.out.println("\n===== Cancel Booking =====");

                    System.out.print("Enter Booking ID: ");
                    int cancelId = sc.nextInt();

                    bookingService.cancelBooking(cancelId);

                    break;

                // ===== 11. Process Booking Payment =====
                case 11:

                    System.out.println(
                            "\n===== Process Booking Payment =====");

                    System.out.print("Enter Booking ID: ");
                    int paymentBookingId = sc.nextInt();

                    Booking paymentBooking
                            = bookingService.searchBooking(paymentBookingId);

                    if (paymentBooking != null) {

                        System.out.println("\nPayment Information:");

                        paymentBooking.getPayment()
                                .displayPaymentInfo();

                        System.out.println("\nProcessing Payment:");

                        paymentBooking.getPayment().processPayment();

                        paymentBooking.getPayment()
                                .displayPaymentInfo();

                    } else {

                        System.out.println("Booking Not Found!");

                    }

                    break;

                // ===== 12. Display Hotel Report =====
                case 12:

                    System.out.println("\n===== Hotel Report =====");

                    hotel.generateReport();

                    break;

                // ===== 13. Add New Guest =====
                case 13:

                    System.out.println("\n===== Add New Guest =====");

                    System.out.print("Enter Guest ID: ");
                    int newGuestId = sc.nextInt();

                    if (guestService.searchGuest(newGuestId) != null) {
                        System.out.println("Guest ID Already Exists!");
                        break;
                    }

                    sc.nextLine(); // Clear input

                    System.out.print("Enter Guest Name: ");
                    String guestName = sc.nextLine();

                    System.out.print("Enter Guest Phone: ");
                    String guestPhone = sc.nextLine();

                    System.out.print("Enter Guest Email: ");
                    String guestEmail = sc.nextLine();

                    System.out.print("Enter Guest Address: ");
                    String guestAddress = sc.nextLine();

                    System.out.print("Enter Guest Nationality: ");
                    String guestNationality = sc.nextLine();

                    if (newGuestId <= 0
                            || guestName.trim().isEmpty()
                            || guestPhone.trim().isEmpty()
                            || guestEmail.trim().isEmpty()) {

                        System.out.println("Invalid Guest Information!");
                        break;
                    }

                    Guest newGuest = new Guest(
                            newGuestId,
                            guestName,
                            guestPhone,
                            guestEmail,
                            guestAddress,
                            guestNationality
                    );

                    guestService.addGuest(newGuest);

                    break;

                // ===== 14. Check-in =====
                case 14:

                    System.out.println("\n===== Guest Check-in =====");

                    System.out.print("Enter Booking ID: ");
                    int checkInId = sc.nextInt();

                    Booking checkInBooking
                            = bookingService.searchBooking(checkInId);

                    if (checkInBooking != null) {

                        checkInBooking.checkIn();

                    } else {

                        System.out.println("Booking Not Found!");

                    }

                    break;

               // ===== 15. Check-out =====
                case 15:

                    System.out.println("\n===== Guest Check-out =====");

                    System.out.print("Enter Booking ID: ");
                    int checkOutId = sc.nextInt();

                    Booking checkOutBooking
                            = bookingService.searchBooking(checkOutId);

                    if (checkOutBooking != null) {

                        checkOutBooking.checkOut();

                    } else {

                        System.out.println("Booking Not Found!");

                    }

                    break;

               // ===== 16. Employee Login =====
                case 16:

                    System.out.println("\n===== Employee Login =====");

                    System.out.print("Enter Username: ");
                    String username = sc.next();

                    System.out.print("Enter Password: ");
                    String password = sc.next();

                    boolean loggedIn = false;

                    for (Employee emp : employees) {

                        if (emp.login(username, password)) {

                            System.out.println("Login Successful!");

                            emp.displayInfo();

                            loggedIn = true;

                            break;
                        }
                    }

                    if (!loggedIn) {

                        System.out.println("Invalid Username Or Password!");

                    }

                    break;

                // ===== 0. Exit =====
                case 0:

                    System.out.println(
                            "Exiting Hotel Management System...");

                    break;

                // ===== Invalid Choice =====
                default:

                    System.out.println("Invalid Choice! Try Again.");

            }

        } while (choice != 0);

        sc.close();

    }
}
