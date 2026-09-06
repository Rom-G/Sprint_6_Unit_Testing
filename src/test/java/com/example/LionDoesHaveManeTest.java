package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionDoesHaveManeTest {

    private final Feline feline;
    private final String sex;
    private final boolean expectedHasMane;

    public LionDoesHaveManeTest(Feline feline, String sex, boolean expectedHasMane) {
        this.feline = feline;
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        Feline feline = new Feline();
        return new Object[][] {
                { feline, "Самец", true },
                { feline, "Самка", false },
        };
    }

    @Test
    public void doesHaveManeReturnsExpectedForValidSex() throws Exception {
        Lion lion = new Lion(feline, sex);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

}
