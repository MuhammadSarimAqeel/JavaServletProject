package com.springORM;

import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.studentDao;
import com.entities.student;

import jdk.internal.org.jline.utils.InputStreamReader;


public class App 
{
    public static void main( String[] args )
    {
   ApplicationContext context =    new ClassPathXmlApplicationContext("config.xml");
    studentDao sdao=context.getBean("studentDao" ,studentDao.class);
    
   Scanner sc = new Scanner(System.in);
   boolean b = true;
   System.out.println("\n");
   while(b) {
   System.out.println("press 1 to Add new Student");
   System.out.println("press 2 to display all Students");
   System.out.println("press 3 to display single student details");
   System.out.println("press 4 to delete student");
   System.out.println("press 5 to update student");
   System.out.println("press 6 for exit");
   try {
	int input = Integer.parseInt(sc.next()) ; 
	switch (input) {
	case 1:
		System.out.println("Enter Student Id");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		System.out.println("Enter Students Name");
		Scanner scan2 = new Scanner(System.in);
		String name = scan2.nextLine();
		System.out.println("Enter Students City");
		Scanner scan3 = new Scanner(System.in);
		String city = scan3.nextLine();
		student student = new student();
		student.setId(id);
		student.setName(name);
		student.setCity(city);
		
		sdao.insert(student);
		System.out.println("Added Successfully");
		b= false;
		break;
	case 2:
		student student2 = new student();
	List<student> allstudent =	sdao.getstudents();
	for(student st : allstudent) {
		System.out.println("Id: "+ st.getId());
		System.out.println("Name: "+ st.getName());
		System.out.println("City: "+ st.getCity());
		System.out.println("\n");
		
	}
		b=false;
		break;
	case 3:
		System.out.println("Enter  Students Id");
		Scanner scan4= new Scanner(System.in);
		int sid = scan4.nextInt();
		student student3 = new student();
		
		student st = sdao.getstudentbyid(sid);
		System.out.println("Id :" +st.getId());
		System.out.println("Name :" +st.getName());
		System.out.println("City :" +st.getCity());
		System.out.println("\n");
		b=false;
		break;
	case 4:
		System.out.println("Enter Student Id");
		Scanner scan5 = new Scanner(System.in);
		int delId= scan5.nextInt();
		student student4 = new student();
		sdao.delete(delId);
		System.out.println("Deleted successfully");
		b= false;
		break;
		
	case 5:
		
		System.out.println("Enter Student Id to Edit");
		Scanner scan6 = new Scanner(System.in);
		int uid = scan6.nextInt();
		System.out.println("Enter new Students Name");
		Scanner scan7 = new Scanner(System.in);
		String uname = scan7.nextLine();
		System.out.println("Enter Students City");
		Scanner scan8 = new Scanner(System.in);
		String ucity = scan8.nextLine();
		student student8 = new student();
		student8.setId(uid);
		student8.setName(uname);
		student8.setCity(ucity);

		sdao.update(student8);
		System.out.println("Updated Successfully Successfully");
		b= false;
		break;
	case 6:
		b = false;
		break;
	default:
		break;
	}
   }catch(Exception e){
	   System.out.println("Invalid input Try Again");
	   System.out.println(e.getMessage());
   }
   
   
   
   }
   System.out.println("Thanks for using my application");
    }
}
