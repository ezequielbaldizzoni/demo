package com.demo.spec
import io.kotest.core.spec.style.DescribeSpec

import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When

import org.hamcrest.Matchers.*

import org.codehaus.groovy.tools.shell.util.Preferences.get
import io.kotest.core.annotation.Tags


@Tags("api")
class ApiTest : DescribeSpec() {
    init {
        it("the post exists") {

            When {
                get("https://jsonplaceholder.typicode.com/posts/1")
            } Then {
                statusCode(200)
                body("id", equalTo(1))
                body("title", not(equalTo("")))
            }

        }

    }

}