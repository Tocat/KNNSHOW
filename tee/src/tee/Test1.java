package tee;
import java.awt.*; 
import java.applet.*; 
// import an extra class for the MouseListener 
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;



public class Test1 extends Applet implements MouseListener 
{ 
 
 int xpos; 
 int ypos;
 
 String[][] res;
 String[] test;
 String[][] res2;
 int de1;
 int de2;
 int x=0;
 int y=0;


 int rect1xco,rect1yco,rect1width,rect1height;


 boolean mouseEntered;


 boolean rect1Clicked;

 Test1(String[][] res,String[] testres,int de1,int de2,String[][] res2){
	 this.res=res;
	 this.test=testres;
	 this.de1=de1;
	 this.de2=de2;
	 this.res2=res2;
 }
 
 public void init()  
 { 
  
  rect1xco = 0; 
  rect1yco = 0; 
  rect1width = 1000; 
  rect1height = 800;

   
  addMouseListener(this); 
 }

 

public void paint(Graphics g)  
 { 
   
	float lineWidth = 5.0f;
    ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	g.setColor(Color.white);

  g.fillRect(rect1xco,rect1yco,rect1width,rect1height);

  g.setColor(Color.red);
  
  

  
  for(int i=0;i<res.length;i++){
	  if(res[i][4].equals("I.?setosa")){
		  g.setColor(Color.red);
		  g.drawString("x",(int)(Double.parseDouble(res[i][de1])*80)-3, 600-(int)(Double.parseDouble(res[i][de2])*80)+4); 
	  }
	  else if(res[i][4].equals("I.?versicolor")){
		  g.setColor(Color.blue);
		  g.drawString("o",(int)(Double.parseDouble(res[i][de1])*80)-3, 600-(int)(Double.parseDouble(res[i][de2])*80)+4); 
	}
	  else if(res[i][4].equals("I.?virginica")){
		  g.setColor(Color.black);
		  g.drawString("+",(int)(Double.parseDouble(res[i][de1])*80)-3, 600-(int)(Double.parseDouble(res[i][de2])*80)+4); 
	  }
	  
  }
  
  lineWidth = 20.0f;
  ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
  
  if(test[4].equals("I.?setosa")){
	  g.setColor(Color.red);
	   
  }
  else if(test[4].equals("I.?versicolor")){
	  g.setColor(Color.blue);
	  
}
  else if(test[4].equals("I.?virginica")){
	  g.setColor(Color.black);
	  
  }
  g.drawString("T",(int)(Double.parseDouble(test[de1])*80)-2, 600-(int)(Double.parseDouble(test[de2])*80)+5); 
  
  lineWidth = 1.0f;
  ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
  
  for(int i=0;i<res2.length;i++){
	  if(res2[i][4].equals("I.?setosa")){
		  g.setColor(Color.red);
		  g.drawLine((int)(Double.parseDouble(res2[i][de1])*80), 600-(int)(Double.parseDouble(res2[i][de2])*80),(int)(Double.parseDouble(test[de1])*80), 600-(int)(Double.parseDouble(test[de2])*80)); 
	  }
	  else if(res2[i][4].equals("I.?versicolor")){
		  g.setColor(Color.blue);
		  g.drawLine((int)(Double.parseDouble(res2[i][de1])*80), 600-(int)(Double.parseDouble(res2[i][de2])*80),(int)(Double.parseDouble(test[de1])*80), 600-(int)(Double.parseDouble(test[de2])*80)); 
	}
	  else if(res2[i][4].equals("I.?virginica")){
		  g.setColor(Color.black);
		  g.drawLine((int)(Double.parseDouble(res2[i][de1])*80), 600-(int)(Double.parseDouble(res2[i][de2])*80),(int)(Double.parseDouble(test[de1])*80), 600-(int)(Double.parseDouble(test[de2])*80)); 
	  }
	  System.out.println(res2[i][0]+"@"+res2[i][2]);
	  
  }
  
  
  
  for(int i=0;i<this.res.length;i++){
	  if(Math.abs((double)xpos-Double.parseDouble(res[i][de1])*80)<5
			  &&Math.abs((double)ypos+Double.parseDouble(res[i][de2])*80-600)<5){
		  g.drawString("("+res[i][0]+","+res[i][1]+","+res[i][2]+","+res[i][3]+")",xpos,ypos);
		  break;
	  }
  }
  if(Math.abs((double)xpos-Double.parseDouble(this.test[de1])*80)<5
		  &&Math.abs((double)ypos+Double.parseDouble(this.test[de2])*80-600)<5){
	  g.drawString("("+test[0]+","+test[1]+","+test[2]+","+test[3]+")",xpos,ypos);
	  
  }
  
  
  
 
 }


 public void mouseClicked (MouseEvent me) {

  
  xpos = me.getX(); 
  ypos = me.getY();

  
  if (xpos > rect1xco && xpos < rect1xco+rect1width && ypos >rect1yco &&  
    ypos < rect1yco+rect1height)  rect1Clicked = true; 
  
  else  
   rect1Clicked = false; 
   
  repaint();

 }

 
 public void mousePressed (MouseEvent me) {}


 public void mouseReleased (MouseEvent me) {} 


 public void mouseEntered (MouseEvent me) { 
 
  mouseEntered = true; 
  repaint(); 
 }


 public void mouseExited (MouseEvent me) { 
  
  mouseEntered = false; 
  repaint(); 
 } 


 public static void run(String[][] res,String[] testres,int de1,int de2,String[][] res2){
	    
	 Test1  applet = new Test1(res,testres,de1,de2,res2);
	    JFrame frame = new JFrame("Picture");

	    frame.addWindowListener(new WindowAdapter()
	    {
	        public void windowClosing(WindowEvent e)
	        {
	        System.exit(0);
	        }
	    });

	    frame.getContentPane().add(applet);
	    frame.setSize(1000,800);
	    frame.setVisible(true);

	    applet.init();
	    applet.start();
	    
	} 

} 

