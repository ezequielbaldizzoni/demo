package com.demo.spec

import io.restassured.RestAssured.*

class Main {
    fun test() {
        get("/lotto").then().assertThat().body("lotto.lottoId", equalTo(5));

    }
}