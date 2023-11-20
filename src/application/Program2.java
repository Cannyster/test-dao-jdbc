package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Forma de injeção de dependencia sem o programa conhecer a implementação 
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: department findById ===");
		System.out.println("Digite o Id do departemento: ");
		int id = sc.nextInt();
		System.out.println(departmentDao.findById(id));

		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> listDP = departmentDao.findAll();
		for(Department dp: listDP) {
			System.out.println(dp);
		}
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department newDepartment = new Department(null, "Sexual");
		departmentDao.insert(newDepartment);
		System.out.println("Inserido! New id = " + newDepartment.getId());
	
		System.out.println("\n=== TEST 5: department update ===");
		Department dpNew = departmentDao.findById(5);
		dpNew.setName("Conteúdo Adulto");
		departmentDao.update(dpNew);
		System.out.println("Update realizado");
		
		System.out.println("\n=== TEST 5: department delete ===");
		System.out.println("Digite o id do departamento que deseja excluir");
		int dpId = sc.nextInt();
		departmentDao.deleteById(dpId);
		System.out.println("Delete realizado");

		DB.closeConnection();
		sc.close();
	}

}
