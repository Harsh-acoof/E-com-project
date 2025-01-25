package com.Harsh.Ecom.Controler;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Harsh.Ecom.model.Products;
import com.Harsh.Ecom.services.ProductServices;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductServices service;
	
	@GetMapping("/")
	public String hello() {
		return "hellow world!";
	}
	@GetMapping("/product")
	public ResponseEntity<List<Products>> Allproducts() {
		List<Products> products= service.Allproducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Products> singleproduct(@PathVariable int id) {
		Products products = service.getSinglrproduct(id);
		if (products != null) {
		return new ResponseEntity<>(products, HttpStatus.OK);}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/product")
	public ResponseEntity<?> addproduct(@RequestPart Products product,
			@RequestPart MultipartFile imageFile) throws IOException {
		try {
		Products products1 = service.addproduct(product,imageFile);
		return new ResponseEntity<>(products1,HttpStatus.CREATED);}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	
		
	}
	
	@GetMapping("/product/{productid}/image")
	public ResponseEntity<byte[]> imageproduct(@PathVariable int productid){
		Products product=service.getSinglrproduct(productid);
		byte[] imageFile=product.getImagedata();
		
		return ResponseEntity.ok()
				.contentType(MediaType.valueOf(product.getImagetype()))
				.body(imageFile);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id,
			@RequestPart Products product,
			@RequestPart MultipartFile imageFile) {
		Products product1;
		try {
			product1 = service.updateProduct(id,product,imageFile);
		} catch (IOException e) {
			return new ResponseEntity<>("Failed to update product",HttpStatus.BAD_REQUEST);
			
		}
		if (product1 != null) {
				return new ResponseEntity<>("Product Updated",HttpStatus.OK) ;}
		else return new ResponseEntity<>("Failed to update product",HttpStatus.BAD_REQUEST);
				
		
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		Products product = service.getSinglrproduct(id);
		if(product != null) {
			service.deleteProduct(id);
			return new ResponseEntity<>("product deleted",HttpStatus.OK);
			
		}
		else return new ResponseEntity<>("Product Not found",HttpStatus.BAD_REQUEST); 
	}
	@GetMapping("/product/search")
	public ResponseEntity<List<Products>> searchProduct(@RequestParam String keyword){
		List<Products> product = service.searchProduct(keyword);
		return new ResponseEntity<>(product,HttpStatus.OK);
		
	}
	
	
	
	
}
