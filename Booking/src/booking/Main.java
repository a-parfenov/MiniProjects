package booking;

import java.util.ArrayList;
import java.util.List;

public class Main {

    Bill billClientOne = new Bill(20000);
    Client clientOne = new Client("Aleks", "Below", "89877324354", "a.bel@mail.ru", billClientOne);

    Bill billClientTwo = new Bill(30000);
    Client clientTwo = new Client("Nikolas", "Tchaikovsky", "89877362351", "nik@mail.ru", billClientTwo);

    Bill billClientThree = new Bill(15000);
    Client clientTree = new Client("Maksim", "Yannic", "89822243540", "a.bel@mail.ru", billClientThree);


    Room room1 = new Room(4, 2700);
    Room room2 = new Room(5, 3300);
    Room room3 = new Room(2, 9800);
    Room room4 = new Room(4, 6100);
    Room room5 = new Room(2, 2900);
    ArrayList<String> listOfRooms1 = new ArrayList<> (2);
    List<Room> list = new ArrayList<>();
    list.add();

    Hotel HotelPrague = new Hotel("Grandium Hotel Prague", listOfRooms1);

    Room room01 = new Room(4, 2900);
    Room room02 = new Room(5, 4800);
    Room room03 = new Room(2, 3700);
    Room room04 = new Room(4, 5500);
    Room room05 = new Room(2, 2200);
    ArrayList<Room> listOfRooms2 = new Room[] {room01, room02, room03, room04, room05};
    Hotel HotelRoyalPrague = new Hotel("Hotel Royal Prague", listOfRooms2);


}
