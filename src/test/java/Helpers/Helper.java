package Helpers;

import java.util.Random;

public class Helper {

    public int generateRandomNumber(int start, int end) {
        return (int) (Math.random() * end) + start;
    }

    public String generateRandomCharacters(int max) {
        Random random = new Random();
        char letter;
        String letters = "";
        for (int i = 0; i < max; i++) {
            letter = (char) (random.nextInt(26) + 'a');
            letters = letters + letter;
        }
        return letters;
    }
}
