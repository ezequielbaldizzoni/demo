package com.demo.page

import com.demo.core.DriverManager

data class SecureAreaPageSelectors (
    val flashCss: String = "#flash",
)
class SecureAreaPage: BasePage() {
    private val selectors = SecureAreaPageSelectors()

    fun getFalshText(): String {
        val element = findElementByCss(selectors.flashCss)
        return element.text;
    }
}