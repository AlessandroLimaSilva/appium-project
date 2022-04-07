package com.github.AlessandroLimaSilva.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;
import java.net.MalformedURLException;

public class CucumberHooks {

    @Before
    public void cheguei() throws MalformedURLException {

        //DriverBase.DriverFactory();
    }

    @After
    public void AfterTest() throws IOException
    {
        //DriverBase.QuitInstance();
    }
}
