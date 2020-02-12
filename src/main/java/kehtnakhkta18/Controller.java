package kehtnakhkta18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import javax.swing.*;

/**
 *
 * @author Laptop
 */
public class Controller {

    private final GamePanel GamePanel;
   // private final Model model;
   public static Timer timer;
   public static boolean gameon = false;
    /**
     * Controlleri konstruktor koos View ja Model parameeriga
     * @param GamePanel
     *
     */
    public Controller(GamePanel GamePanel) {
        this.GamePanel = GamePanel;
        //this.model = model;
        /**
         * Nupud, CheckBox ja Mänguvälja klikid
         */
        this.GamePanel.btnNewGameListener(new NewGameActionListener());
        this.GamePanel.btnScoreboardListener(new ScoreboardActionListener());
        this.GamePanel.btnHelpListener(new HelpActionListener());
        this.GamePanel.btnShowListener(new ShowActionListener());
        this.GamePanel.btnReadyListener(new ReadyActionListener());
        this.GamePanel.panelBoardMouseListener(new PanelBoardActionListener());
        this.GamePanel.chkExpertListener(new ChkExpertItemListener());
    }

    // Mis toimub peale nuppudele vajutamist, tehakse siin.
    public class NewGameActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Uue mängu alustamise nupp");
            if (gameon == false){
                timer = new Timer();
                timer.schedule(new App.time(), 0, 1000);
                gameon = true;
            }else {
                timer.cancel();
                timer = new Timer();
                timer.schedule(new App.time(), 0, 1000);
            }


        }
    }

    public class ScoreboardActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Siia peaks edetabeli aken tulema");

        }
    }

    public class HelpActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "See peaks näitama mängu õpetuse pilti");
        }
    }

    public class ShowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "See näitab arvuti mõeldud kombinatsiooni");
        }
    }

    public class ReadyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Kui sinu värvikood on paigas, siis vajuta seda nuppu");
        }
    }

    public class ChkExpertItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            SwingUtilities.invokeLater(() -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JOptionPane.showMessageDialog(null, "CheckBox valitud. Ekspert versioon.");
                } else {
                    JOptionPane.showMessageDialog(null, "CheckBox pole valitud. Tavaline versioon.");
                }
            });
        }
    }

    /**
     * Hiire klikid panelBoard peal
     */
    public class PanelBoardActionListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JOptionPane.showMessageDialog(null, "Klikkisid kusagil mänguväljal");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
