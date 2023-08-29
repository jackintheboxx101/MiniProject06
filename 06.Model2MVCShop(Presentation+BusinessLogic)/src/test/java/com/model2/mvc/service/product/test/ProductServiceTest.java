package com.model2.mvc.service.product.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.user.UserService;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context-common.xml",
													"classpath:config/context-aspect.xml",
													"classpath:config/context-mybatis.xml",
													"classpath:config/context-transaction.xml"})
public class ProductServiceTest {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	
	//@Test
	public void testInsertProduct()throws Exception {
		
		Product product = new Product();
		product.setProdName("≈¬«ˆπÊ");
		product.setProdDetail("¡π∑…><");
		product.setManuDate("180818");
		product.setPrice(7000);
		
		productService.addProduct(product);
		
		product = productService.getProduct(10000);
		
		Assert.assertEquals("±Ë≈¬«ˆπŸ∫∏", product.getProdName());
		
	}
	
	//@Test
	public void testFindProduct() throws Exception{
		
		Product product = new Product();
		
		product = productService.getProduct(10000);
		
		Assert.assertEquals("±Ë≈¬«ˆπŸ∫∏", product.getProdName());
		Assert.assertEquals("±Ë≈¬«ˆæ÷¥ƒ¿∫¿Ã", product.getProdDetail());
		Assert.assertEquals(1112222, product.getPrice());
	}
	//@Test
	public void testUpdateProduct()throws Exception{
		
		Product product =  productService.getProduct(10000);
		
		Assert.assertEquals("±Ë≈¬«ˆπŸ∫∏", product.getProdName());
		Assert.assertEquals("±Ë≈¬«ˆæ÷¥ƒ¿∫¿Ã", product.getProdDetail());
		Assert.assertEquals(1112222, product.getPrice());
		
		product.setProdName("±Ë≈¬«ˆπŸ∫∏∏€√Ê¿Ã");
		product.setProdDetail("ø©ƒ£æ¯¿Ω");
		product.setPrice(121212);
		
		productService.getProduct(10000);
		
		Assert.assertEquals("±Ë≈¬«ˆπŸ∫∏∏€√Ê¿Ã", product.getProdName());
		Assert.assertEquals("ø©ƒ£æ¯¿Ω", product.getProdDetail());
		Assert.assertEquals(121212, product.getPrice());
	}
	
	//@Test
	public void testGetProductListByProdNamel() throws Exception{
		
		Search search = new Search();
		
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("0");
		search.setSearchKeyword("10000");
		Map<String, Object> map = productService.getProductList(search);
		
		List<Object> list = (List<Object>)map.get("list");
		Assert.assertEquals(1, list.size());
		
		System.out.println(list);
		
		Integer totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);
		
		System.out.println("==============================");
		
		search.setSearchCondition("1");
		search.setSearchKeyword(""+System.currentTimeMillis());
		map = productService.getProductList(search);
		
		list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		//==> console »Æ¿Œ
	 	System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount); 
	}
	
}


