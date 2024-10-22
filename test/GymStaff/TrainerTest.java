package GymStaff;

import PersonsCreation.Person;
import PersonsCreation.PersonsCreator;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    List<Person> memberslist = new ArrayList<>();


    @Test
    void update() {
        // Tear down old data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test/GymStaff/workout-test-tracker-log.txt", false))) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Setup
        InputObject inputObject = new InputObject("Anders Andersson", InputType.NAME);
        memberslist.add(PersonsCreator.createPayingMember("Anders Andersson", "8901010745"));

        Receptionist receptionist = new Receptionist(memberslist);
        Trainer trainer = new Trainer(Paths.get("test/GymStaff/workout-test-tracker-log.txt"), receptionist);
        receptionist.registerObserver(trainer);
        receptionist.checkAuthorization(inputObject);
        receptionist.notifyObservers();

        // Asserting written line - could show false in case test runs the seconds over midnight
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("test/GymStaff/workout-test-tracker-log.txt"))) {
            line = reader.readLine();
            assertEquals(line, "Name: Anders Andersson, Personal number: 8901010745 - Time of workout: " + LocalDate.now());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}