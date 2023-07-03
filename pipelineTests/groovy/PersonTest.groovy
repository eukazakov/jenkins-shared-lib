import com.lesfurets.jenkins.unit.BasePipelineTest
import foo.bar.Person
import foo.bar.PersonID
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonTest extends BasePipelineTest{

    @Override
    @BeforeAll
    void setUp() throws Exception {
        scriptRoots += 'vars'
        super.setUp()
    }

    @Test
    void testHello() {
        def persObj = new PersonID("John", "Doe", 35)
        assert new Person().getPerson(persObj) == "John"
    }

    @Test
    void testJson() {
        def script = loadScript('vars/jsonSmthg.groovy')
        println(script.validateJson("", ""))
    }
}
