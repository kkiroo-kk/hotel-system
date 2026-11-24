package hotel.system;


public class Room {

    private int roomNumber;
    private int capacity;
    private double pricePerNight;
    private boolean isAvailable;
    private String roomType;

    public Room(int roomNumber, int capacity, double pricePerNight, boolean isAvailable, String roomType) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
        this.roomType = roomType;
    }



    public void displayRoomInfo() {
    }

    public void checkAvailability() {
    }

    public void updatePrice() {
    }

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
