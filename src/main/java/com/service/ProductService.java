package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productdao;
	
	public List<Product> getAllProduct(){
		return productdao.getAllProduct();
		
	}
	
	public String storeProductRecord(Product prod) {
		if(productdao.storeProductRecord(prod)) {
			return "Stored successfully";
		}else {
			return "Didn't store";
		}
	}
	
	public String updateProductRecord(Product prod) {
		if(productdao.updateProductRecord(prod)>0) {
			return "Record updated successfully";
		}else {
			return "Record didn't update";
		}
	}
	
	public String deleteProductRecord(int id) {
		if(productdao.deleteProductRecord(id)>0) {
			return "Record deleted successfully";
		}else {
			return "Record didn't delete";
		}
	}
	
	public Product findProduct(int id) {
		return productdao.findProductUsingId(id);
		
	}
	
}

