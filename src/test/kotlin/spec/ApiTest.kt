package spec
import io.kotest.core.spec.style.DescribeSpec

import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When

import org.hamcrest.Matchers.*

import org.codehaus.groovy.tools.shell.util.Preferences.get


class ApiTest : DescribeSpec() {
    init {
        it("user should have a session token") {

            When {
                get("https://jsonplaceholder.typicode.com/posts/1")
            } Then {
                statusCode(200)
                body("id", equalTo(1))
            }

        }

    }

}