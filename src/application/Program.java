package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		System.out.println("FindById: \n" + seller);
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		System.out.println("\nFindByDepartment: ");
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		list = sellerDao.findAll();
		System.out.println("\nFindAll: ");
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nSeller insert: ");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		
		list = sellerDao.findAll();
		System.out.println("\nFindAll: ");
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nSeller update: ");
		seller = sellerDao.findById(1);
		seller.setName("Marta");
		sellerDao.update(seller);
		
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
	}

}
