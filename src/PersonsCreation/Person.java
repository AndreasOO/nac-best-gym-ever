package PersonsCreation;

public abstract class Person {
    private final String name;
    private final String personalNumber;
    MembershipCategorizer membershipCategorizer;

    protected Person(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
    }

    public String categorizeMembership() {
        return membershipCategorizer.categorize();
    }

    public String getName() {
        return name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }
}
