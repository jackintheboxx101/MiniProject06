package com.model2.mvc.service.product;

import java.util.HashMap;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;

public interface ProductService {
	
	
	public Map<String,Object> getProductList(Search search) throws Exception;
	
	public void updateProduct(Product productVO) throws Exception;
	
	public void addProduct(Product productVO) throws Exception;
	
	public Product getProduct(int prodNo) throws Exception;			//나중에 확인 
	
	
}
