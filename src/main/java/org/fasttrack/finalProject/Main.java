package org.fasttrack.finalProject;

import org.fasttrack.finalProject.product.Product;
import org.fasttrack.finalProject.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner atStartup(ProductRepository repository){
		return args -> {
			repository.save(new Product(1,"Refrigerator","Cryogonal.ltd","Appliances",1000,57));
			repository.save(new Product(2,"Television","ChromaVision.inc","Electronics",250,102));
			repository.save(new Product(3,"Washing Machine","Cryogonal.ltd","Appliances",920,83));
			repository.save(new Product(4,"Stove","Trogdor.ltd","Appliances",300,207));
			repository.save(new Product(5,"Lightbulb","ChromaVision.ltd","Fixtures",10,1009));
			repository.save(new Product(6,"Sofa","Mr.Jeb","Furniture",523,23));
			repository.save(new Product(7,"Refrigerator","Phylly's Fridge Freezers","Appliances",1200,77));
			repository.save(new Product(8,"Drone","BirdWatch.inc","Electronics",800,111));
			repository.save(new Product(9,"Electric Arc Furnace","Honeydew.ltd","Appliances",250000,2));
		};
	}

}
