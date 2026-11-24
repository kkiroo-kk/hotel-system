package hotel.system;

import java.util.ArrayList;

public class RoomService {

    private ArrayList<Room> rooms;
    // Initialize the rooms list

    public RoomService() {
        rooms = new ArrayList<>();
    }

// Add a new room to the hotel
    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room added successfully!");
    }

// Remove a room using its room number
    public void removeRoom(int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {
                rooms.remove(room);
                System.out.println("Room removed successfully!");
                return;
            }
        }
        System.out.println("Room not found!");
    }

    // Search for a room using its number
    public Room searchRoom(int roomNumber) {

        for (Room room : rooms) {
            if (roomNumber == room.getRoomNumber()) {
                return room;
            }
        }
        return null;
    }
//overloaded
    // Search for rooms by type (overloaded version of searchRoom)
public ArrayList<Room> searchRoom(String roomType) {
    ArrayList<Room> result = new ArrayList<>();

    for (Room room : rooms) {
        if (room.getRoomType().equalsIgnoreCase(roomType)) {
            result.add(room);
        }
    }
    return result;
}
// Display all rooms
    public void displayRooms() {
        for (Room room : rooms) {
            System.out.println("Room Number: " + room.getRoomNumber());
            System.out.println("Room Type: " + room.getRoomType());
            System.out.println("Price: " + room.getPricePerNight());
            System.out.println("Available: " + room.isAvailable());
            System.out.println("-------------------");
        }
    }

// Sort rooms by price from lowest to highest
    public void sortRoomsByPrice() {
        
        for (int i = 0; i < rooms.size(); i++) {

        for (int j = i + 1; j < rooms.size(); j++) {

            if (rooms.get(i).getPricePerNight() >
                rooms.get(j).getPricePerNight()) {

                Room temp = rooms.get(i);

                rooms.set(i, rooms.get(j));

                rooms.set(j, temp);
            }
        }
    }
    System.out.println("Rooms sorted by price successfully!");
    }
    
    
// gets and sets
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

}
