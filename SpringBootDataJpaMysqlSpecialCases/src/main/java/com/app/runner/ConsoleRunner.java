package com.app.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;
@Component
public class ConsoleRunner implements CommandLineRunner {
@Autowired
    private ProductRepository repo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
/*Product p=repo.getData(4);
System.out.println(p.getProdCode());/may show null pointer exception if id=4 not exists
*/
		//to avoid null pointer exception
Optional<Product> p1=repo.getMydata(4);
if(p1.isPresent()) {
	Product prd=p1.get();
	System.out.println(prd.getProdCode());
}else {
	System.out.println("data not found");
}
	
	}

}
