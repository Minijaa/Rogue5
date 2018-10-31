package com.inte.group4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    App newTestApp;

    @BeforeEach
    void setUp() throws Exception {
        newTestApp = new App();
    }

    @Test
    public void testNormalizeString() {
        String actualOutput = newTestApp.normalizeString(" unNormalizedString");
        String expectedOutput = "Unnormalizedstring";

        assertEquals(expectedOutput, actualOutput);

    }
    @Test
    public void testTravelDirectionInvalidMove(){
        String expextedOutPut = "Invalid move!!";
        String actualOutPut = newTestApp.travelDirection(10, 10);
        assertEquals(expextedOutPut,actualOutPut);

    }

    @Test
    public void testValidPlayerMove() {



    }

}
