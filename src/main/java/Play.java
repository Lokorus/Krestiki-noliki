import javax.swing.*;

/**
 * Класс, в котором происходит сам процесс игры, то есть заполнение панели, запись каждого хода и результат игры.
 */
public class Play {
    private MyPanel Pan;
    private int PlayBoard[][];
    public int k;
    /**
     * Заполняем массив, являющийся нашим полем, нулями
     * @param B панель, на которой мы играем
     */
    Play(MyPanel B) {
        PlayBoard = new int[3][3];
        Pan = B;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                PlayBoard[i][j] = 0;
            }
        }
    }
    /**
     * Записываем каждый ход и проверяем не окончилась ли игра
     * @param i координаты нашего хода
     * @param j координаты нашего хода
     * @param Check номер игрока, который сходил
     * @param DrawCheck счетчик, который помогает проверить ничью
     */
    public void InArray(int i, int j, int Check, int DrawCheck) {
        PlayBoard[i][j] = Check;
        ResultCheck(Check, DrawCheck);
    }

    /**
     * Проверка результата игры
     * @param Check номер игрока, сходившего ход
     * @param DrawCheck счетчик для проверки ничьей
     */
    public void ResultCheck(int Check, int DrawCheck) {
        if ((PlayBoard[0][0] == Check && PlayBoard[0][1] == Check && PlayBoard[0][2] == Check) || (PlayBoard[1][0] == Check && PlayBoard[1][1] == Check && PlayBoard[1][2] == Check) || (PlayBoard[2][0] == Check && PlayBoard[2][1] == Check && PlayBoard[2][2] == Check)) {
            if (Check == 1) {
                JOptionPane.showMessageDialog(Pan, "1 ИГРОК ЧЕМПИОН");
                k = 1;
            } else if (Check == 2) {
                JOptionPane.showMessageDialog(Pan, "2 ИГРОК ЧЕМПИОН");
                k = 2;
            }
            Pan.AllButtons(false);

        } else if ((PlayBoard[0][0] == Check && PlayBoard[1][0] == Check && PlayBoard[2][0] == Check) || (PlayBoard[0][1] == Check && PlayBoard[1][1] == Check && PlayBoard[2][1] == Check) || (PlayBoard[0][2] == Check && PlayBoard[1][2] == Check && PlayBoard[2][2] == Check)) {
            if (Check == 1) {
                JOptionPane.showMessageDialog(Pan, "1 ИГРОК ЧЕМПИОН");
                k = 1;
            } else if (Check == 2) {
                JOptionPane.showMessageDialog(Pan, "2 ИГРОК ЧЕМПИОН");
                k = 2;
            }
            Pan.AllButtons(false);

        } else if ((PlayBoard[0][0] == Check && PlayBoard[1][1] == Check && PlayBoard[2][2] == Check) || (PlayBoard[2][0] == Check && PlayBoard[1][1] == Check && PlayBoard[0][2] == Check)) {
            if (Check == 1) {
                JOptionPane.showMessageDialog(Pan, "1 ИГРОК ЧЕМПИОН");
                k = 1;

            } else if (Check == 2) {
                JOptionPane.showMessageDialog(Pan, "2 ИГРОК ЧЕМПИОН");
                k = 2;

            }
            Pan.AllButtons(false);

        } else if (DrawCheck == 8) {
            JOptionPane.showMessageDialog(Pan, "НИЧЕЙКА");
            k = 3;
        }
    }
}