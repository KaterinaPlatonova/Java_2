import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {
    private static final int POS_X = 600; //константы для окна
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        //согласно документации для правильной работы
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    MainWindow() { //создание окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);// установка окна в середина экрана
        setTitle("Bubbles");

        GameCanvas gameCanvas = new GameCanvas(this); // создание игрвой конвы, которая будет отрисовываться
        add(gameCanvas, BorderLayout.CENTER);
        initGame();

        gameCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Bubble bubble = new Bubble();
                initGame(bubble);
            }
        });
        setVisible(true);
    }

    Sprite[] sprites = new Sprite[10];
    Sprite[] sprites2 = new Sprite[10];

    private void initGame() {

        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Bubble();
        }

    }

    private void initGame(Bubble bubble) {

        for (int i = 0; i < sprites2.length; i++) {
            sprites2[i] = bubble;
        }

    }
    public void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) { //метод, который будет вызываться после отрисовки
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(gameCanvas, deltaTime);
        }
    }

    private void render(GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(gameCanvas, g);
        }
    }

}
