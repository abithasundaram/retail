package retail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.junit.jupiter.MockitoExtension;


import com.project.retail.service.ProductService;
import com.project.retail.model.Product;
import com.project.retail.repository.product;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ExtendWith(MockitoExtension.class)
public class RetailApplicationTests {
	
	@InjectMocks
	ProductService productservice;
	@Mock
	product product;

	static Product pd = null;
	
//	@BeforeAll
//	static void createProduct() {
//	
//	}
	@BeforeEach
	void createObject() {
		pd = new Product();
		pd.setProductId(1);
		pd.setProductName("choclate");
		pd.setProductPrice(1000);				
		}
	
	@Test
	void checkAddProductService() {
		
   Mockito.when(product.save(pd)).thenReturn(pd);
	Product addedpd = productservice.addproduct(pd);
	
	Assertions.assertNotNull(addedpd);
	Assertions.assertEquals(1, addedpd.getProductId());		
	}
	
	@Test
	void checkDeleteProduct() {
		Mockito.when(product.existsById(pd.getProductId())).thenReturn(true);
		Mockito.doNothing().when(product).deleteById(pd.getProductId());
		boolean check = productservice.deleteProduct(pd.getProductId());
		Assertions.assertTrue(check);
		Mockito.verify(product,times(1)).deleteById(pd.getProductId());		
		
	}
	
	//Private method
	@Test
  void checkValidatename() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		java.lang.reflect.Method method = productservice.getClass().getDeclaredMethod("checkValidateName", String.class);
		method.setAccessible(true);
		
	boolean valid =	(boolean) method.invoke(productservice, "milkybar");
	Assertions.assertTrue(valid);
	
	boolean Notvalid =	(boolean) method.invoke(productservice, "");
	Assertions.assertFalse(Notvalid);
	
	
}
	
	void checkInvalidaddProduct() {
	    // create a product with invalid name
	    Product invalidProduct = new Product();
	    invalidProduct.setProductId(2);
	    invalidProduct.setProductName(""); // invalid name
	    invalidProduct.setProductPrice(500);
		 Assertions.assertThrows(RuntimeException.class, () -> {
			 productservice.addproduct(invalidProduct);
		 });
	}
}
