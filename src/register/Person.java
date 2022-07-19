package register;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * register.Person.
 */
public class Person implements Comparable<Person> {
    public static final Pattern PATTERN_FOR_PHONE = Pattern.compile("\\d{7,12}");
    /**
     * Name of this person.
     */
    private String name;

    /**
     * Phone number of this person.
     */
    private String phoneNumber;

    /**
     * Construct a person.
     *
     * @param name        name of the person
     * @param phoneNumber phone number of the person
     */
    public Person(String name, String phoneNumber) throws InvalidPhoneNumberException {
        this.name = name;
        this.setPhoneNumber(phoneNumber);
    }

    /**
     * Returns name of this person.
     *
     * @return name of this person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of this person.
     *
     * @param nameNew name of this person
     */
    public void setName(String nameNew) {
        name = nameNew;
    }

    /**
     * Returns phone number of this person.
     *
     * @return phone number of this person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number of this person.
     *
     * @param phoneNumberNew phone number of this person
     */
    public void setPhoneNumber(String phoneNumberNew) throws InvalidPhoneNumberException {
        if (!isValidPhoneNumber(phoneNumberNew)) {
            throw new InvalidPhoneNumberException("Phone number is not valid");
        }
        phoneNumber = phoneNumberNew;
    }

    //TODO: Implement method isValidPhoneNumber

    /**
     * Validates the phone number. Valid phone numbers contains only digits.
     *
     * @param phoneNumber phone number to validate
     * @return <code>true</code> if phone number is valid, <code>false</code> otherwise
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        Matcher m = PATTERN_FOR_PHONE.matcher(phoneNumber);
        return m.matches();

    }

    /**
     * Returns a string representation of the person.
     *
     * @return string representation of the person.
     */
    public String toString() {
        return name + " (" + phoneNumber + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    @Override
    public int compareTo(Person o) {
        if(o == null) return -1;
        return name.compareTo(o.name);
    }


}


