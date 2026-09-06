package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionAlexTest {

    private LionAlex alex;

    @Before
    public void setUp() throws Exception {
        Feline feline = new Feline();
        alex = new LionAlex(feline);
    }

    @Test
    public void getFriendsReturnsCorrectFriends() {
        List<String> expectedFriends = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");

        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsCorrectPlace() {
        String expectedPlace = "Нью-Йоркский зоопарк";

        assertEquals(expectedPlace, alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensDelegatesToFelineWithZero() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        LionAlex mockAlex = new LionAlex(mockFeline);
        mockAlex.getKittens();

        Mockito.verify(mockFeline).getKittens(0);
    }

    @Test
    public void getKittensReturnsDelegatedValue() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        LionAlex mockAlex = new LionAlex(mockFeline);
        Mockito.when(mockFeline.getKittens(0)).thenReturn(0);

        assertEquals(0, mockAlex.getKittens());
    }

}
