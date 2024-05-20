public class Room {
    private final int number;
    private final int beds;
    private final boolean hasBalcony;
    private final boolean seaView;
    private final int pricePerNight;

    public Room(int number, int beds, boolean hasBalcony, boolean seaView, int pricePerNight) {
        this.number = number;
        this.beds = beds;
        this.hasBalcony = hasBalcony;
        this.seaView = seaView;
        this.pricePerNight = pricePerNight;
    }

    public int getNumber() {
        return number;
    }

    public int getBeds() {
        return beds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return String.format("Pokoj číslo %d (%d lůžek, %sbalkón, %svýhled na moře, %d Kč/noc)",
                number, beds, hasBalcony ? "" : "bez ", seaView ? "" : "bez ", pricePerNight);
    }
}