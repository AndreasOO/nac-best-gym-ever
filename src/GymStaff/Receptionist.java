package GymStaff;

import PersonsCreation.PayingMember;
import PersonsCreation.Person;

import javax.swing.*;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

public class Receptionist implements Subject {
    private final List<Observer> observers;
    private final List<Person> membersList;
    private InputObject inputObject;
    private Person authorizedPerson;
    private String authorizationMessage;



    public Receptionist(List<Person> membersList) {
        this.observers = new ArrayList<>();
        this.membersList = membersList;
    }

    public void attendVisitor() {
        getUserInput();
        checkAuthorization(inputObject);
        createAuthorizationMessage();
        showAuthorizationMessage();
        notifyObservers();
        tryAgainOrExit();
    }

    public void getUserInput() {
        int choice = JOptionPane.showOptionDialog(null, "How will you validate membership?",
                "Membership validation", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"By name","By personal number","Cancel"},"By personal number");

        try {
            switch (choice) {
                case 0 -> inputObject = getInputByName();
                case 1 -> inputObject = getInputByPersonNumber();
                case 2 -> System.exit(0);
                default -> System.exit(0);
            }
        } catch (EOFException e) {
            tryAgainOrExit();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            tryAgainOrExit();
        }
    }

    private InputObject getInputByName() throws EOFException, IllegalArgumentException {
        InputObject input = new InputObject(JOptionPane.showInputDialog("Please enter name"), InputType.NAME);
        input.validateInput();
        return input;
    }

    private InputObject getInputByPersonNumber() throws EOFException, IllegalArgumentException {
        InputObject input = new InputObject(JOptionPane.showInputDialog("Please enter your personal number"), InputType.PERSONAL_NUMBER);
        input.validateInput();
        return input;
    }

    protected void checkAuthorization(InputObject inputObject) {
        switch (inputObject.getInputType()) {
            case NAME -> lookUpByName(inputObject.getInput());
            case PERSONAL_NUMBER -> lookUpByPersonalNumber(inputObject.getInput());
        }
    }

    private void lookUpByName(String inputName) {
        for (Person person : membersList) {
            if (person.getName().equalsIgnoreCase(inputName)) {
                authorizedPerson = person;
                break;
            }
        }
    }

    private void lookUpByPersonalNumber(String personalNumberInput) {
        for (Person person : membersList) {
            if (person.getPersonalNumber().equals(personalNumberInput)) {
                authorizedPerson = person;
                break;
            }
        }
    }

    public void createAuthorizationMessage() {
        if (authorizedPerson != null) {
            authorizationMessage = authorizedPerson.categorizeMembership();
        }
        else {
            authorizationMessage = "This person is not and has never been a member, unauthorized to access gym";
        }
    }

    private void showAuthorizationMessage() {
        JOptionPane.showMessageDialog(null, getAuthorizationMessage());
    }


    private void tryAgainOrExit() {
        int choice = JOptionPane.showOptionDialog(null, "Do you want to validate another member?",
                "Membership validation", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"Try again","Exit"},"Try again");


        switch (choice) {
            case 0 -> attendVisitor();
            case 1 -> System.exit(0);
            default -> System.exit(0);
        }

    }

    public String getAuthorizationMessage() {
        return authorizationMessage;
    }

    public Person getAuthorizedPerson() {
        return authorizedPerson;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        if (authorizedPerson instanceof PayingMember) {
            for (Observer o : observers) {
                o.update();
            }
        }

    }


}
