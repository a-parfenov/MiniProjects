package booking;

public class Room {
    private int placements;
    private int price;
    private boolean busy;

    public Room(int placements, int price) {
        this.placements = placements;
        this.price = price;
        this.busy = false;
    }

    public int getPlacements() {
        return placements;
    }

    public void setPlacements(int placements) {
        this.placements = placements;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
