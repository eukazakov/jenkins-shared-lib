import foo.bar.Person
import foo.bar.PersonID
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    void testHello() {
        def persObj = new PersonID("John", "Doe", 35)
        assert new Person().getPerson(persObj) == "John"
    }
}
