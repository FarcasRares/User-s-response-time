//Farcas Rares

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

//JFrame class
class myFrame extends JFrame{
	myCanvas c;
	JFrame f;
	long timpinitial;
	long timpfinal;
	int corect=0;
	int count=0;
        JLabel answers;
	JLabel time;
	myFrame(String title){
		
		JButton start=new JButton("START");
		f=new JFrame(title);
		c=new myCanvas();
		c.setBounds(20,20,240,240);
		c.setSize(200,200);
		c.setVisible(false);
		f.add(c);
        f.setLayout(null);		
		
		
		JButton butonR=new JButton("");
		butonR.setBackground(new Color(255,0,0));
		butonR.setBounds(295,80,100,50);
		butonR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count <10) {
				Color raux=new Color(255,0,0);
			    if (raux.getRGB() == c.select.getRGB()) {corect++;}
			    count++;
			    if (count==10) {
			    	timpfinal=System.currentTimeMillis();
					answers=new JLabel("Corect answers : "+ corect);
					answers.setBounds(30,50,400,50);
					time=new JLabel("Time : "+(timpfinal-timpinitial)/1000+"."+(timpfinal-timpinitial)%1000+" Seconds");
					time.setBounds(30,90,400,50);
					c.setVisible(false);
					f.add(time);
					f.add(answers);
				}
			    System.out.print(count+ " ");
				c.repaint();
				}
				
			}
		});
		f.add(butonR);
		
		JButton butonB=new JButton("");
		butonB.setBackground(new Color(0,0,0));
		butonB.setBounds(295,140,100,50);
		butonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count <10) {
				Color baux=new Color(0,0,0);
				if (baux.getRGB() == c.select.getRGB()) {corect++;}
				c.repaint();
				count++;
				 if (count==10) {
						timpfinal=System.currentTimeMillis();
						answers=new JLabel("Corect answers : "+ corect);
						answers.setBounds(30,50,400,50);
						time=new JLabel("Time : "+(timpfinal-timpinitial)/1000+"."+(timpfinal-timpinitial)%1000+" Seconds");
						time.setBounds(30,90,400,50);
						c.setVisible(false);
						f.add(time);
						f.add(answers);
					}
				 System.out.print(count+ " ");
				}
				
			}
		});
		f.add(butonB);
		butonB.setVisible(false);
		butonR.setVisible(false);
		
		JButton restart=new JButton("RESTART");
		restart.setFont(new Font("Arial",Font.PLAIN, 14));
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 c.setVisible(false);
			 butonR.setVisible(false);
			butonB.setVisible(false);
			start.setVisible(true);
		    restart.setVisible(false);
                    answers.setVisible(false);
		    time.setVisible(false);
		    count=0;
		    corect=0;
			}
			
		});
		
		restart.setBounds(295,20,100,50);
		restart.setVisible(false);
		f.add(restart);
		
		
		start.setFont(new Font("Arial",Font.PLAIN, 32));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timpinitial=System.currentTimeMillis();
				c.setVisible(true);
				butonR.setVisible(true);
				butonB.setVisible(true);
				start.setVisible(false);
				restart.setVisible(true);
			}
		});
		start.setBounds(180,80,150,100);
		f.add(start);
		
		
		
		f.setBounds(100,100,500,300);
		f.setSize(500,300);
		f.setVisible(true);
	}
	
}

// Canvas class
class myCanvas extends Canvas{
	Color r=new Color(255,0,0);
	Color b=new Color(0,0,0);
	public Color select;
	public void paint(Graphics g)
	{
		Random rand=new Random();
		int aux;
		aux=rand.nextInt(2-0)+0;
		if (aux==0) select=b;
		else select=r;
		g.setColor(select);
		g.fillRect(0, 0, 190, 190);
	}
	
}




// Main class
public class main{
	public static void main(String[] args) {
		myFrame aplication=new myFrame("User's response time");
	}
}
