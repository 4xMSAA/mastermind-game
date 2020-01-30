package kehtnakhkta18;

import gameobjects.CodeCombination;

import javax.swing.*;
import java.awt.*;

public class MastermindGame {

    public class Size {
        public int X;
        public int Y;
        public Size(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }

        public int getX() {
            return X;
        }

        public int getY() {
            return Y;
        }
    }

    public Size BoardSize;
    public CodeCombination CodeGoal;

    public void initializeForm() {
        JFrame frame = new JFrame("Mastermind Game");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
}
