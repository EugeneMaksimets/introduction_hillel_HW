
public class MainPrinter {

    public static void main(String[] args) {


        String FINAL_TEXT = "Количество напечатаных листов ";

        Printer printerWithOutDuplex = new Printer(100, false);
        int pagesPrinted = printerWithOutDuplex.print(140);
        System.out.println(FINAL_TEXT + pagesPrinted);
        Printer printer = new Printer(50, true);
        pagesPrinted = printer.print(50);
        System.out.println(FINAL_TEXT + pagesPrinted);
        Printer printerWithOutToner = new Printer(0, true);
        pagesPrinted = printerWithOutToner.print(430);
        System.out.println(FINAL_TEXT + pagesPrinted);

    }
}


