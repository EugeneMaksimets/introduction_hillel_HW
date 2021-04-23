import java.util.SplittableRandom;

public class Random {
    public static void main(String[] args) {
        SplittableRandom random = new SplittableRandom();
        int randomInt = random.nextInt(1, 7);
        boolean isEvenNumberBool = isEvenNumber(randomInt);
        String isEvenNumberTwo = isEvenNumber(isEvenNumberBool);
        String text = null;
        switch (randomInt) {
            case 1:
                text = " Передвинтись на шаг вперед " + isEvenNumberTwo;
                break;
            case 2:
                text = " Передвинтись на два шага вперед " + isEvenNumberTwo;
                break;
            case 3:
                text = " Передвинтись на три шага вперед " + isEvenNumberTwo;
                break;
            case 4:
                text = " Передвинтись на четыри шага вперед " + isEvenNumberTwo;
                break;
            case 5:
                text = " Передвинтись на пять шагов вперед " + isEvenNumberTwo;
                break;
            case 6:
                text = " Передвинтись на шесть шагов вперед " + isEvenNumberTwo;
                break;

        }
        System.out.println(text);
    }

    public static boolean isEvenNumber(int randomInt) {

        boolean result;
        if (randomInt % 2 == 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static String isEvenNumber(boolean isEvenNumberBool) {
        String new_text;
        if (isEvenNumberBool == false) {
            new_text = " это число не четное";
        } else {
            new_text = "число четное";
        }
        return new_text;

    }


}


