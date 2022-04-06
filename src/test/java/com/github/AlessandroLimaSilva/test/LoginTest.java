package com.github.AlessandroLimaSilva.test;

import com.github.AlessandroLimaSilva.bases.DriverBase;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import java.net.MalformedURLException;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Login.feature",
        glue = {"classpath:com.github.AlessandroLimaSilva.stepsdefinitions",
                "classpath:com.github.AlessandroLimaSilva.steps",
                "classpath:com.github.AlessandroLimaSilva.pages",
                "classpath:com.github.AlessandroLimaSilva.test"},
        tags = "@automatizado")

public class LoginTest {

    @BeforeClass
    public static void Driver() throws MalformedURLException {
        DriverBase.CreateInstance();
    }
}
