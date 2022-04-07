package com.github.AlessandroLimaSilva.test;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Login.feature",
        glue = {"classpath:com.github.AlessandroLimaSilva.stepdefinitions",
                "classpath:com.github.AlessandroLimaSilva.test"},
        tags = "@automatizado")

public class LoginTest {

}
