package fr.ekinci.trains.client;

import java.util.List;
import java.io.IOException;
import fr.ekinci.trains.common.ItineraryItem;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Main class for client
 *
 * @author Gokan EKINCI
 */
public class MainClient {
	public static void main(String[] args) throws IOException {
		String departure = "87, bd Jean Jaurès, 92110, Clichy";
		String destination = "1, Rue du Chat qui Pêche, 75005, Paris";
		
		TrainsRestClient restClient = getRetrofit("http://localhost:8080").create(TrainsRestClient.class);
		List<ItineraryItem> itineraryItems = restClient.getItinerary(departure, destination).execute().body();

		for (ItineraryItem item : itineraryItems) {
			System.out.println("Mode de transport    : " + item.getMode());
			System.out.println("Départ               : " + item.getDepartureStation());
			System.out.println("  -> en direction de : " + item.getDirection());
			System.out.println("Nom de stations      : " + item.getNbStations() + " | Durée : " + item.getDuration() + " min");
			System.out.println("Arrivée              : " + item.getArrivalStation());
			System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
		}
	}

	public static Retrofit getRetrofit(String baseUrl) {
		return new Retrofit.Builder()
			.baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	}
}