package PersonsCreation;

public class UnauthorizedPersonCategory implements MembershipCategorizer {
    @Override
    public String categorize() {
        return "This person is not and has never been a member, unauthorized to access gym";
    }
}
