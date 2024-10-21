package PersonsCreation;

public class UnauthorizedPerson extends Person {

    protected UnauthorizedPerson(String name, String personalNumber) {
        super(name, personalNumber);
        membershipCategorizer = new UnauthorizedPersonCategory();
    }
}
