package GymStaff;

import java.io.EOFException;

public class InputObject {
    private final String input;
    private final InputType inputType;

    public InputObject(String input, InputType inputType) {
        this.input = input;
        this.inputType = inputType;

    }

    public void validateInput() throws IllegalArgumentException, EOFException {
        //TODO validations with regex and tests with exceptions
        if (input == null) {
            throw new EOFException("End of file");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        if (inputType == InputType.NAME && !input.matches("^\\w+\\s\\w+")) {
            throw new IllegalArgumentException("Incorrect format of name, try 'Firstname Lastname'");
        }
        if (inputType == InputType.PERSONAL_NUMBER && !input.matches("\\d{10}")) {
            throw new IllegalArgumentException("Incorrect format of personal number, number needs to be 10 digits");
        }

    }

    public String getInput() {
        return input;
    }

    public InputType getInputType() {
        return inputType;
    }
}
