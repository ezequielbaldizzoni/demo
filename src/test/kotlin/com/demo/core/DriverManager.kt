package com.demo.core

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver



class DriverManager {
    companion object {
        private var driver : WebDriver? = null
        fun getDriver(): WebDriver {
            driver = driver ?: newDriver()
            return driver as WebDriver
        }

        private fun newDriver(): WebDriver {
            WebDriverManager.chromedriver().setup()
            val driver = ChromeDriver()
            driver.get("https://the-internet.herokuapp.com/login")
            return driver
        }
    }
}