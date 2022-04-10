package booking.entity;

public class Room {
    private int placements;
    private int cost;
    private boolean free;

    public Room(int placements, int price, boolean free) {
        this.placements = placements;
        this.cost = price;
        this.free = free;
    }

    public int getPlacements() {
        return placements;
    }

    public void setPlacements(int placements) {
        this.placements = placements;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int price) {
        this.cost = price;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean busy) {
        this.free = busy;
    }
}
