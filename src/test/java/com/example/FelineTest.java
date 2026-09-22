package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeatReturnsMockedFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFelineFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNoArgReturnsOne() throws Exception {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithArgReturnsCount() throws Exception {
        assertEquals(3, feline.getKittens(3));
    }

    @Test
    public void getKittensWithNegativeArgThrowException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> feline.getKittens(-1));

        assertEquals("Количество котят не может быть отрицательным", exception.getMessage());
    }

}
