package com.Harsh.Ecom.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Harsh.Ecom.model.Products;
import com.Harsh.Ecom.repo.ProductRepo;

@Service
public class ProductServices {
	@Autowired
	private ProductRepo repo;

	public  List<Products> Allproducts(){
		return repo.findAll();
	}

	public Products getSinglrproduct(int id) {
	
		return repo.findById(id).orElse(new Products());
	}

	public Products addproduct(Products product, MultipartFile imageFile) throws IOException {
		product.setImagename(imageFile.getOriginalFilename());
		product.setImagetype(imageFile.getContentType());
		product.setImagedata(imageFile.getBytes());
		return repo.save(product);
	}

	public Products updateProduct(int id, Products product, MultipartFile imageFile) throws IOException {
		product.setImagename(imageFile.getOriginalFilename());
		product.setImagetype(imageFile.getContentType());
		product.setImagedata(imageFile.getBytes());
		return repo.save(product);
	}

	public void deleteProduct(int id) {
		repo.deleteById(id);;
	}

	public List<Products> searchProduct(String keyword) {

		return repo.searchProduct(keyword);
	}

}
