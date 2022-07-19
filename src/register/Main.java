package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ArrayRegister arrayRegister = new ArrayRegister(20);

        arrayRegister.addPerson(new Person("Janko Hrasko", "0900123456"));
        arrayRegister.addPerson(new Person("Michal Hrozny", "0900123454"));
        arrayRegister.addPerson(new Person("Betka Perezna", "0900123453"));
        arrayRegister.addPerson(new Person("Anna Zaborska", "0900123452"));

        ConsoleUI ui = new ConsoleUI(arrayRegister);
        ui.run();
    }
}
