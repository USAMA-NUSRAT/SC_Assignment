package main;
import java.sql.*;
import java.io.*;
import  java.awt.*;
import  java.awt.event.*;
import javax.swing.*;
public class InfoStudent {
	    public static  void main(String [] args){
	      JFrame fa=new JFrame("Student");
	       fa.setSize(600,600);
	       JLabel str=new JLabel("Student Registration");
	          str.setBounds(50,100, 100,40);  
	        JTextField sr=new JTextField();
	        sr.setBounds(40,40, 50,30);
	         JLabel stn=new JLabel("Student Name");
	            stn.setBounds(50,50,80,40);  
	        JTextField sn=new JTextField();
	        sn.setBounds(40,40, 50,30);
	         JLabel std=new JLabel("Student Degree");
	            std.setBounds(50,50, 70,40);  
	        JTextField sd=new JTextField();
	        sd.setBounds(40,40, 50,30);
	         JLabel sts=new JLabel("Student Semester");
	            sts.setBounds(50,50, 80,40);  
	        JTextField ss=new JTextField();
	        ss.setBounds(40,40, 50,30);
	         JLabel stc=new JLabel("Student Section");
	            stc.setBounds(50,50,80,40);  
	        JTextField sc=new JTextField();
	        sc.setBounds(40,40, 50,30);
	        JButton show=new JButton("Show");
	        show.setBounds(40,50,40,50);
	          JButton submit=new JButton("Submit");
	        show.setBounds(40,50,40,50);
	          JButton reset=new JButton("reset");
	        show.setBounds(40,50,40,50);
	        JPanel p=new JPanel();
	        //      p.setBounds(300,300,500,500);
	        fa.add(str);
	        fa.add(sr);
	        fa.add(stn);
	        fa.add(sn);
	        fa.add(std);
	        fa.add(sd);
	        fa.add(sts);
	        fa.add(ss);
	        fa.add(stc);
	        fa.add(sc);
	        p.add(show);
	        p.add(submit);
	        p.add(reset);
	         fa.add(p);
	        fa.setLayout(new GridLayout(7,2,20,20)); 
	        fa.setVisible(true);
	       /////////////reset //////////////
	        reset.addActionListener(new ActionListener() {  
	              public void actionPerformed(ActionEvent e) {
	            	sr.setText("");  
	            	sn.setText(""); 
	            	sd.setText(""); 
	            	ss.setText(""); 
	            	sc.setText(""); 
	              }
	        });
	        /////////////////////////////////show data    //////////////////////////
	        show.addActionListener(new ActionListener() {  
	              public void actionPerformed(ActionEvent e) {
	            	  Connection conn = null;
	  			 	try{
	  			 	//STEP 2: Register JDBC driver
	  			 	Class.forName("com.mysql.cj.jdbc.Driver");
	  			 	//STEP 3: Open a connection
	  			 	System.out.println("Connecting to database...");
	  			 	String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
	  			 	//Database credentials
	  			 	String USER = "root";
	  			 	String PASS = "mysql12345";
	  			 	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	  			 	//STEP 4: Execute a query
	  			 	System.out.println("Creating statement...");
	  			 	Statement stmt = conn.createStatement();
	  			 	String squery="Select  Std_reg,St_name,Degree,Section,Semester from studentinfo";
	  			 	System.out.println("Succesfully executed");
	  			 	ResultSet rs= stmt.executeQuery(squery);
	  			 	while(rs.next()) {
	  			 		String regno  = rs.getString("Std_reg");
	  				 	String name = rs.getString("St_name");
	  				 	String degree = rs.getString("Degree");
	  				 	String Section = rs.getString("Section");
	  				 	int semester=rs.getInt("Semester");
	  			 		System.out.println(" Student Reg no: "+regno+" Student name : "+name+"  Degree :  "+degree+" Section : "+Section+" Semester : "+semester);
	  			 	}
	  			 	stmt.close();
				 	conn.close();
	  			 	}catch(Exception se){
	  				 	//Handle errors for JDBC
	  				 	se.printStackTrace();
	  				 	}   
	              }
	        });
	        ////////////submitdata/////////////////
	        submit.addActionListener(new ActionListener() {  
	              public void actionPerformed(ActionEvent e) {
	            	  String streg=sr.getText();
	            	  String ssname=sn.getText();
	            	  String ddeg=sd.getText();
	            	  int stsem=Integer.parseInt(ss.getText());
	            	  String sectn=sc.getText();
	       System.out.println(" reg : "+streg+" name : "+ssname+" degree: "+ddeg+" semester "+stsem+"  Section : "+sectn);  
	            	  Connection conn = null;
	  			 	try{
	  			 	//STEP 2: Register JDBC driver
	  			 	Class.forName("com.mysql.cj.jdbc.Driver");
	  			 	//STEP 3: Open a connection
	  			 	System.out.println("Connecting to database...");
	  			 	String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
	  			 	//Database credentials
	  			 	String USER = "root";
	  			 	String PASS = "mysql12345";
	  			 	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	  			 	//STEP 4: Execute a query
	  			 	System.out.println("Creating statement...");
	  			 	Statement stmt = conn.createStatement();
	  			 	String ssql = "Insert into studentinfo (Std_reg,St_name,Degree,Section,Semester) Values ('"+streg+"','"+ssname+"','"+ddeg+"','"+sectn+"',"+stsem+")";
	  			 	System.out.println("Succesfully executed");
	  			 	stmt.execute(ssql);
	  			 	stmt.close();
				 	conn.close();
	  			 	}catch(Exception se){
	  				 	//Handle errors for JDBC
	  				 	se.printStackTrace();
	  				 	}   
	              }
	        });
	    }	
}
