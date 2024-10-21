package PersonsCreation;

/**
 * Factory class for Person objects.
 * It is possible to set the MemberShipCategorized class in the Person objects by assignment as the accessors
 * are package-private.
 */

public class PersonsCreator {
    public static PayingMember createPayingMember(String name, String personNumber) {
        return new PayingMember(name, personNumber);
    }

    public static ExMember createExMember(String name, String personNumber) {
        return new ExMember(name, personNumber);
    }

    public static UnauthorizedPerson createUnauthorizedPerson(String name, String personNumber) {
        return new UnauthorizedPerson(name, personNumber);
    }
}
