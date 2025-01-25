package com.Harsh.Ecom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Harsh.Ecom.model.Products;
@Repository
public interface ProductRepo extends JpaRepository<Products,Integer>{
	@Query("Select p from Products p Where "+"LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR"
			+ " LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
			+ "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
			+ "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Products> searchProduct(String keyword);
//	@Query("SELECT p from Products p WHERE"+"LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR"
//			+ " LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR"
//			+ " LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR"
//			+ " LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//	List<Products> searchProduct(String Keyword);

}
