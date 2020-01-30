package kehtnakhkta18;



/**
 *
 *
 */
public final class App {

    static MastermindGame MMGame = new MastermindGame();
    private App() {

    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        MMGame.initializeForm();
    }
}
