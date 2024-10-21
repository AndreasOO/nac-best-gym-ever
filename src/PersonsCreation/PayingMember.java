package PersonsCreation;

public class PayingMember extends Person {


    protected PayingMember(String name, String personalNumber) {
        super(name, personalNumber);
        membershipCategorizer = new PayingMemberCategory();
    }


}
