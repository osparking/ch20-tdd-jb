package space.bum.junit.tdd.airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class Flight {
  private String id;
  private List<Passenger> passengers = new ArrayList<>();;
  private String flightType;

  public Flight(String id, String flightType) {
    super();
    this.id = id;
    this.flightType = flightType;
  }

  public List<Passenger> getPassengerList() {
    return Collections.unmodifiableList(passengers);
  }

  public boolean addPassenger(Passenger passenger) {
    switch (flightType) {
    case "Economy":
      return passengers.add(passenger);
    case "Business":
      if (passenger.isVip()) {
        return passengers.add(passenger);
      } else {
        return false;
      }
    default:
      throw new RuntimeException("이상한 항공편 형태");
    }
  }
}
