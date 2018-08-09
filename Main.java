public class Main extends Thread{

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    static float[] a1;
    static float[] a2;

    public static void main(String[] args) {
	createArray1();
	createArray2();
    }

    private static void createArray1() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();

        System.out.println(b - a);
    }

    private static void createArray2() {

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        new Main().start();
        new Main().start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
    }


    @Override
    public void run() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < a1.length; i++) {
            a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();

        System.out.println(b - a);

        long c = System.currentTimeMillis();
        for (int i = 0; i < a2.length; i++) {
            a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long d = System.currentTimeMillis();

        System.out.println(c - d);
    }
}
