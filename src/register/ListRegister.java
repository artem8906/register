package register;

import java.util.Iterator;
import java.util.List;

public class ListRegister implements Register {
    private List<Person> list;

    public ListRegister(List<Person> list) {
        this.list = list;
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
    public int getSize() {
        return list.size();
    }

    @Override
    public Person getPerson(int index) {
        return list.get(index);
    }

    @Override
    public Person findPersonByPhoneNumber(String phoneNumber) throws PersonNotFoundException {
        Person person = null;
        for (Person p : list) {
            if (phoneNumber.equals(p.getPhoneNumber()))
                person = p;
        }

        if (person == null)
            throw new PersonNotFoundException("Person with this phone was not found");

        return person;
    }

    @Override
    public Person findPersonByName(String name) throws PersonNotFoundException {
        Person person = null;
        for (Person p : list) {
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
        System.out.println(e.getMessage());
    }

    public void print() {
        list.stream().forEach(System.out::println);
        }
    }

