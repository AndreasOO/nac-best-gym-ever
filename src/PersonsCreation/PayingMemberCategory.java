package PersonsCreation;

public class PayingMemberCategory implements MembershipCategorizer {
    @Override
    public String categorize() {
        return "This person is a paying member";
    }
}
