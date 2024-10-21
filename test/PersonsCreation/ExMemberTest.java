package PersonsCreation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExMemberTest {
    ExMember member = PersonsCreator.createExMember("Anders Andersson", "8901010745");

    @Test
    public void testPersonalInfo() {
        assertEquals("Anders Andersson", member.getName());
        assertEquals("8901010745", member.getPersonalNumber());
    }

    @Test
    public void testCategory() {
        assertEquals(ExMember.class, member.getClass());
        assertEquals("This person is an ex-customer and is no longer a paying member", member.categorizeMembership());
    }

}