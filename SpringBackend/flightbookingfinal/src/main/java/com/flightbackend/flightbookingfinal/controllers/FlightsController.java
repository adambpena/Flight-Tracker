package com.flightbackend.flightbookingfinal.controllers;

import java.util.List;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.flightbackend.flightbookingfinal.models.FlightModel;
import com.flightbackend.flightbookingfinal.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/flights")
@CrossOrigin("*")
public class FlightsController {

    @Autowired
    FlightService flightService;

    //private static SecurityToken secureToken;
    private static Amadeus amadeus = Amadeus.builder("ot7oQOp0XyJc3bdFiSyPawJkhgreG442", "DJJGBJqOXGrIAyTs").build();

    @GetMapping("/amadeustest")
    public FlightOfferSearch[] testAmadeus() throws ResponseException {
        // String JsonResponse = "";

        FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
              Params.with("originLocationCode", "SYD")
                      .and("destinationLocationCode", "BKK")
                      .and("departureDate", "2022-09-01")
                      .and("adults", 1)
                      .and("max", 250)); 

        // for(FlightOfferSearch flightIn : flightOffersSearches){
        //     JsonResponse += flightIn.getResponse().getBody();
        // }
        return flightOffersSearches; 
    }

    @GetMapping("/listConvert")
    public List<FlightModel> checkServiceLogic(@RequestParam(defaultValue = "SYD") String departIata,
                                               @RequestParam(defaultValue = "BKK") String arrivalIata,
                                               @RequestParam(defaultValue = "2022-09-01") String departureDate,
                                               @RequestParam(defaultValue = "1") String numAdults) throws ResponseException{
        return flightService.getSearchedFlights(departIata, arrivalIata, departureDate, Integer.parseInt(numAdults));
    }
}

    // Pre-SDK approach. Worked too hard on it to delete now 
    // @GetMapping("/getflights")
    // public String getSearchedFlights(
    //     @RequestParam (defaultValue = "SYD") String departureIata,
    //     @RequestParam (defaultValue = "BKK") String arrivalIata,
    //     @RequestParam (defaultValue = "2022-11-01")String departureData,
    //     @RequestParam (defaultValue = "1") int numOfAdults, 
    //     @RequestParam (defaultValue = "false") boolean nonstop) throws IOException, InterruptedException{

    //         List<Flight> flights = new ArrayList<Flight>();

    //         HttpClient tokenClient = HttpClient.newHttpClient();
    //         HttpRequest tokenRequest = HttpRequest.newBuilder()
    //                             .uri(URI.create("https://test.api.amadeus.com/v1/security/oauth2/token"))
    //                             .header("Content-Type", "application/x-www-form-urlencoded")
    //                             .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&client_id=ot7oQOp0XyJc3bdFiSyPawJkhgreG442&client_secret=DJJGBJqOXGrIAyTs"))
    //                             .build();
            
    //         HttpResponse<String> tokenResponse = tokenClient.send(tokenRequest, HttpResponse.BodyHandlers.ofString());

    //         ObjectMapper tokenMapper = new ObjectMapper();
    //         secureToken = tokenMapper.readValue(tokenResponse.body(), SecurityToken.class);

    //         String credentialKey = "Bearer " + secureToken.getToken();

    //         String flightApiReq = "https://test.api.amadeus.com/v2/shopping/flight-offers?originLocationCode=" 
    //                                     + departureIata + "&destinationLocationCode="
    //                                     + arrivalIata + "&departureDate="
    //                                     + departureData + "&adults="
    //                                     + numOfAdults + "&nonStop="
    //                                     + nonstop  + "&max=250"; 
            

    //         HttpClient client = HttpClient.newHttpClient();
    //         HttpRequest request = HttpRequest.newBuilder()
    //                             .uri(URI.create(flightApiReq))
    //                             .GET()
    //                             .header("Authorization", credentialKey)
    //                             .header("client_id", "ot7oQOp0XyJc3bdFiSyPawJkhgreG442")
    //                             .header("client_secret", "DJJGBJqOXGrIAyTs")
    //                             .build();
    //         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
    //         ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //         mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    //         flights = Arrays.asList(mapper.readValue(response.body(), Flight[].class));
    //         return flights.get(4).getData().get(2).getPrice().getTotal();
    // } 

