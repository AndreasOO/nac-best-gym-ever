package PersonsCreation;

/**
 * Abstract class for members, uses Strategy pattern to prepare for additions and changes of membership categories
 * and their desired behaviors through the MembershipCategorizer.
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return name.equals(person.name) && personalNumber.equals(person.personalNumber);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + personalNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Personal number: %s", getName(), getPersonalNumber());
    }
}
