import java.util.Scanner;

public class Char {
    public static void main(String[] args) {
        System.out.println("Значение \"p\" буква? Ответ: " + Character.isLetter('p'));
        System.out.println("Значение \"@\" буква? Ответ: " + Character.isLetter('@'));
        System.out.println("Значение \"1\" буква? Ответ: " + Character.isLetter('1'));

        // Character.isLetter- Java определяет, является ли указанное значение
        // типа char буквой

        System.out.println("Значение \"0\" цифра? Ответ: " + Character.isDigit('0'));
        System.out.println("Значение \"p\" цифра? Ответ: " + Character.isDigit('p'));
        // Character.isDigit() — определяет, является ли указанное значение типа char цифрой

        System.out.println("Значение \"0\" пробел? Ответ: " + Character.isWhitespace('c'));
        System.out.println("Значение \" \" пробел? Ответ: " + Character.isWhitespace(' '));
        //isWhitespace () используется для определения указанный символ представляет собой
        // символ пробела, содержит пробелы

        System.out.println("Значение \"R\" в верхнем регистре? Ответ: " + Character.isUpperCase('R'));
        System.out.println("Значение \"o\" в верхнем регистре? Ответ: " + Character.isUpperCase('o'));
        //  Character.isUpperCase() — в Java определяет, находится ли указанное значение типа char
        //  в верхнем регистре

        System.out.println("Значение \"R\" в верхнем регистре? Ответ: " + Character.isLowerCase('R'));
        System.out.println("Значение \"o\" в верхнем регистре? Ответ: " + Character.isLowerCase('o'));
        // isLowerCase() - в Java определяет, находится ли указанное значение типа char
        //  в нижнем регистре

        System.out.println("Значение \"i\" в верхнем регистре: " + Character.toUpperCase('i'));
        System.out.println("Значение \"d\" в верхнем регистре: " + Character.toUpperCase('d'));
        //Character.toUpperCase() — в Java возвращает указанное значение типа char в верхнем регистре

        System.out.println("Значение \"i\" в нижнем регистре: " + Character.toLowerCase('I'));
        System.out.println("Значение \"i\" в нижнем регистре: " + Character.toLowerCase('D'));
        //Character.toUpperCase() — в Java возвращает указанное значение типа char в нижнем регистре

        System.out.println("Значение \"" + Character.toString('P') + "\" теперь строковый объект.");
        System.out.println("Значение \"" + Character.toString('r') + "\" теперь строковый объект.");
        //Character.toString() — возвращает строковый объект
        // (String) и представляет указанное char-значение как одну символьную строку


    }
}

