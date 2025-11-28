package com.demo.page

import com.demo.core.DriverManager
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.support.ui.ExpectedConditions as EC
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

open class BasePage {
    protected val driver = DriverManager.getDriver()
    private val fluentWait = FluentWait(driver)

    init {
        fluentWait.withTimeout(Duration.ofMillis(1000))
            .pollingEvery(Duration.ofMillis(100))
            .ignoring(NoSuchElementException::class.java)
    }
    protected fun findElementById(id: String): WebElement {
        fluentWait.until(EC.visibilityOfElementLocated(By.id(id)))
        return driver.findElement(By.id(id))
    }

    protected fun findElementByCss(css: String): WebElement {
        fluentWait.until(EC.visibilityOfElementLocated(By.cssSelector(css)))
        return driver.findElement(By.cssSelector(css))
    }
}