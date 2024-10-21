package PersonsCreation;

public class ExMemberCategory implements MembershipCategorizer {
    @Override
    public String categorize() {
        return "This person is an ex-customer and is no longer a paying member";
    }
}
