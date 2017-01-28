package fr.ekinci.trains.server;

import fr.ekinci.trains.common.ItineraryItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/trains")
public class TrainsController {

	@RequestMapping(value = "/itinerary", method = RequestMethod.GET)
	public List<ItineraryItem> getItinerary(
		@RequestParam("departure") String departure,
		@RequestParam("destination") String destination
	) {
		return getMock();
	}

	public List<ItineraryItem> getMock() {
		List<ItineraryItem> itineraryItems = new ArrayList<>();
		itineraryItems.add(
			ItineraryItem.builder()
				.mode("Métro Ligne 13")
				.departureStation("Mairie de Clichy")
				.direction("Châtillon Montrouge")
				.nbStations(9)
				.duration(14)
				.arrivalStation("Invalides")
				.build()
		);
		itineraryItems.add(
			ItineraryItem.builder()
				.mode("RER C")
				.departureStation("Invalides")
				.direction("Gare d'Austerlitz")
				.nbStations(2)
				.duration(6)
				.arrivalStation("Saint-Michel Notre-Dame")
				.build()
		);
		return itineraryItems;
	}
}