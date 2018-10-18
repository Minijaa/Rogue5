package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest{
    App newApp;

    @BeforeEach
    void setUp() {
        newApp = new App();
    }


    @Test
    public void testNormalizeString(){
        String actualOutput = newApp.normalizeString(" unNormalizedString");
        String expectedOutput = "Unnormalizedstring";

        assertEquals(expectedOutput,actualOutput);

    }

}
