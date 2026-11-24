package hotel.system;

import java.util.ArrayList;

public class GuestService {

    private ArrayList<Guest> guests;

    public GuestService() {
        guests = new ArrayList<>();
    }

    // add Guest
    public void addGuest(Guest guest) {
        guests.add(guest);
        System.out.println("Guest added successfully!");
    }

    // search to Guest
    public Guest searchGuest(int id) {
        for (Guest guest : guests) {
            if (guest.getId() == id) {
                return guest;
            }
        }
        return null;
    }
// show deta Guests

    public void displayGuests() {
        for (Guest guest : guests) {
            System.out.println("ID :" + guest.getId());
            System.out.println("Name :" + guest.getName());
            System.out.println("Email :" + guest.getEmail());
            System.out.println("Address :" + guest.getAddress());
            System.out.println("Nationality :" + guest.getNationality());
            System.out.println("-------------------");
        }
    }
    //  gets and sets

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

}
