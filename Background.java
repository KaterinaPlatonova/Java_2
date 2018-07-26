import java.awt.*;

public class Background{

    private Color color = new Color(
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255)
    );

    Background() {

    }

    void background(GameCanvas canvas, float lastFrameTime){
        canvas.setBackground(color);

    }


}
