package tee;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;  
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Point;  
import java.awt.Toolkit;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
import java.io.File;  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;  
import javax.swing.JFileChooser;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;  
import javax.swing.JTextField;  

import java.awt.Graphics;


class Test3 extends JPanel {

	private int x;
	private int y;
	  public void paint(Graphics g) {
		  float lineWidth = 10.0f;
	      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
		  g.drawLine (x, y, 300, 400);
	    g.setColor(Color.red);
	    
	    g.drawLine (200, 200, 200, 200);
	  }
	  
	public int gety() {
		return y;
	}
	public void sety(int y) {
		this.y = y;
	}
	public int getx() {
		return x;
	}
	public void setx(int x) {
		this.x = x;
	}
	Test3(int x,int y){
		this.x=x;
		this.y=y;
	}
}

public class Show implements ActionListener {  
    JFrame frame = new JFrame("KNN-show");
    JTabbedPane tabPane = new JTabbedPane();
    Container con = new Container();
    JLabel label1 = new JLabel("trainfile");  
    JLabel label2 = new JLabel("testfile"); 
    JLabel label5 = new JLabel("outputdir"); 
    JLabel label3 = new JLabel("dimension");
    
    JLabel label4 = new JLabel("coordinate");
    JLabel label41 = new JLabel("1");
    JTextField text41 = new JTextField();
    JLabel label42 = new JLabel("2");
    JTextField text42 = new JTextField();
    JLabel label43 = new JLabel("3");
    JTextField text43 = new JTextField();
    JLabel label44 = new JLabel("4");
    JTextField text44 = new JTextField();
    
    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JTextField text5 = new JTextField(); 
    JButton button1 = new JButton("choose training file");
    JButton button2 = new JButton("choose testing file");
    JButton button5 = new JButton("choose output file");
    JFileChooser jfc = new JFileChooser();  
    JButton button3 = new JButton("start");
    
    JRadioButton rdbtnNewRadioButton1 = new JRadioButton("1");
    JRadioButton rdbtnNewRadioButton2 = new JRadioButton("2");
    JRadioButton rdbtnNewRadioButton3 = new JRadioButton("3");
    JRadioButton rdbtnNewRadioButton4 = new JRadioButton("4");
    
    private JFrame frmTesttitle2;
    
    String trainDatares[][];
      
    Show() {  
        jfc.setCurrentDirectory(new File("d://")); 
          
        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();  
          
        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();  
          
        frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));  
        frame.setSize(500, 240);  
        frame.setContentPane(tabPane);  
        
        label1.setBounds(10, 10, 70, 20);  
        text1.setBounds(75, 10, 180, 20);  
        button1.setBounds(280, 10, 180, 20);  
        
        label2.setBounds(10, 35, 70, 20);  
        text2.setBounds(75, 35, 180, 20);  
        button2.setBounds(280, 35, 180, 20); 
        
        label5.setBounds(10, 60, 70, 20);  
        text5.setBounds(75, 60, 180, 20);  
        button5.setBounds(280, 60, 180, 20); 
        
        label3.setBounds(10, 85, 70, 20);
        rdbtnNewRadioButton1.setBounds(70, 85, 40, 20);
        rdbtnNewRadioButton2.setBounds(110, 85, 40, 20);
        rdbtnNewRadioButton3.setBounds(150, 85, 40, 20);
        rdbtnNewRadioButton4.setBounds(190, 85, 40, 20);
        
        label4.setBounds(10, 110, 70, 20);
        label41.setBounds(80, 110, 15, 20);
        text41.setBounds(95, 110, 50, 20);
        label42.setBounds(150, 110, 15, 20);
        text42.setBounds(165, 110, 50, 20);
        label43.setBounds(220, 110, 15, 20);
        text43.setBounds(235, 110, 50, 20);
        label44.setBounds(290, 110, 15, 20);
        text44.setBounds(305, 110, 50, 20);
        
        button3.setBounds(150, 135, 180, 20);  
        button1.addActionListener(this);  
        button2.addActionListener(this);  
        button3.addActionListener(this);  
        button5.addActionListener(this);  
        con.add(label1);  
        con.add(text1);  
        con.add(button1);  
        con.add(label2);  
        con.add(text2);  
        con.add(button2); 
        con.add(label3);
        con.add(label5);  
        con.add(text5);  
        con.add(button5); 
        con.add(rdbtnNewRadioButton1);
        con.add(rdbtnNewRadioButton2);
        con.add(rdbtnNewRadioButton3);
        con.add(rdbtnNewRadioButton4);
        con.add(label4);
        con.add(label41);
        con.add(label42);
        con.add(label43);
        con.add(label44);
        con.add(text41);
        con.add(text42);
        con.add(text43);
        con.add(text44);
        con.add(button3);  
        frame.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        tabPane.add("choose files", con);
        
        
        
    }  
      
    public void actionPerformed(ActionEvent e) {  
        // TODO Auto-generated method stub  
        if (e.getSource().equals(button1)) {  
            jfc.setFileSelectionMode(0);  
            int state = jfc.showOpenDialog(null);  
            if (state == 1) {  
                return;  
            } else {  
                File f = jfc.getSelectedFile();  
                text1.setText(f.getAbsolutePath());  
            }  
        }  
        
        if (e.getSource().equals(button2)) {  
            jfc.setFileSelectionMode(0); 
            int state = jfc.showOpenDialog(null);  
            if (state == 1) {  
                return;
            } else {  
                File f = jfc.getSelectedFile();  
                text2.setText(f.getAbsolutePath());  
            }  
        }
        if (e.getSource().equals(button5)) {  
            jfc.setFileSelectionMode(1);
            int state = jfc.showOpenDialog(null);  
            if (state == 1) {  
                return;
            } else {  
                File f = jfc.getSelectedFile();  
                text5.setText(f.getAbsolutePath());  
            }  
        }
        if (e.getSource().equals(button3)) {  
            
        	int de1=-1;
        	int de2=-1;
        	if(rdbtnNewRadioButton1.isSelected())
        		de1=0;
        	if(rdbtnNewRadioButton2.isSelected()){
        		if(de1!=-1)
        			de2=1;
        		else
        			de1=1;
        	}
        	if(rdbtnNewRadioButton3.isSelected()){
        		if(de1!=-1)
        			de2=2;
        		else
        			de1=2;
        	}
        	if(rdbtnNewRadioButton4.isSelected()){
        		if(de1!=-1)
        			de2=3;
        		else
        			de1=3;
        	}
        	
        	
        	
        	String[] test2={text41.getText(),text42.getText(),text43.getText(),text44.getText()};
            trainDatares=KNN.run(text1.getText(), text2.getText());
            String[] testres=KNN2.run(text1.getText(), test2);
            String[][] trainres=KNN3.run(text1.getText(), test2);
            String[][] res=new String[10][trainres[0].length];
            HashMap<Double, Integer> m = new HashMap<Double, Integer>();
            
            for(int i=0;i<trainres.length;i++){
            	
            	m.put(Double.parseDouble(trainres[i][5]),i);
            }
            List<Map.Entry<Double, Integer>> infoIds = new ArrayList<Map.Entry<Double, Integer>>(m.entrySet());


            Collections.sort(infoIds, new Comparator<Map.Entry<Double, Integer>>() {

                public int compare(Map.Entry<Double, Integer> o1,
                                   Map.Entry<Double, Integer> o2) {

                    if(o1.getKey() > o2.getKey()){
                        return 1;
                    }else{
                        return -1;
                    }

                    
                    
                }
            });
            
            for (int i = 0; i < infoIds.size()&&i<10; i++) {
                 System.out.println(infoIds.get(i).toString());
                 res[i]=trainres[Integer.parseInt(infoIds.get(i).toString().split("=")[1])];
                 System.out.println(res[i][5]);
            }
            
            
            

            
            Test1.run(trainDatares,testres,de1,de2,res);
        	
        }  
    } 
    
    
    
    
    
    public static void main(String[] args) {  
        new Show();  
    } 
    
}
