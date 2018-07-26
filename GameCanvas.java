import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends JPanel {

    private MainWindow mainWindow;
    private long lastFrameTime;
//    protected Sprite[] sprites1;

    GameCanvas(MainWindow mainWindow) {
        this.mainWindow = mainWindow; //передаем взаимодействие с mainWindow
        lastFrameTime = System.nanoTime();  //задаем в переменную время для последней отрисовки
//        setBackground(Color.BLUE); // устанавливаем цвет фона
        Background background = new Background();
        background.background(this, lastFrameTime);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);// отрисовка графики

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.0000000001f;
        lastFrameTime = currentTime;

        try {
            Thread.sleep(16); //остановка для дальнейшей отрисовки
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainWindow.onDrawFrame(this, g, deltaTime); // вызов метода главного окна, обновления и отрисовки
        repaint(); // метод вызывает метод отрисовки paintComponent, зацикливаем
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }

//    void newBubble() {
//        long currentTime = System.nanoTime();
//        float deltaTime = (currentTime - lastFrameTime) * 0.0000000001f;
//        lastFrameTime = currentTime;
//
//        Bubble bubble = new Bubble();
//        bubble.update(this, deltaTime);
//    }

}
