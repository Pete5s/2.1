import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Booking {
    private final Room room;
    private final List<Guest> guests;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String vacationType;

    public Booking(Room room, List<Guest> guests, LocalDate startDate, LocalDate endDate, String vacationType) {
        if (guests.isEmpty()) {
            throw new IllegalArgumentException("Rezervace musí mít alespoň jednoho hosta.");
        }
        this.room = room;
        this.guests = guests;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationType = vacationType;
    }

    public Room getRoom() {
        return room;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getVacationType() {
        return vacationType;
    }

    public int getNumberOfGuests() {
        return guests.size();
    }

    public long getBookingLength() {
        return java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
    }

    public int getPrice() {
        return (int) (getBookingLength() * room.getPricePerNight());
    }

    @Override
    public String toString() {
        return String.format("%s až %s: %s [%d, %s] za %d Kč",
                startDate.format(DateTimeFormatter.ofPattern("d. M. yyyy")),
                endDate.format(DateTimeFormatter.ofPattern("d. M. yyyy")),
                guests.get(0), getNumberOfGuests(),
                room.isSeaView() ? "ano" : "ne", getPrice());
    }
}
