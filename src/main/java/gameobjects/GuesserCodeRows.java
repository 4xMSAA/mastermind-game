package gameobjects;

public class GuesserCodeRows {
    public CodeCombination[] Rows;

    public GuesserCodeRows(int rows, int columns) {
        Rows = new CodeCombination[rows - 1];


    }

    /**

     */
    public void PlaceToken(int rowIndex, int column, int tokenCode) {
        Rows[rowIndex].SetToken(column, tokenCode);
    }

    public CodeCombination GetRow(int index) {
        return Rows[index];
    }

}
