package register;

import java.util.List;

public class ListRegister implements Register {
    private List<Person> list;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void addPerson(Person person) {
        list.add(person);
    }

    @Override
    public void removePerson(Person person) {
        list.remove(person);
    }

    @Override
    public Person findPersonByName(String name) {
        return null;
    }

    @Override
    public Person findPersonByPhoneNumber(String phoneNumber) {
        return null;
    }
}
