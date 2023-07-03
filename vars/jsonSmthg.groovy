@GrabResolver(name = 'jitpack', root = 'https://jitpack.io/')
@Grab('net.jimblackler.jsonschemafriend:core:0.11.4')
import net.jimblackler.jsonschemafriend.Schema
import net.jimblackler.jsonschemafriend.SchemaException
import net.jimblackler.jsonschemafriend.SchemaStore
import net.jimblackler.jsonschemafriend.Validator

def validateJson(String jsonPath, String schemaPath) {
    def schemaString = """{
            "\$schema": "http://json-schema.org/draft-07/schema#",
            "type": "integer"
             }"""

    try {
        SchemaStore schemaStore = new SchemaStore()
        Schema schema = schemaStore.loadSchemaJson(schemaString)
        Validator validator = new Validator()
        validator.validateJson(schema, "1")
        validator.validateJson(schema, "true")
    } catch (SchemaException e) {
        return e.toString()
    }
}