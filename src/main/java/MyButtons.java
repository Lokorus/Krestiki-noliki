import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MyButtons extends JPanel {

    private JButton NewGame, Ex;
    private MyPanel Butr;
    /**
     * Создаем панель с игрой
     */
    public void SetObject(MyPanel B) {
        Butr = B;
    }
    /**
     * В конструкторе создаем кнопки Новая игра и Выход, наделяем их нужными функциями
     */
    MyButtons() {
        setLayout(new FlowLayout());
        NewGame = new JButton("Новая игра");
        Ex = new JButton("Выход");
        NewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Butr.Rese();
            }
        });
        Ex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        add(NewGame);
        add(Ex);
    }
}