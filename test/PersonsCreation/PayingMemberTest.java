package PersonsCreation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayingMemberTest {
    PayingMember member = PersonsCreator.createPayingMember("Anders Andersson", "8901010745");

    @Test
    public void testPersonalInfo() {
        assertEquals("Anders Andersson", member.getName());
        assertEquals("8901010745", member.getPersonalNumber());
    }

    @Test
    public void testCategory() {
        assertEquals(PayingMember.class, member.getClass());
        assertEquals("This person is a paying member", member.categorizeMembership());
    }
}