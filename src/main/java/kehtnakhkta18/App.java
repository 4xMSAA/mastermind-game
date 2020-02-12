package kehtnakhkta18;

import java.util.TimerTask;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 *
 *
 */
public final class App {
    public static String gametime = "0:00";
    //static GamePanel gamePanel = new GamePanel();

    private App() {
        //SwingUtilities.invokeLater(() -> gamePanel.initialize());
        GamePanel GamePanel = new GamePanel();
        Controller controller = new Controller(GamePanel);

        GamePanel.pack();
        GamePanel.setLocationRelativeTo(null); // Paiguta Frame ekraani keskele
        GamePanel.setVisible(true);




    }



    /**
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
       // GamePanel gamePanel = new GamePanel();
        new App();

    }

    /**
     *
     * @throws InterruptedException
     */
    static class time extends TimerTask{

        int gs = 0;
        int gm = 0;
        String gt;

            public void run() {
                gs++;
                if (gs == 60){
                    gm += 1;
                    gs -=60;
                }
                if (gs < 10){
                    gt = (gm + ":0" + gs);
                }else {
                    gt = (gm + ":" + gs);
                }


                GamePanel.lblTimer.setText("Mängu aeg: " + gt);
            }

    }

    public static void scoreBoard(String gt) {

        String username = null; //Ajutine osa, kuni saaks mingid moodi ühendada teiste osadega
        String skoor = null;
        String time = gt;
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


