package kehtnakhkta18;

import javax.swing.*;
import java.awt.*;

/*public class GamePanel {

    public void initialize() {
        JFrame frame = new JFrame("Mastermind Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        frame.setVisible(true);
    }
}*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Laptop
 */
public class GamePanel extends JFrame {

    /**
     * Paneelid Framele
     */
    private final JPanel panelMain;
    private final JPanel panelTop;
    private final JPanel panelBoard;
    /**
     * Paneelil olevad nupud
     */
    private final JButton btnNewGame = new JButton("Uus mäng");
    private final JButton btnScoreboard = new JButton("Edetabel");
    private final JButton btnHelp = new JButton("Õpetus");
    private final JButton btnReady = new JButton("Valmis"); // Siia tuleb pilt peale ;
    private final JButton btnShow = new JButton("Näita");
    private final JCheckBox chkExpert = new JCheckBox("Ekspert");
    public static JLabel lblTimer = new JLabel("0,0");

    /**
     * View konstruktor
     */
    public GamePanel() {
        setupFrame();   // Seadista Frame
        panelMain = new JPanel();   // Tee uus põhipaneel, kuhu tulevad kaks järgnevat peale
        panelTop = new JPanel(new GridBagLayout()); // Tee uus nuppude paneel
        panelBoard = new JPanel();  // Tee uus mänguvälja paneel
        setupPanelTop(); // Seadista nuppude paneel
        setupPanelBoard();  // Seadista mänguvälja paneel
    }

    private void setupFrame() {
        setTitle("MasterMind");    // Frame title text
        setPreferredSize(new Dimension(350, 610)); // Vaikimisi suurus Framel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Muidu jääb rakendus tööle, kui seda pole
    }

    private void setupPanelTop() {
        panelTop.setPreferredSize(new Dimension(350, 100));  // Paneeli suurus
        panelTop.setBackground(new Color(210, 180, 140));      // Paneeli taustavärv (sama mis MainPanel)
        /**
         * Paneme paneelile äärejoone ümber koos pealkirjaga
         */
        TitledBorder border = new TitledBorder("Nupud");
        border.setTitleFont(border.getTitleFont().deriveFont(Font.BOLD, 14)); //Rasvane, 14px
        panelTop.setBorder(border);
        addButtons(); // Nupud, Label ja Checkbox panelTopile

        panelMain.add(panelTop);    // panelMainile paneme panelTop
        panelMain.add(panelBoard);  // panelMainile paneme panelBoard just selles järjekorras

        add(panelMain);// Frame peale lisa panelMain oma kahe paneliga!

    }

    private void setupPanelBoard() {
        /**
         * Paneme paneelile äärejoone ümber koos pealkirjaga
         */
        TitledBorder border = new TitledBorder("Mänguväli");
        border.setTitleFont(border.getTitleFont().deriveFont(Font.BOLD, 14));
        panelBoard.setBorder(border);
        panelBoard.setBackground(new Color(210, 180, 140)); // Tasutavärv
        panelBoard.setPreferredSize(new Dimension(350, 500)); // Paneeli suurus

    }
    /**
     * Lisame nupud panelTopile kindlal positsioonil. Kasutatakse GridBagLayout 'i
     */
    private void addButtons() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // btnNewGame
        c.gridx = 0; // Veerg
        c.gridy = 0; // Rida
        panelTop.add(btnNewGame, c);
        // btnScoreboard
        c.gridx = 1; // Veerg
        c.gridy = 0; // Rida
        panelTop.add(btnScoreboard, c);
        // btnHelp
        c.gridx = 2; // Veerg
        c.gridy = 0; // Rida
        panelTop.add(btnHelp, c);
        // btnShow
        c.gridx = 0; // Veerg
        c.gridy = 1; // Rida
        panelTop.add(btnShow, c);
        // btnReady
        c.gridx = 2;
        c.gridy = 1;
        panelTop.add(chkExpert, c);
        // lblTimer
        c.gridx = 0; // Veerg
        c.gridy = 2; // Rida
        c.gridwidth = 2; // Kolm veergu
        c.fill = GridBagConstraints.CENTER; // Label üle kolme lahtri keskel
        panelTop.add(lblTimer, c);
        // btnReady
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        panelTop.add(btnReady, c);
    }
    // Siin on kõikide nuppude (JButton) meetodid
    public void btnNewGameListener(ActionListener al) {
        btnNewGame.addActionListener(al);
    }
    public void btnScoreboardListener(ActionListener al) {
        btnScoreboard.addActionListener(al);
    }
    public void btnHelpListener(ActionListener al) {
        btnHelp.addActionListener(al);
    }
    public void btnShowListener(ActionListener al) {
        btnShow.addActionListener(al);
    }
    public void btnReadyListener(ActionListener al) {
        btnReady.addActionListener(al);
    }
    // Checkbox meetod
    public void chkExpertListener(ItemListener il) {
        chkExpert.addItemListener(il);
    }
    // panelBoardile hiirekliki meetod
    public void panelBoardMouseListener(MouseListener ml) {
        panelBoard.addMouseListener(ml);
    }


}
