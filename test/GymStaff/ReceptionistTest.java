package GymStaff;

import PersonsCreation.Person;
import PersonsCreation.PersonsCreator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ReceptionistTest {


    List<Person> memberslist = new ArrayList<>();





    @Test
    void checkAuthorizationByNameExistingPayingMember() {
        InputObject inputObject = new InputObject("Anders Andersson", InputType.NAME);
        memberslist.add(PersonsCreator.createPayingMember("Anders Andersson", "8901010745"));

        Receptionist receptionist = new Receptionist(memberslist);
        receptionist.checkAuthorization(inputObject);
        receptionist.createAuthorizationMessage();
        assertEquals("This person is a paying member", receptionist.getAuthorizationMessage());
    }

    @Test
    void checkAuthorizationByPersonalNumberExistingExMember() {
        InputObject inputObject = new InputObject("8901010745", InputType.PERSONAL_NUMBER);
        memberslist.add(PersonsCreator.createExMember("Anders Andersson", "8901010745"));

        Receptionist receptionist = new Receptionist(memberslist);
        receptionist.checkAuthorization(inputObject);
        receptionist.createAuthorizationMessage();
        assertEquals("This person is an ex-customer and is no longer a paying member", receptionist.getAuthorizationMessage());
    }

    @Test
    void checkAuthorizationByNameUnauthorizedPerson() {
        InputObject inputObject = new InputObject("Devious Person", InputType.NAME);
        memberslist.add(PersonsCreator.createPayingMember("Anders Andersson", "8901010745"));

        Receptionist receptionist = new Receptionist(memberslist);
        receptionist.checkAuthorization(inputObject);
        receptionist.createAuthorizationMessage();
        assertEquals("This person is not and has never been a member, unauthorized to access gym", receptionist.getAuthorizationMessage());
    }

    @Test
    void checkAuthorizationByPersonalUnauthorizedPerson() {
        InputObject inputObject = new InputObject("8502050321", InputType.PERSONAL_NUMBER);
        memberslist.add(PersonsCreator.createPayingMember("Anders Andersson", "8901010745"));

        Receptionist receptionist = new Receptionist(memberslist);
        receptionist.checkAuthorization(inputObject);
        receptionist.createAuthorizationMessage();
        assertEquals("This person is not and has never been a member, unauthorized to access gym", receptionist.getAuthorizationMessage());
    }
}