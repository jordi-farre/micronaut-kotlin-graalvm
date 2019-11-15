package example.micronaut.kotlin

import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.http.ContentType.JSON
import org.hamcrest.Matchers.matchesPattern
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class PaymentControllerFeature {

    @Inject
    lateinit var server: EmbeddedServer

    @Test
    fun `should register a payment`() {
        given()
            .port(server.port)
            .contentType(JSON)
            .body("""{"amount": 12.25}""")
        .`when`()
            .post("/payments")
        .then()
            .statusCode(200)
            .body("transactionId", matchesPattern("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})"))
    }

}