import java.time.LocalDate;

public class Guest {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    public Guest(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        String lastName = new String();
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", firstName, lastName, birthDate);
    }
}
