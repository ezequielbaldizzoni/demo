package com.demo.page

import com.demo.core.DriverManager

data class LoginPageSelectors (
    val usernameId: String = "username",
    val passwordId: String = "password",
    val buttonCss: String = "#login > button",
)
class LoginPage: BasePage() {
    private val selectors = LoginPageSelectors()
    fun inputUsername(username: String) {
        val element = findElementById(selectors.usernameId)
        element.click();
        element.sendKeys(username);
    }

    fun inputPassword(password: String) {
        val element = findElementById(selectors.passwordId)
        element.click();
        element.sendKeys(password);
    }

    fun clickLoginButton() {
        val element = findElementByCss(selectors.buttonCss)
        element.click();
    }
}