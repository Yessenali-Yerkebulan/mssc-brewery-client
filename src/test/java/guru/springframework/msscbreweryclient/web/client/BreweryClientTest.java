package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDto;

@SpringBootTest
public class BreweryClientTest {
	
	@Autowired
	BreweryClient client;
	
	@Test
	void getBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		
		assertNotNull(dto);
	}

	@Test
	void testSaveNewBeer(){
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		URI uri = client.saveNewBeer(beerDto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}

	@Test
	void testUpdateBeer(){
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		client.updateBeer(UUID.randomUUID(), beerDto);
	}

	@Test
	void testDeleteBeer(){
		client.deleteBeer(UUID.randomUUID());
	}

	@Test
	void getCustomerById() {
		CustomerDto dto = client.getCustomerById(UUID.randomUUID());

		assertNotNull(dto);
	}

	@Test
	void testSaveNewCustomer(){
		CustomerDto customerDto = CustomerDto.builder().name("Joe").build();
		URI uri = client.saveNewCustomer(customerDto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}

	@Test
	void testUpdateCustomer(){
		CustomerDto customerDto = CustomerDto.builder().name("Jim").build();
		client.updateCustomer(UUID.randomUUID(), customerDto);
	}

	@Test
	void testDeleteCustomer(){
		client.deleteCustomer(UUID.randomUUID());
	}
}
