package app;

import java.util.Scanner;

import dao.EmployeeDao;
import model.Employee;
import util.JpaUtil;

public class Main {
	public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        EmployeeDao dao = new EmployeeDao();

		        while (true) {

		            System.out.println("\n===== Employee Management System =====");
		            System.out.println("1. Add Employee");
		            System.out.println("2. View Employees");
		            System.out.println("3. Search Employee");
		            System.out.println("4. Update Employee");
		            System.out.println("5. Delete Employee");
		            System.out.println("6. Exit");

		            System.out.print("Enter your choice: ");
		            int choice = sc.nextInt();

		            switch (choice) {
		            case 1:

		                System.out.print("Enter ID: ");
		                int id = sc.nextInt();
		                sc.nextLine();

		                System.out.print("Enter Name: ");
		                String name = sc.nextLine();

		                System.out.print("Enter Department: ");
		                String department = sc.nextLine();

		                System.out.print("Enter Salary: ");
		                double salary = sc.nextDouble();

		                Employee employee =
		                        new Employee(id, name, department, salary);

		                dao.addEmployee(employee);

		                break;
		                
		            case 2:

		                dao.viewEmployee();

		                break;
		                
		            case 3:

		                System.out.print("Enter Employee ID : ");

		                int searchId = sc.nextInt();

		                dao.searchEmployee(searchId);

		                break;
		            case 4:

		                System.out.print("Enter Employee ID : ");
		                int updateId = sc.nextInt();
		                sc.nextLine();

		                System.out.print("Enter Name : ");
		                String updateName = sc.nextLine();

		                System.out.print("Enter Department : ");
		                String updateDepartment = sc.nextLine();

		                System.out.print("Enter Salary : ");
		                double updateSalary = sc.nextDouble();

		                Employee updateEmployee =
		                        new Employee(updateId,
		                                updateName,
		                                updateDepartment,
		                                updateSalary);

		                dao.updateEmployee(updateEmployee);

		                break;
		            case 5:

		                System.out.print("Enter Employee ID : ");

		                int deleteId = sc.nextInt();

		                dao.deleteEmployee(deleteId);

		                break;
		               
		            case 6:

		                JpaUtil.close();

		                sc.close();

		                System.out.println("Thank You!");

		                System.exit(0);

		            

		            }

		        }

		    }

		
		
	}


