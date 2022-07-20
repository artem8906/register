package register;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
    /**
     * register.Person array.
     */
    private Person[] persons;

    /**
     * Number of persons in this register.
     */
    private int count;

    /**
     * Constructor creates an empty register with maximum size specified.
     *
     * @param size maximum size of the register
     */
    public ArrayRegister(int size) {
        persons = new Person[size];
        count = 0;
    }

    /**
     * Returns the number of persons in this register.
     *
     * @return the number of persons in this register
     */
    public int getCount() {
        return count;
    }

    /**
     * Returns the maximum number of persons in this register.
     *
     * @return the maximum number of persons in this register.
     */
    public int getSize() {
        return persons.length;
    }

    /**
     * Returns the person at the specified position in this register.
     *
     * @param index index of the person to return
     * @return person the person at the specified position in this register
     */
    public Person getPerson(int index) {
        return persons[index];
    }

    /**
     * Appends the specified person to the end of this register.
     *
     * @param person person to append to this register
     */
    public void addPerson(Person person) {
        try {
            for (Person p : persons) {
                if (p == null) continue;
                if (p.getName().equals(person.getName()) || p.getPhoneNumber().equals(person.getPhoneNumber()))
                    throw new IllegalArgumentException("Person with the same name or phone already exists");
            }
        } catch (IllegalArgumentException e) {
            handler(e);
        }
        persons[count] = person;
        count++;
    }

    //TODO: Implement the method findPersonByName

    /**
     * Returns the person with specified name in this register or <code>null</code>,
     * if match can not be found.
     *
     * @param name name of a person to search for
     * @return person with specified phone number
     */
    public Person findPersonByName(String name) throws PersonNotFoundException {
        Person person = null;

        for (Person p : persons) {
            if (p == null) continue;
            if (p.getName().equals(name)) {
                person = p;
                break;
            }
        }
        if (person == null)
            throw new PersonNotFoundException("Person with this name was not found");
        return person;
    }

    //TODO: Implement the method findPersonByPhoneNumber

    /**
     * Returns the person with specified phone number in this register or <code>null</code>,
     * if match can not be found.
     *
     * @param phoneNumber phone number of a person to search for
     * @return person with specified phone number
     */
    public Person findPersonByPhoneNumber(String phoneNumber) throws PersonNotFoundException {
        Person person = null;
        for (Person p : persons) {
            if (p == null) continue;
            if (p.getPhoneNumber().equals(phoneNumber)) {
                person = p;
                break;
            }
        }
        if (person == null)
            throw new PersonNotFoundException("Person with this phone was not found");
        return person;
    }


    //TODO: Implement the method removePerson

    /**
     * Removes the specified person from the register.
     *
     * @param person person to remove
     */
    public void removePerson(Person person) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == null) continue;
            if (persons[i].equals(person))
                persons[i] = null;
        }
        sortNullToEnd();
        count--;
    }

    public void handler(Throwable e) {
        System.out.println(e.getMessage());
    }

    public void sortNullToEnd() {
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i] == null) {
                persons[i] = persons[i + 1];
                persons[i + 1] = null;
            }
        }
    }
}


