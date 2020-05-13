/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterminds;

/**
 *
 * @author Sten8
 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

@SuppressWarnings("serial") // suppress warning in Eclipse about serializable class

public class Masterminds extends Applet implements ActionListener {

     public static void main(String[] args) {


    }      
        
        GameCanvas gc; //design
        Random r; //random

    
    
        
    

    public void init() {
    	// initialize variables
        
    	gc = new GameCanvas();
    	r = new Random();
    	gc.code[0] = Math.abs(r.nextInt(8)+1);
    	gc.code[1] = Math.abs(r.nextInt(8)+1);
    	gc.code[2] = Math.abs(r.nextInt(8)+1);
    	gc.code[3] = Math.abs(r.nextInt(8)+1);
    	//chooses 4 random numbers to make the random colors 


    	
    	// main layout
    	setLayout(new BorderLayout());
    	setBackground(Color.gray);
        add("North", makeTitleLabel());  // add at top
        add("South", makeCheckPanel()); // add at bottom
        add("Center", gc);  // add in remaining area (fills space)
        gc.addMouseListener(gc);

    }
    
    public Label makeTitleLabel() {
    	// make mastermind title label 
    	setBackground(Color.blue);
    	Label titleLabel = new Label("MASTERMIND");
    	titleLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 18));
    	titleLabel.setForeground(Color.black);
    	titleLabel.setAlignment(Label.CENTER);
        return titleLabel;
    }

     public Panel makeCheckPanel() {
    	 // make enter
    	 Panel checkPanel = new Panel();
    	 setBackground(Color.lightGray);
    	 checkPanel.add(CButton("Check", Color.black, Color.lightGray));
    	 checkPanel.add(CButton("New Game", Color.black, Color.lightGray));

    	 return checkPanel;
     }

    protected Button CButton(String s, Color fg, Color bg) {
        // create a colored button
        Button b = new Button(s);
        b.setBackground(bg);
        b.setForeground(fg);
        b.addActionListener(this);
        return b;
    }


    public void actionPerformed(ActionEvent e) {
        // handle button clicks
    	if (e.getSource() instanceof Button) {
            String label = ((Button)e.getSource()).getLabel();
            if (label.equals("Check")) {
                check();
            	gc.repaint();

            } 
            if (label.equals("New Game")) {
            	newGame();
            }
    	}
    }
    
    protected void newGame() {
    	gc.init();
    	gc.repaint();
		}    

    
    protected void check() {    	
		if (gc.guess[0] == 0 || gc.guess[1] == 0 || gc.guess[2] == 0 || gc.guess[3] == 0) {
	    	JOptionPane.showMessageDialog(null, "Guess row is not full");
		} else {
    	
    	gc.redPeg = 0;
    	gc.whitePeg = 0;
    	//checks red
    	ArrayList<Integer> checked = new ArrayList<Integer>();
    	for(int k = 0; k <=3; k++) {
    		if (gc.guess[k] == gc.code[k]) {
    			gc.redPeg++;
    		}
    	}
    	
    	for (int c : gc.code) {
    		for (int j = 0; j < 4; j++)
    	        if (c == gc.guess[j] && !checked.contains(gc.guess[j])) {
    	          checked.add(gc.guess[j]);
    	          gc.whitePeg++;
    	        }
            }
    	
    	gc.whitePeg -= gc.redPeg;
    	if (gc.whitePeg < 0) gc.whitePeg = 0;

    	gc.rp = gc.redPeg;
    	
    	while (gc.whitePeg > 0) {
    		gc.pegs[4*gc.guessRow + gc.redPeg + gc.whitePeg - 1] = 2;
    		gc.whitePeg--;
    	}
     	
    	while (gc.redPeg > 0) {
    		gc.pegs[4*gc.guessRow + gc.redPeg - 1] = 1;
    		gc.redPeg--;
    	} 

        gc.guessRow--;
        
    	gc.guess[0] = 0;
    	gc.guess[1] = 0;
    	gc.guess[2] = 0;
    	gc.guess[3] = 0;
    	
    	
        if (gc.guessRow < 0 && gc.rp!= 4) { //no more guesses left
        	JOptionPane.showMessageDialog(null, "You suck boo");
    	}
        
    	
    	if (gc.rp == 4) JOptionPane.showMessageDialog(null, "Congrats u did something right");
	}
	
}  
   }


@SuppressWarnings("serial") // suppress warning in Eclipse about serializable class

class GameCanvas extends Canvas implements MouseListener,  MouseMotionListener {
	//constructor
	public GameCanvas() {
		init();
	}
	
	Color c;
	int h;
	int w;
	int d1;
	int d2;
	int d3;
	int rh;
	int gw;
	int gh;
	int current;
	int[] guess;
	int[] code;
	int redPeg;
    int rp;
	int whitePeg;
	int guessRow;
	int[] c1;
	int[] c2;
	int[] c3;
	int[] c4;
	int[] pegs;

	public void init() {
		c = Color.black;
		w = 250;
		h = 550;
		d1 = 34;
		d2 = 25;
		d3 = 13;
		rh = 40;
		gw = w/5;
		gh = h/11;
		current = 0;
	
	    guess = new int[4];
	    code = new int[4];
		
	    redPeg = 0;
	    rp = 0;
		whitePeg = 0;
		guessRow = 9;
		
		c1 = new int[10];
		c2 = new int[10];
		c3 = new int[10];
		c4 = new int[10];
		
		pegs = new int[40];
	
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.darkGray);
		g.fillRect(0,0,w,h);
		g.setColor(Color.gray);
		g.fillRect(0, h, w, rh);
		
		g.setColor(Color.gray);
		g.fillRect(0,0, 4*w/5, h/11);
		for (int i = 0; i < 4; i ++) {
			int guessx = i*(gw);
			g.setColor(numToColor(code[i]));
			g.fillOval(guessx + (gw-d1)/2, (gh-d1)/2, d1, d1);
		}
		
		if (guessRow >= 0 && rp != 4) {
			for (int i = 0; i < 4; i ++) {
				int guessx = i*(gw);
				g.setColor(Color.lightGray);
				g.fillOval(guessx + (gw-d1)/2, (gh-d1)/2, d1, d1);
			}

		}
		
		for (int j = 9; j >= 0; j--) {
			int guessy = (j+1)*(h/11) ;
			g.setColor(numToColor(c1[j]));
			g.fillOval((gw-d1)/2, guessy + (gh-d1)/2, d1, d1);
			g.setColor(numToColor(c2[j]));
			g.fillOval(gw + (gw-d1)/2, guessy + (gh-d1)/2, d1, d1);
			g.setColor(numToColor(c3[j]));
			g.fillOval(gw*2 + (gw-d1)/2, guessy + (gh-d1)/2, d1, d1);
			g.setColor(numToColor(c4[j]));
			g.fillOval(gw*3 + (gw-d1)/2, guessy + (gh-d1)/2, d1, d1);
			
			
	}
		
		
		//1x8 grid
		for (int k = 0; k < 8; k++) {
			g.setColor(numToColor(k+1));
			int colorw = w/8;
			int colorh = rh;
			int colory = h;
			int colorx = k*(colorw);
			g.fillOval(colorx + (colorw-d2)/2, colory + (colorh-d2)/2, d2, d2);
		}
		
		//2x2 grids for pegs
		int pegw = w/5;
		int pegl = w*4/5;
		int pegh = h/11;
		for (int m = 0; m < 10; m++) {
		  int pegt = (m+1)*(h/11);
		  g.setColor(numToColor(pegs[4*m]));
		  g.fillOval(pegl + (pegw-d3)/5, pegt + (pegh-d3)/5, d3, d3);
		  g.setColor(numToColor(pegs[4*m+1]));
		  g.fillOval(pegl + w/10 + (pegw-d3)/5, pegt + (pegh-d3)/5, d3, d3);
		  g.setColor(numToColor(pegs[4*m+2]));
		  g.fillOval(pegl + (pegw-d3)/5, pegt + h/22 + (pegh-d3)/5, d3, d3);
		  g.setColor(numToColor(pegs[4*m+3]));
		  g.fillOval(pegl + w/10 + (pegw-d3)/5, pegt + h/22 + (pegh-d3)/5, d3, d3);

		}
		
	}
	
	//change num to color
	public Color numToColor(int x) {
		Color color = Color.lightGray;
		if (x == 0) color = Color.gray;
		if (x == 1) color = Color.red;
		if (x == 2) color = Color.white;
		if (x == 3) color = Color.green;
		if (x == 4) color = Color.pink;
		if (x == 5) color = Color.yellow;
		if (x == 6) color = new Color(160, 0, 100);
		if (x == 7) color = Color.black;
		if (x == 8) color = Color.blue;
		return color;
	}
	
	
	   // draws color circle where mouse is pressed
    public void mousePressed(MouseEvent event) {

        Point p = event.getPoint();
        int x = p.x;
        int y = p.y;
    	
        if (y > 550 && y <= 590) {
        	if(x < w/8) {
        		current = 1;
        	}
        	if (x >= w/8 && x < w/4) {
        		current = 2;
        	}
        	if (x >= w/4 && x < 3*w/8) {
        		current = 3;
        	}
        	if (x >= 3*w/8 && x < w/2) {
        		current = 4;
        	}
        	if (x >= w/2 && x < 5*w/8) {
        		current = 5;
        	}
        	if (x >= 5*w/8 && x < 3*w/4) {
        		current = 6;
        	}
        	if (x >= 3*w/4 && x < 7*w/8) {
        		current = 7;
        	}
        	if (x >= 7*w/8 && x < w) {
        		current = 8;
        	}
        }
        if (y > ((guessRow + 1)*(gh)+((gh-d1)/2)) && y < ((guessRow + 2)*gh)-((gh-d1)/2)) {
	        if (x >= ((gw-d1)/2) && x <= (w/5)-((gh-d1)/2))  {
	        	guess[0] = current;
				c1[guessRow] = current;
				repaint();
	        }
	        if (x >= ((w/5) + (gw-d1)/2) && x <= 2*(w/5)-((gh-d1)/2))  {
	        	guess[1] = current;
	        	c2[guessRow] = current;
				repaint();
	        }
	        if (x >= (2*(w/5) + (gw-d1)/2) && x <= 3*(w/5)-((gh-d1)/2))  {
	        	guess[2] = current;
	        	c3[guessRow] = current;
				repaint();
	        }
	        if (x >= (3*(w/5) + (gw-d1)/2) && x <= 4*(w/5)-((gh-d1)/2))  {
	        	guess[3] = current;
	        	c4[guessRow] = current;
				repaint();
	        }
	        
        }
        
    }
        public void mouseMoved(MouseEvent event) { }
	public void mouseDragged(MouseEvent event) { }
	public void mouseClicked(MouseEvent event) { }
	public void mouseEntered(MouseEvent event) { }
	public void mouseExited(MouseEvent event) { }
	public void mouseReleased(MouseEvent event) { }
}
 
   
    

