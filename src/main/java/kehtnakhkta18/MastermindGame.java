package kehtnakhkta18;

import gameobjects.*;


public class MastermindGame {
    /**
     * Klass kahe koordinaadi hoidmiseks
     */
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

    public GuesserCodeRows GuessingCodes;

    /**
     * Alusta uus Mõttemeistri mäng 4 veeruga, 14 reaga ning 8 sümbolivõimalustega
     */
    public MastermindGame() {
        this(4, 14, 8);
    }

    /**
     *
     * @param columns
     * @param rows
     * @param symbols
     */
    public MastermindGame(int columns, int rows, int sybmols) {
        if (sybmols < columns) { throw new IllegalArgumentException("Possible symbols must be equal or more than amount of columns")}
        BoardSize = new Size(columns, rows);
        CodeGoal = new CodeCombination(columns);

    }
}
