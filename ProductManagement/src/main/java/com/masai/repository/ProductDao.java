package com.masai.repository;

import java.util.List;

//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.DTO.ProductDTO;
import com.masai.exception.ProductException;
import com.masai.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	public List<Product> findByCategory(String category);
	
//	@Query("select new com.masai.DTO.ProductDTO(p.productName,p.quantity,p.price) from Product p where p.category=?1")
//	public List<ProductDTO> getproductNameQtyPrice(String category) throws ProductException;
	
	@Query("select new com.masai.DTO.ProductDTO(p.productName,p.quantity,p.price) from Product p")
	public List<ProductDTO> getproductNameQtyPrice() throws ProductException;
	
	
}
