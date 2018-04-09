import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {

    private JButton[] buttons;
    private Play GArray;
    private int PlayerMark = 1;
    private int DrawCheck = 0;
    /**
     создаем панель и добавляем кнопки
     */
    MyPanel() {
        setLayout(new GridLayout(3, 3));
        buttons = new JButton[9];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setBackground(Color.YELLOW);
        }
        Rese();
        for (int i=0; i < buttons.length; i++) {
            add(buttons[i]);
            buttons[i].addActionListener(this);
        }
    }
    /**
     сбрасываем панель на начальные настройки
     */
    public void Rese() {
        GArray = new Play(this);
        EmptyText();
        AllButtons(true);
        PlayerMark = 1;
        DrawCheck = 0;
    }
    /**
     при нажатии кнопки заполняем массив и проверяем на каждом шагу результат игры
     */
    public void actionPerformed(ActionEvent E) {
        JButton Pressed = (JButton) E.getSource();
        for (int button = 0; button <= 8; button++) {
            if (Pressed == buttons[button]) {
                MyText(Pressed, PlayerMark);
                GArray.InArray(button / 3, button % 3, PlayerMark, DrawCheck);
                PlayerMark = SwithcPlayer(PlayerMark);
                ButtonFalse(buttons[button]);
                DrawCheck = DrawCheck+1;
            }
        }
    }


    /**
     * Меняем игроков после хода
     * @param last чей ход был последним.
     */
    public int SwithcPlayer(int last) {
        if (last == 2) {
            PlayerMark = 1;
            return 1;

        } else {
            PlayerMark = 2;
            return 2;
        }
    }
    /**
     * Делаем кнопку неактивной
     * @param Btn кнопка, которую нужно сделать неактивной.
     */
    public void ButtonFalse(JButton Btn) {
        Btn.setEnabled(false);
    }
    /**
     * Делаем все кнопки активными или нет, зависит от этапа игры
     * @param qq переменная, показывающая, в какое состояние нужно перевести кнопки.
     */
    public void AllButtons(boolean qq) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(qq);
        }
    }
    /**
     * Заполняем пустым текстом клетки
     */
    public void EmptyText() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText("");
        }
    }
    /**
     * Пишем крестики-нолики в клетки
     * @param Btn клетка, в которую нужно написать
     * @param Play игрок, который сходил
     */
    public void MyText(JButton Btn, int Play) {
        if (Play == 2) {
            Btn.setText("O");
        } else if (Play == 1) {
            Btn.setText("X");
        }
    }
}