package kehtnakhkta18;


import java.util.concurrent.TimeUnit;


/**
 *
 *
 */
public final class App {

    static GamePanel gamePanel = new GamePanel();

    private App() {
        gamePanel.initialize();
    }


    /**
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        new App();
    }

    /**
     * 
     * @throws InterruptedException
     */
    private static void time() throws InterruptedException {
        long start = System.nanoTime();
        while (true) {

            long elapsedTime = System.nanoTime() - start;


            // TimeUnit
            long gameTime = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

            System.out.println(gameTime + " seconds");
            Thread.sleep(1000);
        }
    }

}


