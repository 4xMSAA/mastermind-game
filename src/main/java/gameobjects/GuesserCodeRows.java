package gameobjects;

public class GuesserCodeRows {
    public CodeCombination[] Rows;

    public GuesserCodeRows(int rows, int columns) {
        Rows = new CodeCombination[rows - 1];


    }

    /**
     *
     * @param rowIndex
     * @param column
     * @param tokenCode
     */
    public void placeToken(int rowIndex, int column, int tokenCode) {
        Rows[rowIndex].setToken(column, tokenCode);
    }

    /**
     *
     * @param index
     * @return
     */
    public CodeCombination getRow(int index) {
        return Rows[index];
    }

    /**
     *
     * @return
     */
    public boolean hasWinningRow() {
        return false;
    }

    /**
     *
     * @return
     */
    public CodeCombination getWinningRow() {
        return null;
    }

}
