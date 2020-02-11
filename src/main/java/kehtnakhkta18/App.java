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
        time();
    }


    private static void time() {
        long start = System.nanoTime();
        long gameSeconds = 0;
        long gameMinutes = 0;
        while (true) { //siia panna while gameEnd = false või midagi selist

            long end = System.nanoTime();

            long elapsedTime = end - start;


            // TimeUnit
             gameSeconds = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
             gameMinutes = TimeUnit.MINUTES.convert(elapsedTime, TimeUnit.NANOSECONDS);
             if (gameMinutes == 1){
                 gameSeconds -= 60;
            }

            System.out.println(gameMinutes + ":" + gameSeconds);// labelise panna

        }
    }


}


