public class Main {

    static String str = ("1312232256713310");
    static String[][] arrayString = new String[4][4];
    static int[][] arrayInt = new int[4][4];

    public static void main(String[] args) {

        System.out.println("---Массив строк---");
        try {
            fromStringToArray(str);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("В массиве не достаточно места.");
            e.printStackTrace();
        }

        System.out.println("---Массив чисел---");
        try {
            makeInt(arrayString);
        } catch (ArrayStoreException e) { // если в изначальном строковом массиве было не числовое значеие (символ или слово)
            System.out.println("Попытка добавить не числовое значение.");
            e.printStackTrace();
        }

        System.out.println("---Сумма элементов массива / 2---");
        System.out.println("Результат вычисления = " + countSumAndDivideTwo(arrayInt));

    }

    static void fromStringToArray(String str) throws IndexOutOfBoundsException { // создание двумерного массива из строки
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                String x = String.valueOf(str.charAt(temp)); //??
                arrayString[i][j] = x;
                System.out.print(arrayString[i][j] + " ");
                temp++;
            }
            System.out.println(" ");
        }
    }

    static void makeInt(String[][] array) throws ArrayStoreException { //приведение массива строк к массиву чисел
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int b = Integer.valueOf(array[i][j]);
                arrayInt[i][j] = b;
                System.out.print(arrayInt[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static int countSumAndDivideTwo(int[][] arrayInt) { // выполнение арифметической операции с массивом чисел
        int b = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            for (int j = 0; j < arrayInt.length; j++) {
                b += arrayInt[i][j];
            }
        }
        return b / 2;
    }
}
