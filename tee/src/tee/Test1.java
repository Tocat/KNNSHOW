package tee;
import java.awt.*; 
import java.applet.*; 
// import an extra class for the MouseListener 
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;

// Tells the applet you will be using the MouseListener methods.

public class Test1 extends Applet implements MouseListener 
{ 
 // The X-coordinate and Y-coordinate of the last click. 
 int xpos; 
 int ypos;
 
 String[][] res;
 String[] test;
 String[][] res2;
 int de1;
 int de2;
 int x=0;
 int y=0;

 // The coordinates of the rectangle we will draw. 
 // It is easier to specify this here so that we can later 
 // use it to see if the mouse is in that area. 
 int rect1xco,rect1yco,rect1width,rect1height;

 // The variable that will tell whether or not the mouse 
 // is in the applet area. 
 boolean mouseEntered;

 // variable that will be true when the user clicked i the rectangle  
 // the we will draw. 
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
  // Assign values to the rectanagle coordinates. 
  rect1xco = 0; 
  rect1yco = 0; 
  rect1width = 1000; 
  rect1height = 800;

  // Add the MouseListener to your applet 
  addMouseListener(this); 
 }

 

public void paint(Graphics g)  
 { 
  // Rectangle's color 
	float lineWidth = 5.0f;
    ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	g.setColor(Color.white);

  g.fillRect(rect1xco,rect1yco,rect1width,rect1height);

  g.setColor(Color.red);
  
  

  // When the user clicks this will show the coordinates of the click 
  // at the place of the click. 
  //g.drawString("("+(float)xpos/100+","+ypos+")",xpos,ypos);
  
  
  
  
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
	  //g.drawLine ((int)(Double.parseDouble(res[i][0])*100), (int)(Double.parseDouble(res[i][1])*100), (int)(Double.parseDouble(res[i][0])*100), (int)(Double.parseDouble(res[i][1])*100));
	  
  }
  
  lineWidth = 20.0f;
  ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
  
  if(test[4].equals("I.?setosa")){
	  g.setColor(Color.red);
	  //g.drawString("*",(int)(Double.parseDouble(res[i][0])*100), (int)(Double.parseDouble(res[i][1])*100)); 
  }
  else if(test[4].equals("I.?versicolor")){
	  g.setColor(Color.blue);
	  //g.drawString("o",(int)(Double.parseDouble(res[i][0])*100), (int)(Double.parseDouble(res[i][1])*100)); 
}
  else if(test[4].equals("I.?virginica")){
	  g.setColor(Color.black);
	  //g.drawString("+",(int)(Double.parseDouble(res[i][0])*100), (int)(Double.parseDouble(res[i][1])*100)); 
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
	  //g.drawLine ((int)(Double.parseDouble(res[i][0])*100), (int)(Double.parseDouble(res[i][1])*100), (int)(Double.parseDouble(res[i][0])*100), (int)(Double.parseDouble(res[i][1])*100));
	  
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

/* These methods always have to present when you implement MouseListener

 public void mouseClicked (MouseEvent me) {} 
 public void mouseEntered (MouseEvent me) {} 
 public void mousePressed (MouseEvent me) {} 
 public void mouseReleased (MouseEvent me) {}  
 public void mouseExited (MouseEvent me) {}  
*/

 // This method will be called when the mouse has been clicked. 
 public void mouseClicked (MouseEvent me) {

  // Save the coordinates of the click lke this. 
  xpos = me.getX(); 
  ypos = me.getY();

  // Check if the click was inside the rectangle area. 
  if (xpos > rect1xco && xpos < rect1xco+rect1width && ypos >rect1yco &&  
    ypos < rect1yco+rect1height)  rect1Clicked = true; 
  // if it was not then rect1Clicked is false; 
  else  
   rect1Clicked = false; 
  //show the results of the click 
  repaint();

 }

 // This is called when the mous has been pressed 
 public void mousePressed (MouseEvent me) {}

 // When it has been released 
 // not that a click also calls these Mouse-Pressed and Released. 
 // since they are empty nothing hapens here. 
 public void mouseReleased (MouseEvent me) {} 

 // This is executed when the mouse enters the applet. it will only 
 // be executed again when the mouse has left and then re-entered. 
 public void mouseEntered (MouseEvent me) { 
  // Will draw the "inside applet message" 
  mouseEntered = true; 
  repaint(); 
 }

 // When the Mouse leaves the applet. 
 public void mouseExited (MouseEvent me) { 
  // will draw the "outside applet message" 
  mouseEntered = false; 
  repaint(); 
 } 

/* So now you can use the MouseListener instead of Buttons. These methods will be ones that you will 
often use. These methods are good for mouseClicks, but when you need mouseOvers like in Javascript 
then you'll need the MouseMotionListener. 
Go to MouseMotionExample.java 
*/
 public static void run(String[][] res,String[] testres,int de1,int de2,String[][] res2){
	    
	 Test1  applet = new Test1(res,testres,de1,de2,res2);
	    JFrame frame = new JFrame("这是一个applet转化的application");

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

