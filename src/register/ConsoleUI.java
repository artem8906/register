package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

import static register.Person.PATTERN_FOR_PHONE;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /**
     * register.Register of persons.
     */
    private ArrayRegister arrayRegister;

    //    /**
//     * In JDK 6 use Console class instead.
//     * @see readLine()
//     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Menu options.
     */
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    }


    public ConsoleUI(ArrayRegister arrayRegister) {
        this.arrayRegister = arrayRegister;
    }

    public void run() {
        while (true) {
            try {
                switch (showMenu()) {
                    case PRINT:
                        printRegister();
                        break;
                    case ADD:
                        addToRegister();
                        break;
                    case UPDATE:
                        updateRegister();
                        break;
                    case REMOVE:
                        removeFromRegister();
                        break;
                    case FIND:
                        findInRegister();
                        break;
                    case EXIT:
                        return;
                }
            } catch (PersonNotFoundException e) {
                arrayRegister.handler(e);
            }
        }
    }

    private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();

        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private Option showMenu() {
        System.out.println("Menu.");
        for (Option option : Option.values()) {
            System.out.printf("%d. %s%n", option.ordinal() + 1, option);
        }
        System.out.println("-----------------------------------------------");

        int selection = -1;
        do {
            System.out.println("Option: ");
            selection = Integer.parseInt(readLine());
        } while (selection <= 0 || selection > Option.values().length);

        return Option.values()[selection - 1];
    }

    //TODO: Implement the method printRegister
    private void printRegister() {
        for (int i = 0; i < arrayRegister.getSize(); i++) {
            Person p = arrayRegister.getPerson(i);
            if (p == null) break;
            System.out.println(i + 1 + " " + p);
        }

    }

    private void addToRegister() {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();

        try {
            arrayRegister.addPerson(new Person(name, phoneNumber));
        } catch (InvalidPhoneNumberException e) {
            System.err.println("Invalid phone number, try again!");
            addToRegister();
        }
    }

    //TODO: Implement the method updateRegister
    private void updateRegister() throws PersonNotFoundException {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();

        System.out.println("Enter new Name: ");
        String nameNew = readLine();
        System.out.println("Enter new Phone Number: ");
        String phoneNumberNew = readLine();

        Person p1 = arrayRegister.findPersonByName(name);
        Person p2 = arrayRegister.findPersonByPhoneNumber(phoneNumber);

        if (p1 == p2) {
            if(p1 != null) {
                p1.setName(nameNew);
                p1.setName(phoneNumberNew);
            }
        } else {
            throw new PersonNotFoundException("Person with this name and phone number did not found");
        }

    }

    //TODO: Implement the method findInRegister
    private void findInRegister() throws PersonNotFoundException {
        System.out.println("Write name or phone number of person");
        String s = readLine();
        Matcher m = PATTERN_FOR_PHONE.matcher(s);
        Person person;

        if (m.matches()) person = arrayRegister.findPersonByPhoneNumber(s);
        else person = arrayRegister.findPersonByName(s);

        if (person == null)
        throw new PersonNotFoundException("Person with this name or phone number was not found");

        System.out.println(person);

    }

    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = arrayRegister.getPerson(index - 1);
        arrayRegister.removePerson(person);
    }

}
