package com.Harsh.Ecom.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

//import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String name;
	private String description;
	private String brand;
	private String category;
	private BigDecimal price;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern=("dd-MM-yyyy"))
	private Date releaseDate;
	private boolean productAvailable;
	private int stockQuantity;
	private String imagetype;
	private String imagename;
	@Lob
	private byte[] imagedata;
	public Products() {
		super();
	}
	public Products(int id, String name, String description, String brand, String category, BigDecimal price,
			Date releaseDate, boolean productAvailable, int stockQuantity, String imagetype, String imagename,
			byte[] imagedata) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.releaseDate = releaseDate;
		this.productAvailable = productAvailable;
		this.stockQuantity = stockQuantity;
		this.imagetype = imagetype;
		this.imagename = imagename;
		this.imagedata = imagedata;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isProductAvailable() {
		return productAvailable;
	}
	public void setProductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public String getImagetype() {
		return imagetype;
	}
	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public byte[] getImagedata() {
		return imagedata;
	}
	public void setImagedata(byte[] imagedata) {
		this.imagedata = imagedata;
	}
	@Override
	public String toString() {
		return "Products [Id=" + Id + ", name=" + name + ", description=" + description + ", brand=" + brand
				+ ", category=" + category + ", price=" + price + ", releaseDate=" + releaseDate + ", productAvailable="
				+ productAvailable + ", stockQuantity=" + stockQuantity + ", imagetype=" + imagetype + ", imagename="
				+ imagename + ", imagedata=" + Arrays.toString(imagedata) + "]";
	}
	
}
