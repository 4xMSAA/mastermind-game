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
        //time();
    }

    private static void time() throws InterruptedException {
        long start = System.nanoTime();
        while (true) {

            long end = System.nanoTime();

            long elapsedTime = end - start;


            // TimeUnit
            long gameSeconds = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

            System.out.println(gameSeconds + " seconds");// labelise panna

        }
        //time convert 4
        /*while gameSeconds < 60{
            gameMinutes++;
            gameSeconds =- 60;

        }*/
    }


}


