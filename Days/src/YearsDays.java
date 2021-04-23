public class YearsDays {


    public static void main(String[] args) {
        int minutes = 3456789;

        System.out.println(minutes + " минут = " + convertMinToYears() + " лет " + convertMinToDays() + " дней");
    }

    public static int convertMinToYears() {
        int minutes = 3456789;
        int minInHour = 60;
        int hourInDay = 24;
        int dayInYear = 365;
        int years = minutes / minInHour / hourInDay / dayInYear;
        return years;

    }

    public static int convertMinToDays() {
        int minutes = 3456789;
        int minInHour = 60;
        int hourInDay = 24;
        int dayInYear = 365;
        int days = minutes / minInHour / hourInDay % dayInYear;
        return days;

    }
}


