public class Doska {

    public static void main(String[] args) {
        int sizeLength = 8;
        int sizeWedth = 8;
        String board = " ";
        for (int i = 0; i < sizeLength; i++) {
            for (int j = 0; j < sizeWedth; j++) {
                if ((i + j) % 2 == 0)
                    board += " ";
                else
                    board += "#";
            }
            board += "\n";

        }

        System.out.println(board);
    }

}




