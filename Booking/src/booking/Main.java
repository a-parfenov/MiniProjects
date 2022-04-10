package booking;

import booking.entity.Bill;
import booking.entity.Client;
import booking.entity.Hotel;
import booking.entity.Room;
import booking.service.BookingService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Client clientOne = new Client("Aleks", "Below",
                "89877324354", "a.bel@gmail.ru", new Bill(20000));
        Client clientTwo = new Client("Nikolas", "Tchaikovsky",
                "89877362351", "nik@mail.ru", new Bill(10000));
        Client clientTree = new Client("Maksim", "Yannic",
                "89822243540", "m.yan@gmail.ru", new Bill(2900));


        ArrayList<Room> listOfRooms1 = new ArrayList<>();
        listOfRooms1.add(new Room(4, 3700, true));
        listOfRooms1.add(new Room(5, 3300, true));
        listOfRooms1.add(new Room(2, 9800, true));
        listOfRooms1.add(new Room(4, 6100, true));
        listOfRooms1.add(new Room(2, 2900, false));
        Hotel HotelRoyalPrague = new Hotel("Hotel Royal Prague", listOfRooms1, new Bill(377000));

        ArrayList<Room> listOfRooms2 = new ArrayList<>();
        listOfRooms2.add(new Room(4, 2900, true));
        listOfRooms2.add(new Room(1, 1100, false));
        listOfRooms2.add(new Room(2, 2900, true));
        listOfRooms2.add(new Room(6, 5500, true));
        listOfRooms2.add(new Room(2, 2200, false));
        Hotel HotelPrague = new Hotel("Hotel Prague", listOfRooms2, new Bill(210000));

        Hotel HotelTest = new Hotel("Hotel Mix", new ArrayList<>(), new Bill(210000));


        BookingService bookingService = new BookingService();

        bookingService.book(HotelRoyalPrague, clientOne, 7);
        bookingService.book(HotelRoyalPrague, clientOne, 2);

        bookingService.book(HotelPrague, clientTwo, 1);

        bookingService.book(HotelRoyalPrague, clientTree, 4);
        bookingService.book(HotelTest, clientTree, 4);
        bookingService.book(HotelPrague, clientTree, 4);

    }
}
