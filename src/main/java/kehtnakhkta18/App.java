package kehtnakhkta18;

import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities

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
        long gameSeconds = 0;
        long gameMinutes = 0;
        int x = 1;
        int y = 0;
        String gametime;
        while (gameSeconds < 10) { //siia panna while gameEnd = false või midagi selist

            long elapsedTime = System.nanoTime() - start;

            elapsedTime += 1;
            // TimeUnit
             gameSeconds = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
             gameMinutes = TimeUnit.MINUTES.convert(elapsedTime, TimeUnit.NANOSECONDS);
             if (gameMinutes == x){
                 y++;
                 x++;
            }

            System.out.println(gameMinutes + ":" + (gameSeconds - 60 * y));// labelise panna

        }
        gametime = gameMinutes + ":" + gameSeconds;
        scoreBoard(gametime);
    }

    public static void scoreBoard(String gametime) {

        String username = null; //Ajutine osa, kuni saaks mingid moodi ühendada teiste osadega
        String skoor = null;
        String time = gametime;
        String turns = null;

        try {
            FileReader reader = new FileReader("score.csv");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); //Et näha mis on score.csv failis, ilma et peaks seda lahti teha
            }
            reader.close();

            // Üleval, BufferedReader, all BufferedWriter

            FileOutputStream outputStream = new FileOutputStream("score.csv", true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("------------------------");
            bufferedWriter.newLine();
            if (username != null) {
                bufferedWriter.write("Nimi: " + username);
            } else {
                bufferedWriter.write("Kasutajanimi pole leitud!");
            }
            bufferedWriter.newLine();
            if (turns != null) {
                bufferedWriter.write("Käike: " + turns);
            } else {
                bufferedWriter.write("Miski läks käikude lugemisel valesti!");
            }
            bufferedWriter.newLine();
            if (time != null) {
                bufferedWriter.write("Aeg: " + time);
            } else {
                bufferedWriter.write("Miski läks aja lugemisel valesti!");
            }
            bufferedWriter.newLine();
            if (skoor != null) {
                bufferedWriter.write("Skoor: " + skoor);
            } else {
                bufferedWriter.write("Miski läks skoori lugemisel valesti!");
            }
            bufferedWriter.newLine();
            bufferedWriter.write("------------------------");
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


