package com.flightbackend.flightbookingfinal.models; 

import com.amadeus.resources.Resource;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

public class FlightOfferSearch extends Resource {
  protected FlightOfferSearch() {}

  private @Getter String type;
  private @Getter String id;
  private @Getter String source;
  private @Getter boolean instantTicketingRequired;
  private @Getter boolean nonHomogeneous;
  private @Getter boolean oneWay;
  private @Getter String lastTicketingDate;
  private @Getter int numberOfBookableSeats;
  private @Getter Itinerary[] itineraries;
  private @Getter SearchPrice price;
  private @Getter PricingOptions pricingOptions;
  private @Getter String[] validatingAirlineCodes;
  private @Getter TravelerPricing[] travelerPricings;
  private @Getter String choiceProbability;

  @ToString
  public class Itinerary {
    protected Itinerary() {
    }

    private @Getter String duration;
    private @Getter SearchSegment[] segments;

  }

  @ToString
  public class SearchSegment {
    protected SearchSegment() {
    }

    private @Getter AirportInfo departure;
    private @Getter AirportInfo arrival;
    private @Getter String carrierCode;
    private @Getter String number;
    private @Getter Aircraft aircraft;
    private @Getter String duration;
    private @Getter String id;
    private @Getter int numberOfStops;
    private @Getter boolean blacklistedInEU;
    private @Getter Co2Emissions[] co2Emissions;
  }

  @ToString
  public class Co2Emissions {
    protected Co2Emissions() {
    }

    private @Getter int weight;
    private @Getter String weightUnit;
    private @Getter String cabin;
  }

  @ToString
  public class AirportInfo {
    protected AirportInfo() {
    }

    private @Getter String iataCode;
    private @Getter String terminal;
    private @Getter String at;
  }

  @ToString
  public class Aircraft {
    protected Aircraft() {
    }

    private @Getter String code;
  }

  @ToString
  public static class SearchPrice {
    protected SearchPrice() {
    }

    private @Getter String currency;
    private @Getter String total;
    private @Getter String base;
    private @Getter Fee[] fees;
    private @Getter String grandTotal;
  }

  @ToString
  public class Fee {
    protected Fee() {
    }

    private @Getter double amount;
    private @Getter String type;
  }

  @ToString
  public class PricingOptions {
    private @Getter boolean includedCheckedBagsOnly;
    private @Getter String[] fareType;
    private @Getter String[] corporateCodes;
    private @Getter boolean refundableFare;
    private @Getter boolean noRestrictionFare;
    private @Getter boolean noPenaltyFare;
  }

  @ToString
  public class TravelerPricing {
    protected TravelerPricing() {
    }

    private @Getter String travelerId;
    private @Getter String fareOption;
    private @Getter String travelerType;
    private @Getter SearchPrice price;
    private @Getter FareDetailsBySegment[] fareDetailsBySegment;
  }

  @ToString
  public class FareDetailsBySegment {
    protected FareDetailsBySegment() {
    }

    private @Getter String segmentId;
    private @Getter String cabin;
    private @Getter String fareBasis;
    @SerializedName("class")
    private @Getter String segmentClass;
    private @Getter IncludedCheckedBags includedCheckedBags;

  }

  @ToString
  public class IncludedCheckedBags {
    protected IncludedCheckedBags() {
    }

    private @Getter int weight;
    private @Getter String weightUnit;
  }
 
}

 