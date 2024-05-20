import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingManager bookingManager;
        bookingManager = new BookingManager();
        fillBookings(bookingManager);


        Guest adela = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest jan = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5));
        System.out.println(adela);
        System.out.println(jan);


        Room room1 = new Room(1, 1, true, true, 1000);
        Room room2 = new Room(2, 1, true, true, 1000);
        Room room3 = new Room(3, 3, false, true, 2400);
        System.out.println(room1);
        System.out.println(room2);
        System.out.println(room3);


        bookingManager.addBooking(new Booking(room1, List.of(adela), LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), "rekreační"));
        bookingManager.addBooking(new Booking(room3, List.of(adela, jan), LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), "rekreační"));


        bookingManager.printAllBookings();
        System.out.println("Počet pracovních pobytů: " + bookingManager.getNumberOfWorkingBookings());
        System.out.println("Průměrný počet hostů na rezervaci: " + bookingManager.getAverageGuests());
        System.out.println("Prvních osm rekreačních rezervací:");
        bookingManager.printFirstNRecreationalBookings(8);
        System.out.println("Statistika podle počtu hostů:");
        bookingManager.printGuestStatistics();
    }

    private static void fillBookings(BookingManager bookingManager) {
        Guest karel1 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
        Guest karel2 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
        Guest karolina = new Guest("Karolína", "Tmavá", LocalDate.of(1985, 8, 24));

        Room room1 = new Room(1, 1, true, true, 1000);
        Room room2 = new Room(2, 1, true, true, 1000);
        Room room3 = new Room(3, 3, false, true, 2400);

        bookingManager.addBooking(new Booking(room3, List.of(karel1), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), "pracovní"));
        bookingManager.addBooking(new Booking(room2, List.of(karel2), LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), "rekreační"));

        for (int i = 0; i < 10; i++) {
            LocalDate startDate = LocalDate.of(2023, 8, 1).plusDays(i * 2);
            LocalDate endDate = startDate.plusDays(1);
            bookingManager.addBooking(new Booking(room2, List.of(karolina), startDate, endDate, "rekreační"));
        }

        bookingManager.addBooking(new Booking(room3, List.of(karolina), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), "rekreační"));
    }
}
