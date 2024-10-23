import GymStaff.Receptionist;
import GymStaff.Trainer;
import MembersList.MembersFileParser;
import PersonsCreation.Person;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MembersFileParser parser = new MembersFileParser(Paths.get("src/MembersList/customer-data.txt"));
        parser.parseFile(LocalDate.now());


        List<Person> memberslist = parser.getMembersList();


        Receptionist receptionist = new Receptionist(memberslist);
        Trainer trainer = new Trainer(Paths.get("src/GymStaff/workout-tracker-log.txt"), receptionist);

        receptionist.registerObserver(trainer);
        receptionist.attendVisitor();



    }
}