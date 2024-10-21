package GymStaff;

public class InputObject {
    private final String input;
    private final InputType inputType;

    public InputObject(String input, InputType inputType) {
        this.input = input;
        this.inputType = inputType;
        validateInput();
    }

    private void validateInput() {
        //TODO validations with regex and tests with exceptions
    }

    public String getInput() {
        return input;
    }

    public InputType getInputType() {
        return inputType;
    }
}
