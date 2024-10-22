package GymStaff;

import org.junit.jupiter.api.Test;

import java.io.EOFException;

import static org.junit.jupiter.api.Assertions.*;

class InputObjectTest {

    @Test
    void validateInputEOF() {
        InputObject input = new InputObject(null, null);
        assertThrows(EOFException.class, () -> input.validateInput());
    }

    @Test
    void validateInputEmptyStringName() {
        InputObject input = new InputObject("", InputType.NAME);
        assertThrows(IllegalArgumentException.class, () -> input.validateInput());
    }

    @Test
    void validateInputEmptyStringPersonalNumber() {
        InputObject input = new InputObject("", InputType.PERSONAL_NUMBER);
        assertThrows(IllegalArgumentException.class, () -> input.validateInput());
    }

    @Test
    void validateInputWrongFormatName() {
        InputObject input = new InputObject("dsada", InputType.NAME);
        assertThrows(IllegalArgumentException.class, () -> input.validateInput());
    }

    @Test
    void validateInputWrongFormatPersonalNumber() {
        InputObject input = new InputObject("dsdsa212", InputType.PERSONAL_NUMBER);
        assertThrows(IllegalArgumentException.class, () -> input.validateInput());
    }
}