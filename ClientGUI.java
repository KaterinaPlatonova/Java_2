import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    //добавление элементов на верхнюю панель
    private final JTextArea fieldForChat = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField textFieldIPAddress = new JTextField("127.0.0.1");
    private final JTextField textFieldPort = new JTextField("8189");
    private final JCheckBox checkBoxAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField textFieldLogin = new JTextField("Kat");
    private final JPasswordField textFieldPassword = new JPasswordField("888");
    private final JButton buttonLogin = new JButton("Login");

    //Добавление нижней панели
    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("Disconnect");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList userList = new JList<>();


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServGUI();
            }
        });
    }

    public ClientGUI() {
        Thread.getDefaultUncaughtExceptionHandler();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Hello RAINBOW Chat!");

        fieldForChat.setEditable(false); //в поле чата не возможно будет писать
        JScrollPane scrollFieldForChat = new JScrollPane(fieldForChat); // прокрутка поля для чата
        JScrollPane scrollUserList = new JScrollPane(userList);

        String[] users = {"user1", "user2", "user3", "user4", "user5", "user6", "user7", "user8", "user9", "user10"};
        userList.setListData(users);
        scrollUserList.setPreferredSize(new Dimension(100, 0));
        checkBoxAlwaysOnTop.addActionListener(this);
        buttonLogin.addActionListener(this);
        btnSend.addActionListener(this);

        panelTop.add(textFieldIPAddress); // добавляем каждый элемента НА ВЕРХНЮЮ панель
        panelTop.add(textFieldPort);
        panelTop.add(checkBoxAlwaysOnTop);
        panelTop.add(textFieldLogin);
        panelTop.add(textFieldPassword);
        panelTop.add(buttonLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST); // добавляем элементы НА НИЖНЮЮ панель
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(panelTop, BorderLayout.NORTH); // добавляем саму ВЕРХНЮЮ панель на JFrame и устанавливаем ее местоположение
        add(scrollFieldForChat, BorderLayout.CENTER);// добавляем поле для чата на JFrame и устанавливаем его местоположение
        add(panelBottom, BorderLayout.SOUTH);
        add(scrollUserList, BorderLayout.EAST);


        setLocationRelativeTo(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == checkBoxAlwaysOnTop) {
            // setAlwaysOnTop(!isAlwaysOnTop());
            setAlwaysOnTop(checkBoxAlwaysOnTop.isSelected());
        } else if (src == btnSend) {
//          поиск нужного метода для получения текста
//            .dispatchEvent();
//            .addInputMethodListener();
//            .write();
//            .setAction();
            File file = new File("text.txt");

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                String str = tfMessage.getText(); //
                writer.write(str + "\n");
                writer.flush();
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace(); // доделать, д.б не только stacktrace
            }
        } else {
            throw new RuntimeException("Unknown source: " + src);
        }
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String exeptionMessage;
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        if (stackTraceElements.length == 0) {
            exeptionMessage = "Empty stacktrace";
        } else {
            exeptionMessage = e.getClass().getCanonicalName() + ": " + e.getMessage() + "\n\t at " + stackTraceElements[0];
        }
        JOptionPane.showMessageDialog(null, exeptionMessage, "Exeption", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

}
