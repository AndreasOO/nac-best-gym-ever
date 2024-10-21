package GymStaff;

import PersonsCreation.MembershipCategorizer;
import PersonsCreation.Person;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Receptionist implements Subject {
    private final List<Observer> observers;
    private final List<Person> membersList;
    private InputObject inputObject;
    private Person authorizedPerson;
    private String authorizationMessage;



    public Receptionist(List<Person> membersList) {
        observers = new ArrayList<>();
        //TODO create memberslist singelton pattern
        this.membersList = membersList;

    }

    public void attendVisitor() {
        getUserInput();
        checkAuthorization(inputObject);
        createAuthorizationMessage();
        showAuthorizationMessage();
        notifyObservers();
    }

    public void getUserInput() {
        int choice = JOptionPane.showOptionDialog(null, "How will you validate membership?",
                "Membership validation", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"By name","By personal number","Cancel"},"By personal number");

        switch (choice) {
            case 1 -> inputObject = new InputObject(JOptionPane.showInputDialog("Please enter name"), InputType.NAME);
            case 2 -> inputObject = new InputObject(JOptionPane.showInputDialog("Please enter your personal number"), InputType.PERSONAL_NUMBER);
        }
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

    public String getAuthorizationMessage() {
        return authorizationMessage;
    }

    public void registerObserver(Observer o) {
        System.out.println("registering observer");
    }
    public void removeObserver(Observer o) {
        System.out.println("removing observer");
    }
    public void notifyObservers() {
        System.out.println("notifying observers");
    }


}
