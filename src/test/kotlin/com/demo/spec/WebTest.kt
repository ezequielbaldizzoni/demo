package com.demo.spec
import com.demo.core.DriverManager
import com.demo.page.LoginPage
import com.demo.page.SecureAreaPage
import io.kotest.core.annotation.Tags
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.string.shouldContain
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import java.io.File
import java.sql.DriverManager.println


@Tags("web")

class WebTest : DescribeSpec() {

    private val loginPage: LoginPage by lazy { LoginPage() }
    private val secureAreaPage: SecureAreaPage by lazy { SecureAreaPage() }

    init {
        afterTest { (test, result) ->
            if (result.isFailure) {
                val scrFile: File = (DriverManager.getDriver() as TakesScreenshot).getScreenshotAs<File>(OutputType.FILE)
                FileUtils.copyFile(scrFile, File("${test.name.name}.png"))
            }
        }

        afterSpec {
            DriverManager.getDriver().quit()
        }

        it("user should have a session token") {


            loginPage.inputUsername("tomsmith")
            loginPage.inputPassword("SuperSecretPassword!")
            loginPage.clickLoginButton()

            val flashText = secureAreaPage.getFalshText()
            flashText shouldContain "wYou logged into a secure area!"

        }



    }

}