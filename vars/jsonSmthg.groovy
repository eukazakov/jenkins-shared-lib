@Grab('com.networknt:json-schema-validator:1.0.72')
@Grab('com.fasterxml.jackson.core:jackson-databind:2.15.2')
import com.networknt.schema.JsonSchema
import com.networknt.schema.JsonSchemaFactory
import com.networknt.schema.SpecVersion
import com.networknt.schema.ValidationMessage
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

private static def InputStream inputStreamFromClasspath(String path) {
    return Thread.currentThread().getContextClassLoader().getResourceAsStream(path)
}

def validateJson(String jsonPath, String schemaPath) {
    ObjectMapper objectMapper = new ObjectMapper()
    def schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909)

    try (
            InputStream jsonStream = inputStreamFromClasspath(jsonPath);
            InputStream schemaStream = inputStreamFromClasspath(schemaPath)
    ) {
        JsonNode json = objectMapper.readTree(jsonStream)
        JsonSchema schema = schemaFactory.getSchema(schemaStream) as JsonSchema
        Set<ValidationMessage> validationResult = schema.validate(json)

        if (validationResult.isEmpty()) {
            System.out.println("no validation errors :-)");
        } else {
            validationResult.forEach(vm -> System.out.println(vm.getMessage()));
        }
    }
}