package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsCatSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodCallsPredatorEatMeat() throws Exception {
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

    @Test
    public void getFoodReturnsPredatorEatMeatResult() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        assertEquals(expectedFood, cat.getFood());
    }

}
