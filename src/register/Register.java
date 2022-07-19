package register;

public interface Register {

    public int getCount();
    public void addPerson(Person person);

    public void removePerson(Person person);

    public Person findPersonByName(String name);

    public Person findPersonByPhoneNumber(String phoneNumber);
}
