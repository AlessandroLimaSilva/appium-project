package com.github.AlessandroLimaSilva.hooks;

import com.github.AlessandroLimaSilva.bases.DriverBase;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import javax.swing.*;
import java.io.IOException;

public class CucumberHooks {

    @Before
    public void cheguei(){
        JOptionPane.showMessageDialog(null,"Bicha louca");
    }

    @After
    public void AfterTest() throws IOException
    {
        DriverBase.QuitInstance();
    }
}
