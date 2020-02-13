package gameobjects;

public class CodeCombination {

    public int Tokens[];

    /**
     * Uus koodikombinatsioon mis mahutab veergude arv sümboleid
     * @param columns Mitu veergu mahutada
     */
    public CodeCombination(int columns) {
        Tokens = new int[columns - 1];
    }

    /**
     *
     * @param slot
     * @param tokenCode
     */
    public void setToken(int slot, int tokenCode) {
        if (slot >= Tokens.length) { throw new IllegalArgumentException("Token slot location cannot exceed reserved column count"); }
        Tokens[slot] = tokenCode;
    }


}
