package PersonsCreation;

public class ExMember extends Person {

    protected ExMember(String name, String personalNumber) {
        super(name, personalNumber);
        membershipCategorizer = new ExMemberCategory();
    }
}
