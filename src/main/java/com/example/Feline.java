package com.example;

import java.util.List;

public class Feline extends Animal implements Predator, FelineBehaviour {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    @Override
    public int getKittens() throws Exception {
        return getKittens(1);
    }

    @Override
    public int getKittens(int kittensCount) throws Exception {
        if (kittensCount < 0) {
            throw new Exception("Количество котят не может быть отрицательным");
        }
        return kittensCount;
    }

}
