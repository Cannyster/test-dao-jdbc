package application;

import java.util.Date;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department obj = new Department(1, "Books");
		Scanner sc = new Scanner(System.in);
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		//Forma de injeção de dependencia sem o programa conhecer a implementação 
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		/*
		System.out.println("=== TEST 1: seller findById ===");
		Seller sellerDao2 = sellerDao.findById(3);
		System.out.println(sellerDao2);

		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller se: list) {
			System.out.println(se);
		}
				
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller se: list) {
			System.out.println(se);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		seller.setBaseSalary(7500.0);
		seller.setEmail("martaw@outlook.com");
		sellerDao.update(seller);
		System.out.println("Update realizado");
		*/
		
		System.out.println("\n=== TEST 5: seller delete ===");
		System.out.println("Digite o id do vendedor que deseja excluir");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete realizado");
		
		DB.closeConnection();
		sc.close();
	}

}
