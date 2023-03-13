package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.ProductDTO;
import com.masai.model.Product;
import com.masai.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@PostMapping("/products")
	public ResponseEntity<Product> createBookHandler(@RequestBody Product product){
		
		Product cp= pService.registerProduct(product);
		
		return new ResponseEntity<Product>(cp,HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProductsHandler(){
		
		List<Product> li= pService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(li,HttpStatus.FOUND);
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product){
		
		Product up= pService.updateProduct(product);
		
		return new ResponseEntity<Product>(up,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProductHandler(@PathVariable("id") Integer id){
		
		Product dp= pService.deleteProductById(id);
		
		return new ResponseEntity<Product>(dp,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products/{category}")
	public ResponseEntity<List<Product>> getAllProductsByCategoryHandler(@PathVariable("category") String category){
		
		List<Product> li= pService.getsProductByCategory(category);
		
		return new ResponseEntity<List<Product>>(li,HttpStatus.FOUND);
	}
	
//	@GetMapping("/productDTO/{category}")
//	public ResponseEntity<List<ProductDTO>> getAllProductNameQuantityPriceHandler(@PathVariable("category") String category){
//		
//		List<ProductDTO> li= pService.getProductNameQtyPrice(category);
//		
//		return new ResponseEntity<List<ProductDTO>>(li,HttpStatus.CREATED);
//	}
	@GetMapping("/productDTO")
	public ResponseEntity<List<ProductDTO>> getAllProductNameQuantityPriceHandler(){
		
		List<ProductDTO> li= pService.getProductNameQtyPrice();
		
		return new ResponseEntity<List<ProductDTO>>(li,HttpStatus.CREATED);
	}
}
