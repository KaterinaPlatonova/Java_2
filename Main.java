public class Main {

    static String str = ("1312232256713310");
    static String[][] arrayString = new String[4][4];
    static int[][] arrayInt = new int[4][4];

    public static void main(String[] args) {

        fromStringToArray(str);
        System.out.println("**************************");

        makeInt(arrayString);
        System.out.println("*************************");

        System.out.println(countSummAndDividetwo(arrayInt));

    }

    static void fromStringToArray(String str) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String x = String.valueOf(str.charAt(j)); //??
                arrayString[i][j] = x;
                System.out.print(arrayString[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static void makeInt(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int b = Integer.valueOf(array[i][j]);
                arrayInt[i][j] = b;
                System.out.print(arrayInt[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static int countSummAndDividetwo(int[][] arrayInt) {
        int b = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            for (int j = 0; j < arrayInt.length; j++) {
                b += arrayInt[i][j];
            }
        }
        return b / 2;
    }
}
