package _11_Contact;

public class Contact implements Comparable {
    private String firstName, lastName, phone;

    public Contact(String first, String last, String telephone) {
        firstName = first;
        lastName = last;
        phone = telephone;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + "\t" + phone;
    }

    @Override
    public int compareTo(Object o) {
        int result;

        if (lastName.equals(((Contact) o).lastName)) {
            result = firstName.compareTo(((Contact) o).firstName);
        } else {
            result = lastName.compareTo(((Contact) o).lastName);
        }

        return result;
    }
}
