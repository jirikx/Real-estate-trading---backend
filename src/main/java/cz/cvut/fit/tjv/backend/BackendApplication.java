package cz.cvut.fit.tjv.backend;

import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.rsocket.server.ConfigurableRSocketServerFactory;

import java.util.Set;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.out.println("Hello world :)");
		User tomasNovak = new User("Tomas Novak", "tomas@novak.cz");
		User janStary = new User("Jan Stary", "jan@stary.cz");

		Offer offer = new Offer(tomasNovak, 1000L, "Popis objednavky");
		janStary.addOfferToFavs(offer);
	}

}
