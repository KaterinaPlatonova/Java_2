import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    private static final int POS_X = 1500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 100;

    private final ChatServer chatServer = new ChatServer();
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Finish");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServGUI();
            }
        });
    }

    public ServGUI() {
        Thread.getDefaultUncaughtExceptionHandler(); //устанавливаем default обработчика исключений
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Server chat");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(1, 2));
        btnStart.addActionListener(this);// добавление к кнопке слушателя
        add(btnStart);
        btnStop.addActionListener(this);
        add(btnStop);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnStart) { // сравнение идет по ссылкам????
            chatServer.start(8189);
//            throw new RuntimeException("Hello from EDT");
        } else if (src == btnStop) {
            chatServer.stop();
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String exeptionMessage;
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        if (stackTraceElements.length == 0){
            exeptionMessage = "Empty stacktrace";
        }else {
            exeptionMessage = e.getClass().getCanonicalName() + ": " + e.getMessage() + "\n\t at " + stackTraceElements[0];
        }
        JOptionPane.showMessageDialog(null, exeptionMessage, "Exeption", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
}

