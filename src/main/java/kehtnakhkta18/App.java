package kehtnakhkta18;

import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;


/**
 *
 *
 */
public final class App {

    static GamePanel gamePanel = new GamePanel();

    private App() {
        SwingUtilities.invokeLater(() -> gamePanel.initialize());
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

            elapsedTime += 1;
            // TimeUnit
            long gameTime = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

            System.out.println(gameTime + " seconds");
            Thread.sleep(1000);
        }
    }

}
