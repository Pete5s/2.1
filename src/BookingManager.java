import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private final List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking newBooking) {
        bookings.add(newBooking);
    }

    public Booking getBooking(int index) {
        if (index >= 0 && index < bookings.size()) {
            return bookings.get(index);
        }
        throw new IndexOutOfBoundsException("Index mimo rozsah seznamu rezervací.");
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public void clearBookings() {
        bookings.clear();
    }

    public int getNumberOfWorkingBookings() {
        return (int) bookings.stream()
                .filter(booking -> "pracovní".equalsIgnoreCase(booking.getVacationType()))
                .count();
    }

    public double getAverageGuests() {
        return bookings.stream()
                .mapToInt(Booking::getNumberOfGuests)
                .average()
                .orElse(0.0);
    }

    public void printAllBookings() {
        bookings.forEach(System.out::println);
    }

    public void printFirstNRecreationalBookings(int n) {
        bookings.stream()
                .filter(booking -> "rekreační".equalsIgnoreCase(booking.getVacationType()))
                .limit(n)
                .forEach(System.out::println);
    }

    public void printGuestStatistics() {
        long oneGuest = bookings.stream()
                .filter(booking -> booking.getNumberOfGuests() == 1)
                .count();
        long twoGuests = bookings.stream()
                .filter(booking -> booking.getNumberOfGuests() == 2)
                .count();
        long moreThanTwoGuests = bookings.stream()
                .filter(booking -> booking.getNumberOfGuests() > 2)
                .count();

        System.out.printf("Rezervace s jedním hostem: %d\n", oneGuest);
        System.out.printf("Rezervace se dvěma hosty: %d\n", twoGuests);
        System.out.printf("Rezervace s více než dvěma hosty: %d\n", moreThanTwoGuests);
    }
}
