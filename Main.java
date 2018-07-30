
public class Main {

    static String str = ("1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0");
    static String[][] arrayString = new String[4][4];
    static int[][] arrayInt = new int[4][4];

    public static void main(String[] args) {
        try {
            System.out.println("---Массив строк---");
            fromStringToArray(str);

            System.out.println("---Массив чисел---");
            makeInt(arrayString);
        } catch (NumberFormatException e) {// если в изначальном строковом массиве было не числовое значеие (символ или слово)
            System.out.println("Попытка добавить не числовое значение.");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("В массиве не достаточно места.");
            e.printStackTrace();
        }

        System.out.println("---Сумма элементов массива / 2---");
        System.out.println("Результат вычисления = " + countSumAndDivideTwo(arrayInt));
    }

    static void fromStringToArray(String str) throws IndexOutOfBoundsException { // создание двумерного массива из строки
        String[] st = str.split("\n");
        for (int i = 0; i < st.length; i++) {
            st[i] = st[i].replace(" ", "");
        }
        for (int i = 0; i < arrayString.length; i++) {
            for (int j = 0; j < arrayString.length; j++) {
                arrayString[i][j] = String.valueOf(st[i].charAt(j));
                System.out.print(arrayString[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static void makeInt(String[][] array) throws NumberFormatException { //приведение массива строк к массиву чисел
        for (int i = 0; i < array[i].length; i++) {
            for (int j = 0; j < array[i].length; j++) {
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
