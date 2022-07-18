package register;

import java.util.List;

public class ListRegister implements Register{
    private List <Person> list;
    @Override
    public void addPerson(Person person) {
        list.add(person);
    }

    @Override
    public void removePerson(Person person) {
        list.remove(person);
    }
}
