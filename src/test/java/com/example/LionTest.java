package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion(feline, "Самец");
    }

    @Test
    public void constructorThrowsForInvalidSexWithExpectedMessage() {
        try {
            new Lion(new Feline(), "AlphaMale");
            Assert.fail("Ожидаемое исключение не было сгенерировано");
        } catch (Exception e) {
            assertEquals(
                    "Используйте допустимые значения пола животного - Самец или Самка",
                    e.getMessage()
            );
        }
    }

    @Test
    public void getKittensDelegatesToFelineNoArg() throws Exception {
        lion.getKittens();

        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getKittensReturnsDelegatedValue() throws Exception {
        int expectedNumberOfKittens = 1;
        Mockito.when(feline.getKittens()).thenReturn(expectedNumberOfKittens);

        assertEquals(expectedNumberOfKittens, lion.getKittens());
    }

    @Test
    public void getFoodCallsPredatorEatMeat() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of());
        lion.getFood();

        Mockito.verify(feline).eatMeat();
    }

    @Test
    public void getFoodReturnsPredatorEatMeatResult() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        assertEquals(expectedFood, lion.getFood());
    }

}
