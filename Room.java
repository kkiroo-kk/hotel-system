package hotel.system;

public class Room {

    private int roomNumber;
    private int capacity;
    private double pricePerNight;
    private boolean isAvailable;
    private String roomType;

    //Constructor
    // Initialize payment details 
    public Room(int roomNumber, int capacity, double pricePerNight, boolean isAvailable, String roomType) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
        this.roomType = roomType;
    }

// Display all room information
    public void displayRoomInfo() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Capacity: " + capacity);
        System.out.println("Price Per Night: " + pricePerNight);
        System.out.println("Available: " + isAvailable);
        System.out.println("Room Type: " + roomType);
    }

// Check if the room is available
    public void checkAvailability() {
        if (isAvailable) {
            System.out.println("Room is available.");
        } else {
            System.out.println("Room is not available.");
        }
    }

// Update the room price
    public void updatePrice(double newPrice) {
        if (newPrice > 0) {
            pricePerNight = newPrice;
            System.out.println("Room price updated successfully!");
        } else {
            System.out.println("Invalid price!");
        }
    }

    // gets and sets
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setisAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

}
