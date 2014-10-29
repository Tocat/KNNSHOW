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
    JFrame frame = new JFrame("KNN-show");// 框架布局  
    JTabbedPane tabPane = new JTabbedPane();// 选项卡布局  
    Container con = new Container();//  
    JLabel label1 = new JLabel("文件目录");  
    JLabel label2 = new JLabel("选择文件"); 
    JLabel label5 = new JLabel("输出目录"); 
    JLabel label3 = new JLabel("选择维度");
    
    JLabel label4 = new JLabel("坐标");
    JLabel label41 = new JLabel("1");
    JTextField text41 = new JTextField();
    JLabel label42 = new JLabel("2");
    JTextField text42 = new JTextField();
    JLabel label43 = new JLabel("3");
    JTextField text43 = new JTextField();
    JLabel label44 = new JLabel("4");
    JTextField text44 = new JTextField();
    
    JTextField text1 = new JTextField();// TextField 目录的路径  
    JTextField text2 = new JTextField();// 文件的路径 
    JTextField text5 = new JTextField();// 文件的路径 
    JButton button1 = new JButton("choose training file");// 选择  
    JButton button2 = new JButton("choose testing file");// 选择 
    JButton button5 = new JButton("choose output file");// 选择 
    JFileChooser jfc = new JFileChooser();// 文件选择器  
    JButton button3 = new JButton("start");//
    
    JRadioButton rdbtnNewRadioButton1 = new JRadioButton("1");
    JRadioButton rdbtnNewRadioButton2 = new JRadioButton("2");
    JRadioButton rdbtnNewRadioButton3 = new JRadioButton("3");
    JRadioButton rdbtnNewRadioButton4 = new JRadioButton("4");
    
    private JFrame frmTesttitle2;
    
    String trainDatares[][];
      
    Show() {  
        jfc.setCurrentDirectory(new File("d://"));// 文件选择器的初始目录定为d盘  
          
        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();  
          
        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();  
          
        frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));// 设定窗口出现位置  
        frame.setSize(500, 240);// 设定窗口大小  
        frame.setContentPane(tabPane);// 设置布局  
        
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
        button1.addActionListener(this); // 添加事件处理  
        button2.addActionListener(this); // 添加事件处理  
        button3.addActionListener(this); // 添加事件处理 
        button5.addActionListener(this); // 添加事件处理 
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
        frame.setVisible(true);// 窗口可见  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 使能关闭窗口，结束程序  
        tabPane.add("choose files", con);// 添加布局1  
        
        
        
    }  
    /** 
     * 时间监听的方法 
     */  
    public void actionPerformed(ActionEvent e) {  
        // TODO Auto-generated method stub  
        if (e.getSource().equals(button1)) {// 判断触发方法的按钮是哪个  
            jfc.setFileSelectionMode(0);// 设定只能选择到文件夹  
            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
            if (state == 1) {  
                return;  
            } else {  
                File f = jfc.getSelectedFile();// f为选择到的目录  
                text1.setText(f.getAbsolutePath());  
            }  
        }  
        // 绑定到选择文件，先择文件事件  
        if (e.getSource().equals(button2)) {  
            jfc.setFileSelectionMode(0);// 设定只能选择到文件  
            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
            if (state == 1) {  
                return;// 撤销则返回  
            } else {  
                File f = jfc.getSelectedFile();// f为选择到的文件  
                text2.setText(f.getAbsolutePath());  
            }  
        }
        if (e.getSource().equals(button5)) {  
            jfc.setFileSelectionMode(1);// 设定只能选择到文件  
            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
            if (state == 1) {  
                return;// 撤销则返回  
            } else {  
                File f = jfc.getSelectedFile();// f为选择到的文件  
                text5.setText(f.getAbsolutePath());  
            }  
        }
        if (e.getSource().equals(button3)) {  
            // 弹出对话框可以改变里面的参数具体得靠大家自己去看，时间很短  
            //if(text1.getText().equals("")||text2.getText().equals(""))
            	//JOptionPane.showMessageDialog(null, rdbtnNewRadioButton1.isSelected(), "提示", 2);
            //else
            /*	
            JFrame f = new JFrame();
            f.setSize(400, 400);
            f.add(new Test3(Integer.parseInt(text1.getText()),Integer.parseInt(text2.getText())));
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            */
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
            //m.put(key, value)
            for(int i=0;i<trainres.length;i++){
            	//tmp[i]=trainres[i][5];
            	m.put(Double.parseDouble(trainres[i][5]),i);
            }
            List<Map.Entry<Double, Integer>> infoIds = new ArrayList<Map.Entry<Double, Integer>>(m.entrySet());


            Collections.sort(infoIds, new Comparator<Map.Entry<Double, Integer>>() {

                public int compare(Map.Entry<Double, Integer> o1,
                                   Map.Entry<Double, Integer> o2) {
//              System.out.println(o1.getKey()+"   ===  "+o2.getKey());
                    if(o1.getKey() > o2.getKey()){
                        return 1;
                    }else{
                        return -1;
                    }

                    /*if(!o1.getValue().equals(o2.getValue())) {
                        return (int) (o2.getValue() - o1.getValue());
                    }*/
                    
                }
            });
            
            for (int i = 0; i < infoIds.size()&&i<10; i++) {
                 System.out.println(infoIds.get(i).toString());
                 res[i]=trainres[Integer.parseInt(infoIds.get(i).toString().split("=")[1])];
                 System.out.println(res[i][5]);
            }
            
            
            

            text1.setText(trainres[0][5]);
            Test1.run(trainDatares,testres,de1,de2,res);
        	
        }  
    } 
    
    private void newf(){
		
		frmTesttitle2 = new JFrame();
		frmTesttitle2.setTitle("testtitle2");
		frmTesttitle2.setBounds(200, 200, 800, 600);
		frmTesttitle2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Sw window2 = new Sw();
		frmTesttitle2.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(80);
		frmTesttitle2.getContentPane().add(panel, BorderLayout.SOUTH);
		
		
	}
    
    
    
    public static void main(String[] args) {  
        new Show();  
    } 
    
}
