package register;

public interface Register {
    public void addPerson(Person person);

    public void removePerson(Person person);

    public int getSize();

    public Person getPerson(int index);

    public Person findPersonByPhoneNumber(String phoneNumber) throws PersonNotFoundException;

    public Person findPersonByName(String name) throws PersonNotFoundException;

    public void handler(Throwable e);

}
