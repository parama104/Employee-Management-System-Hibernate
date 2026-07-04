package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Employee;
import util.JpaUtil;

public class EmployeeDao {
	
	public void addEmployee(Employee employee) {
		
		EntityManagerFactory emf=JpaUtil.getEntityManagerFactory();
		
		EntityManager em= emf.createEntityManager();
		
		EntityTransaction transaction=em.getTransaction();
		
		try {
			transaction.begin();
			
			Employee existingEmployee = em.find(Employee.class, employee.getId());
			if(existingEmployee!=null) {
				
				System.out.println("already exists");
				
			}else {
				em.persist(employee);
				transaction.commit();
				System.out.println("employee added successfully");
				
			}
			
			
		}catch(Exception e) {
			
			if(transaction.isActive()) {
				transaction.rollback();
				
			}
			System.out.println("Error: " + e.getMessage());
			
		}finally {
			em.close();
			
		}
			
	}
	
	public void viewEmployee() {
		EntityManagerFactory emf=JpaUtil.getEntityManagerFactory();
		
		EntityManager em=emf.createEntityManager();
		try {
			TypedQuery<Employee> query= em.createQuery("From Employee",Employee.class);
			
			List<Employee> employees = query.getResultList();
			
			for(Employee employee:employees) {
				System.out.println(employee);
				
			}
			
		} catch (Exception e) {
			 System.out.println("Error while fetching employees.");
		       e.printStackTrace();
			
		}
		finally {
			em.close();
		}
		
		
			
	}
	
	public void searchEmployee(int id) {
		
		EntityManagerFactory emf=JpaUtil.getEntityManagerFactory();
		
		EntityManager em=emf.createEntityManager();
		
		try {
			Employee employee=em.find(Employee.class, id);
			
			if(employee!=null) {
				System.out.println(employee);
				
				
			}else {
				System.out.println("employee not found");
			}
			
		}catch(Exception e) {
			System.out.println("Error while searching employees.");
			e.printStackTrace();
			
		
			
		}
		finally {
			em.close();
		}
		
	
		
		
		
	}
	
	public void updateEmployee(Employee employee) {
		EntityManagerFactory emf=JpaUtil.getEntityManagerFactory();
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction tran=em.getTransaction();
		try {
			  tran.begin();
			  
			  Employee existingEmployee = em.find(Employee.class, employee.getId());
			  if(existingEmployee!=null) {
				  em.merge(employee);
			       tran.commit();
			       System.out.println("updated successfully");
				  
			  }else {
				  System.out.println("id not found");
			  }
		      
			
		} catch (Exception e) {
			
			if(tran.isActive()) {
				tran.rollback();
				
			}
			System.out.println("error while updating");
			e.printStackTrace();
			
			
		}finally {
			em.close();
		}
		
	     
	       
	       
		
	}
	public void deleteEmployee(int id) {
		EntityManagerFactory emf=JpaUtil.getEntityManagerFactory();
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction tran=em.getTransaction();
		
		try {
			
			tran.begin();
			
			Employee employee = em.find(Employee.class, id);
			
		

			if (employee != null) {
			    em.remove(employee);
			    tran.commit();
			    System.out.println("Employee deleted successfully");
			} else {
			    System.out.println("Employee not found");
			}
			
			
		} catch (Exception e) {
			System.out.println("employee not found");
			tran.rollback();
			
			
		}
		finally {
			em.close();
		}
		

		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
