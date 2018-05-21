package com.thoughtworks.interview.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.thoughtworks.interview.model.Product;

@Component
public class ProductService {
	
	List<Product> products;
	
	public ProductService() {
		products = new ArrayList<Product>();
	}
	public ProductService(List<Product> products) {
		this.products = products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public int getProductCount() {
		return products.size();
	}
	
	public int getActiveProductCount() {
		int count = 0;
		for(Product product : products) {
			if(isActive(product)) 
				count++;
		}
		return count;
	}

	Date today = new Date();
	Date curdate = new Date(today.getYear(), today.getMonth(), today.getDate());
	
	private boolean isActive(Product product) {
    	if((product.getStartDate()!=null)&&(product.getStartDate().before(curdate))) {
    		if((product.getEndDate()==null)||(product.getEndDate().after(curdate)||(product.getEndDate().equals(curdate)))) {
    			return true;
    		}
    	}
		return false;
	}
	
	public int getActiveProductsValue() {
		int totalValue = 0;
		for(Product product : products) {
			if(isActive(product)) 
				totalValue += product.getPrice();
		}
		return totalValue;		
	}
	
	public Map<String, Integer> getProductCategories() {
		Map<String, Integer> categorymap = new HashMap<String, Integer>();
		for(Product product : products) {
			if(isActive(product)) {
				if(categorymap.containsKey(product.getCategory())) {
					categorymap.put(product.getCategory(), categorymap.get(product.getCategory())+1);
				} else {
					categorymap.put(product.getCategory(), 1);
				}
			}
		}
		return categorymap;
	}
}
