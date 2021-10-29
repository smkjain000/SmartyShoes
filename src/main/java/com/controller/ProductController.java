package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;
import com.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productservice;
	
	@RequestMapping(value = "adminlogin",method = RequestMethod.GET)
	public String adminlogin(@RequestParam("name")String name,@RequestParam("pass") String pass) {
		if(name.equals("Samyak")&&pass.equals("1234")) {
			return "Welcome  " + name;
		}else {
			return "Sorry, You are not registered";
		}
		
	}
	
	@RequestMapping(value="product",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProduct()
	{
		return productservice.getAllProduct();
	}
	
	
	@RequestMapping(value="storeProduct",method = RequestMethod.POST,consumes  = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody Product prod)
	{
		return productservice.storeProductRecord(prod);
	}
	
	@RequestMapping(value = "updateProduct", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct(@RequestBody Product prod)
	{
		return productservice.updateProductRecord(prod);
	}
	
	//http://localhost:9090/deleteEmployee/104
	@RequestMapping(value = "deleteProduct/{id}", method = RequestMethod.DELETE)
	public String deleteProductRecord(@PathVariable("id") int prodId)
	{
		return productservice.deleteProductRecord(prodId);
	}
	
	//http://localhost:9090/findEmployee/102
	@RequestMapping(value="findProduct/{id}", method=RequestMethod.GET)
	public Product findProductRecordById(@PathVariable("id") int prodId)
	{
		return productservice.findProduct(prodId);
	}
	
}
