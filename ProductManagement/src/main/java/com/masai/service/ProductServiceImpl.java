package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.ProductDTO;
import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao pDao;
	
	@Override
	public Product registerProduct(Product p) throws ProductException {
		// TODO Auto-generated method stub
		Product pr=pDao.save(p);
		
		return pr;
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> li= pDao.findAll();
		
		if(li.size() > 0)
		return li;
		else
		throw new ProductException("No products are found...");
	}

	@Override
	public Product updateProduct(Product p) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> opt= pDao.findById(p.getProductId());
		
		if(opt.isEmpty()) {
			throw new ProductException("There's no such product");
		}
		else {
			return pDao.save(p);
		}
//		return null;
	}

	@Override
	public Product deleteProductById(Integer pid) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> opt= pDao.findById(pid);
		
		if(opt.isPresent())
		{
			Product pr=opt.get();
			
			pDao.delete(pr);
			
			return pr;
		}else {
			throw new ProductException("There is no product present with product ID " + pid);
		}
			
//		return null;
	}

	@Override
	public List<Product> getsProductByCategory(String category) throws ProductException {
		// TODO Auto-generated method stub
		List<Product> li= pDao.findByCategory(category);
		
		if(li.size() >0) {
			return li;
		}
		else {
			throw new ProductException("There's no product present in the category " +category);
		}
//		return null;
	}

	@Override
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException {
		// TODO Auto-generated method stub
		List<ProductDTO> li= pDao.getproductNameQtyPrice();
		
		if(li.isEmpty()) {
			throw new ProductException("There are no products present");
		}
		else {
			return li;
		}
//		return null;
	}

}
