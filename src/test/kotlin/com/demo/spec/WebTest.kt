package com.demo.spec
import com.demo.page.LoginPage
import com.demo.page.SecureAreaPage
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.annotation.Tags
import io.kotest.matchers.string.shouldContain


@Tags("web")

class WebTest : DescribeSpec() {

    private val loginPage: LoginPage by lazy { LoginPage() }
    private val secureAreaPage: SecureAreaPage by lazy { SecureAreaPage() }

    init {
        it("user should have a session token") {


            loginPage.inputUsername("tomsmith")
            loginPage.inputPassword("SuperSecretPassword!")
            loginPage.clickLoginButton()

            val flashText = secureAreaPage.getFalshText()
            flashText shouldContain "You logged into a secure area!"

        }

    }

}