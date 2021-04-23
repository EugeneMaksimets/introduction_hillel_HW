import java.util.Scanner;

public class Printer {

    private int tonerLevel;
    private int printPaper;
    private final boolean duplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        if (tonerLevel > 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;

        } else {

            this.tonerLevel = 0;

        }
        this.printPaper = 0;
        this.duplex = isDuplex;

    }


    public int print(int pages) {
        int paperToPrint = pages;
        if (tonerLevel > 0) {
            if (this.duplex) {
                paperToPrint /= 2;
                System.out.println("\n Вы используете - Дюплекснный принтер.");

            } else {
                this.printPaper += paperToPrint;
                System.out.println("\n Вы используете - Обычный принтер");
            }


        }

        if (this.tonerLevel - pages < 0) {
            if (duplex) {
                this.printPaper = pages - tonerLevel / 2;
            } else {
                this.printPaper = pages - tonerLevel;
            }
            addToner();
        }


        return paperToPrint;
    }


    private void addToner() {
        this.tonerLevel = 0;

        System.out.println("Необходимо заправить тонер. Не распечатано: " + printPaper + " листов. " +
                "\n Введите на сколько процентов заправить тонер:");
        Scanner scanToner = new Scanner(System.in);
        int tonerAmount = scanToner.nextInt();
        this.tonerLevel += tonerAmount;
        if (tonerLevel > 100) {
            this.tonerLevel = 0;
            System.out.println("Ошибка: невозможно заправить тонер больше чем на 100 процентов");
            addToner();
        }
        if (duplex) {
            this.tonerLevel /= 2;
        }
        if (tonerLevel < printPaper) {
            this.printPaper -= tonerLevel;
            addToner();

        }
    }
}



