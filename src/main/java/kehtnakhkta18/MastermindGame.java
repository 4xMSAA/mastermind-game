package kehtnakhkta18;

import java.util.ArrayList;

import gameobjects.*;


public class MastermindGame {
    /**
     * Klass kahe koordinaadi hoidmiseks
     */
    public class Size {
        public int X;
        public int Y;



        public Size(final int X, final int Y) {
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

    private final ArrayList<Move> Moves;

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
    public MastermindGame(final int columns, final int rows, final int symbols) {
        if (symbols < columns) { throw new IllegalArgumentException("Possible symbols must be equal or more than amount of columns"); }

        BoardSize = new Size(columns, rows);
        CodeGoal = new CodeCombination(columns);
        Moves = new ArrayList<Move>();



    }

}
