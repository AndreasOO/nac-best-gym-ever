package PersonsCreation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnauthorizedPersonTest {
    UnauthorizedPerson member = PersonsCreator.createUnauthorizedPerson("Anders Andersson", "8901010745");

    @Test
    public void testPersonalInfo() {
        assertEquals("Anders Andersson", member.getName());
        assertEquals("8901010745", member.getPersonalNumber());
    }

    @Test
    public void testCategory() {
        assertEquals(UnauthorizedPerson.class, member.getClass());
        assertEquals("This person is not and has never been a member, unauthorized to access gym", member.categorizeMembership());
    }


}