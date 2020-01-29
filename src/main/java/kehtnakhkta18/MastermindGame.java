package kehtnakhkta18;

import gameobjects.CodeCombination;

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
}