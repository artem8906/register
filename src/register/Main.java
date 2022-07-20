package register;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by Artem on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {

//      Register arrayRegister = new ArrayRegister(20);
        Register listRegister = new ListRegister(new ArrayList<>());
        Register setRegister = new SetRegister(new TreeSet<>());

        listRegister.addPerson(new Person("Janko Hrasko", "0900123456"));

        ConsoleUI ui = new ConsoleUI(listRegister);
        ui.run();
    }

}
