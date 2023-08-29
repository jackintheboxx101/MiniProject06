package com.model2.mvc.service.product;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;


public interface ProductDAO {


	public void insertProduct(Product product) throws Exception ;

	public Product findProduct(int prodNo) throws Exception ;

	public List<Product> getProductList(Search search) throws Exception;

	public void updateProduct(Product product) throws Exception ;
	
	public int getTotalCount(Search search) throws Exception;
		
}