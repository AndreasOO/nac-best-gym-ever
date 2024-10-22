package MembersList;

import PersonsCreation.Person;
import PersonsCreation.PersonsCreator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class MembersFileParser {
    private final List<Person> membersList;
    private final Path path;

    public MembersFileParser(Path path) {
        this.path = path;
        this.membersList = new ArrayList<>();
    }

    public void parseFile(LocalDate dateToday) {

        String name;
        String personNumber;
        String line;
        boolean payingMember = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            while ((line = reader.readLine()) != null) {

                personNumber = line.split(",")[0].trim();
                 name = line.split(",")[1].trim();

                if (!name.matches("^\\w+\\s\\w+")) {
                    throw new IllegalArgumentException("Invalid name: " + name);
                }
                if (!personNumber.matches("\\d{10}")) {
                    throw new IllegalArgumentException("Invalid personal number: " + personNumber);
                }

                line = reader.readLine().trim();
                payingMember = dateToday.toEpochDay() - LocalDate.parse(line).toEpochDay() <= 365 ;

                if (payingMember) {
                    membersList.add(PersonsCreator.createPayingMember(name, personNumber));
                } else {
                    membersList.add(PersonsCreator.createExMember(name, personNumber));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }

    }

    public List<Person> getMembersList() {
        return membersList;
    }
}
