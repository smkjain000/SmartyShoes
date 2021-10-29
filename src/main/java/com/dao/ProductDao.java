package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Product;

@Repository
public class ProductDao {
	
	@Autowired
	EntityManagerFactory emf; 
	
	public List<Product> getAllProduct(){
		EntityManager manager=emf.createEntityManager();
	
	Query qry=manager.createQuery("select prod from Product prod");
	List<Product>list=qry.getResultList();
	return list;
	
}

public boolean storeProductRecord(Product prod) {
	try {
		
		// it is like a session
		EntityManager manager=emf.createEntityManager();
		//it is like transaction in Hibernate
		EntityTransaction tran=manager.getTransaction();
		tran.begin();
		manager.persist(prod);      // like a save method
		tran.commit();
		return true;
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
		return false;
	}
}

public int updateProductRecord(Product prod) {
	EntityManager manager=emf.createEntityManager();
	Product p=manager.find(Product.class, prod.getId());
	if(p==null) {
		return 0;
	}else {
		EntityTransaction tran=manager.getTransaction();
		tran.begin();
		p.setPrice(prod.getPrice());
		manager.merge(p);
		tran.commit();
		return 1;
	}
}

public int deleteProductRecord(int id) {
	EntityManager manager=emf.createEntityManager();
	Product p=manager.find(Product.class,id);
	if(p==null) {
		return 0;
	}else {
		EntityTransaction tran=manager.getTransaction();
		tran.begin();
		manager.remove(p);
		tran.commit();
		return 1;
}
}

public Product findProductUsingId(int id) {
	EntityManager manager=emf.createEntityManager();
	Product p=manager.find(Product.class,id);
	return p;
}

}



