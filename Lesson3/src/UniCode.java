import java.util.Scanner;


public class UniCode {


    public static void main(String[] args) {
        System.out.println("Введите букву используя раскладку кирилица: ");
        Scanner uniScan = new Scanner(System.in);
        String latter = uniScan.nextLine();

        int uni = latter.codePointAt(0);
        final String CONSONANTS_LATTER = "Буква согласная";
        final String NO_CONSONANTS_LATTER = "Буква гласная";
        final String ANOTHER_ONE = "Твердый знак";
        final String ANOTHER = "Мягкий знак";
        final String ERROR = "Ошибка. Введите букву используя кириллицу";
        final String ERROR_TWO = "Ошибка. Введите одну букву";
        String finalText;
        if (latter.length() > 1) {
            finalText = ERROR_TWO;
        } else if (uni == 1105 || uni == 1025) {
            finalText = CONSONANTS_LATTER;
        } else if (uni < 1040 || uni > 1103) {
            finalText = ERROR;
        } else if (uni == 1040 || uni == 1045 || uni == 1048 || uni == 1049 || uni == 1054 || uni == 1059 ||
                uni == 1067 || uni == 1069 || uni == 1070 || uni == 1071 || uni == 1072 || uni == 1077 ||
                uni == 1080 || uni == 1081 || uni == 1091 || uni == 1086 || uni == 1099 || uni == 1101 ||
                uni == 1102 || uni == 1103) {
            finalText = CONSONANTS_LATTER;
        } else if (uni == 1066 || uni == 1098) {
            finalText = ANOTHER_ONE;
        } else if (uni == 1068 || uni == 1100) {
            finalText = ANOTHER;
        } else {
            finalText = NO_CONSONANTS_LATTER;
        }
        System.out.println(finalText);

    }
}