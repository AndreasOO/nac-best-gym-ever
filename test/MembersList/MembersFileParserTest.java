package MembersList;

import PersonsCreation.ExMember;
import PersonsCreation.PayingMember;
import PersonsCreation.PersonsCreator;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MembersFileParserTest {


    // TODO set localDate object with 2024-10-21 and use that as benchmark for tests in testdata.
    @Test
    void parseFile() {
        Path file = Paths.get("test/MembersList/customer-test-data.txt");
        MembersFileParser parser = new MembersFileParser(file);
        parser.parseFile(LocalDate.ofYearDay(2024,1));


        PayingMember payingMember = PersonsCreator.createPayingMember("Alhambra Aromes", "7703021234");
        assertEquals(payingMember, parser.getMembersList().getFirst());
        assertEquals(PayingMember.class, parser.getMembersList().getFirst().getClass());

        ExMember exMember = PersonsCreator.createExMember("Bear Belle", "8204021234");
        assertEquals(exMember, parser.getMembersList().getLast());
        assertEquals(ExMember.class, parser.getMembersList().getLast().getClass());
    }
}