package register;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetRegister implements Register{
    private Set<Person> set;

    public SetRegister(Set<Person> set) {
        this.set = set;
    }

    @Override
    public void addPerson(Person person) {
        set.add(person);
    }

    @Override
    public void removePerson(Person person) {
    set.remove(person);
    }

    @Override
    public int getSize() {
        return set.size();
    }

    @Override
    public Person getPerson(int index) {
        return null;
    }

    public Person findPersonByPhoneNumber(String phoneNumber) throws PersonNotFoundException {
        Person person = null;
        for (Person p : set) {
            if (phoneNumber.equals(p.getPhoneNumber()))
                person = p;
        }

        if (person == null)
            throw new PersonNotFoundException("Person with this phone was not found");

        return set.stream()
                .filter(p -> p.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .get();
    }
    @Override
    public Person findPersonByName(String name) throws PersonNotFoundException {
        Person person = null;
        for (Person p : set) {
            if (p.getName().equals(name)) {
                person = p;
                break;
            }
        }
        if (person == null)
            throw new PersonNotFoundException("Person with this name was not found");

        return person;
    }

    @Override
    public void handler(Throwable e) {

    }
}
