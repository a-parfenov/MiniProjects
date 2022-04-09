package booking;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nameHotel;
    private List<Room> listOfRooms;

    public Hotel(String nameHotel, List<Room> listOfRooms) {
        this.nameHotel = nameHotel;
        this.listOfRooms = listOfRooms;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public List<Room> getListOfRooms() {
        return listOfRooms;
    }

    public void setListOfRooms(List<Room> listOfRooms) {
        this.listOfRooms = listOfRooms;
    }
}
