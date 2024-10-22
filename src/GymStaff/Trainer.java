package GymStaff;

import PersonsCreation.Person;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;

public class Trainer implements Observer {

    private final Path path;
    private final Receptionist receptionist;
    private Person memberWorkingOut;

    public Trainer(Path path, Receptionist receptionist) {
        this.path = path;
        this.receptionist = receptionist;
    }



    @Override
    public void update() {
        memberWorkingOut = receptionist.getAuthorizedPerson();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            writer.write(String.format("%s - Time of workout: %s\n", memberWorkingOut.toString(), LocalDate.now()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}
