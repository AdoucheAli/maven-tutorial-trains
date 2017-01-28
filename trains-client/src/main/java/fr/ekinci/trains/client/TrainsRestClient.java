package fr.ekinci.trains.client;

import fr.ekinci.trains.common.ItineraryItem;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.http.GET;

/**
 * Trains REST client
 *
 * @author Gokan EKINCI
 */
public interface TrainsRestClient {
	@GET("/trains/itinerary")
	Call<List<ItineraryItem>> getItinerary(@Query("departure") String departure, @Query("destination") String destination);
}