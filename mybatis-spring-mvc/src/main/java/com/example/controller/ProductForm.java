package com.example.controller;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.Product;

public class ProductForm {

	private Product product;
	private MultipartFile image;
	private MultipartFile filePath;
	private boolean newProduct;
	
	public ProductForm(Product product) {
		this.product = product;
		newProduct = false;
	}
	
	public ProductForm() {
		this.product = new Product();
		newProduct = true;
	}

	public Product getProduct() {
		return product;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	public MultipartFile getFilePath() {
		return filePath;
	}

	public void setFilePath(MultipartFile filePath) {
		this.filePath = filePath;
	}

	public boolean isNewProduct() {
		return newProduct;
	}

}