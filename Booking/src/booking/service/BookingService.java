package booking.service;

import booking.entity.Client;
import booking.entity.Hotel;
import booking.entity.Room;

import java.util.ArrayList;

public class BookingService {

    public void book(Hotel hotel, Client client, int numberOfPerson) {
        ArrayList<Room> rooms = new ArrayList<>();
        for (Room room: hotel.getListOfRooms()) {
            if (room.isFree()) {
                rooms.add(room);
            }
        }

        if (rooms.size() == 0)
            System.out.println(client.getName() + " свободных номеров в отеле " + hotel.getNameHotel() + " нет");
        else {
            boolean checkRoom = false;
            for (Room room: rooms) {
                if (room.getPlacements() == numberOfPerson) {
                    checkRoom = true;
                    System.out.println("Найдена подходящая комната в отеле " + hotel.getNameHotel()
                            + " для клиента " + client.getName() + " за " + room.getCost() + " руб для " + numberOfPerson + " человек(а)");
                    if (checkPayment(hotel, client, room))
                        break;
                }
            }
            if (!checkRoom)
                System.out.println(client.getName() + ", в отеле " + hotel.getNameHotel()
                        + " нет комнат для " + numberOfPerson + " человек(а)");
        }
        System.out.println();
    }

    private boolean checkPayment(Hotel hotel, Client client, Room room) {
        if (client.getBillClient().getBill() >= room.getCost()) {
            System.out.println("--> До --> Счёт клиента: " + client.getBillClient().getBill()
                    + ", счёт отеля: " + hotel.getBillHotel().getBill());
            paymentRoom(hotel, client, room.getCost());
            room.setFree(false);
            System.out.println("Номер забронирован клиентом " + client.getName());
            System.out.println("--> После --> Счёт клиента: " + client.getBillClient().getBill()
                    + ", счёт отеля: " + hotel.getBillHotel().getBill());
            return true;
        } else {
            System.out.println("Недостаточно средств на счёте клиента " + client.getName()
                    + " для оплаты комнаты на " + room.getPlacements() + " человек(а)");
        } return false;
    }

    private void paymentRoom(Hotel hotel, Client client, int pay) {
        client.getBillClient().setBill(client.getBillClient().getBill() - pay);
        hotel.getBillHotel().setBill(hotel.getBillHotel().getBill() + pay);
        System.out.println("Оплата номера в отеле " + hotel.getNameHotel() + " прошла успешно");
    }

}
