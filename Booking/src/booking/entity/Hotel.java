package booking.entity;

import java.util.ArrayList;

public class Hotel {
    private String nameHotel;
    private final ArrayList<Room> listOfRooms;
    private final Bill billHotel;

    public Bill getBillHotel() {
        return billHotel;
    }

    public Hotel(String nameHotel, ArrayList<Room> listOfRooms, Bill billHotel) {
        this.nameHotel = nameHotel;
        this.listOfRooms = listOfRooms;
        this.billHotel = billHotel;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public ArrayList<Room>  getListOfRooms() {
        return listOfRooms;
    }

}
