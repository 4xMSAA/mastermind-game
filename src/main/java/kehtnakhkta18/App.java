package kehtnakhkta18;


import java.sql.Time;
import java.util.concurrent.TimeUnit;


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
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        MMGame.initializeForm();
    }

    private static void time() throws InterruptedException {
        long start = System.nanoTime();
        while (true) {

            long end = System.nanoTime();

            long elapsedTime = end - start;


            // TimeUnit
            long gameTime = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

            System.out.println(gameTime + " seconds");
            Thread.sleep(1000);
        }
    }

}


