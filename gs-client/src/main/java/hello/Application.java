
package hello;

import countries.wsdl.Country;
import countries.wsdl.GetCountryResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(CountryClient countryClient) {
		return args -> {
			String name = "Spain";

			if (args.length > 0) {
				name = args[0];
			}
			GetCountryResponse response = countryClient.getCountry(name);
			Country country = response.getCountry();

			String result = "Country name: " + country.getName() + "\n" + "Capital city: " + country.getCapital() + "\n Currency: " + country.getCurrency() + "\n Population: " + country.getPopulation();

			System.err.println(result);
		};
	}

}
