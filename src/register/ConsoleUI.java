package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

import static register.Person.patternForPhone;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /**
     * register.Register of persons.
     */
    private Register register;

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


    public ConsoleUI(Register register) {
        this.register = register;
    }

    public void run() {
        try {
            while (true) {
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
            }
        }
                catch (PersonNotFoundException e) {
                    register.handler(e);
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
        for (int i = 0; i < register.getSize(); i++)
            System.out.println(i + 1 + " " + register.getPerson(i));

    }

    private void addToRegister() {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();

        register.addPerson(new Person(name, phoneNumber));
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

        Person p1 = register.findPersonByName(name);
        Person p2 = register.findPersonByPhoneNumber(phoneNumber);

        if (p1 == p2) {
            p1.setName(nameNew);
            p1.setPhoneNumber(phoneNumberNew);
        } else throw new PersonNotFoundException("Person with this name and phone number did not found");
        }

    //TODO: Implement the method findInRegister
    private void findInRegister() throws PersonNotFoundException {
        System.out.println("Write name or phone number of person");
        String s = readLine();
        Matcher m = patternForPhone.matcher(s);
        Person person;

        if (m.matches()) person = register.findPersonByPhoneNumber(s);
        else person = register.findPersonByName(s);

        if (person == null)
            throw new PersonNotFoundException("Person with this name or phone number was not found");

        System.out.println(person);
    }

    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
        register.removePerson(person);
    }
}
