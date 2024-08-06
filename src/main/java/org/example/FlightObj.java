package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class FlightObj {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private String departure_date;
    private String departure_time;
    private String arrival_date;
    private String arrival_time;
    private String carrier;
    private Integer stops;
    private Double price;

    public FlightObj(String origin, String origin_name, String destination, String destination_name, String departure_date,
                     String departure_time, String arrival_date, String arrival_time, String carrier, Integer stops, Double price) {
        this.origin = origin;
        this.origin_name = origin_name;
        this.destination = destination;
        this.destination_name = destination_name;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.arrival_date = arrival_date;
        this.arrival_time = arrival_time;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
    }

    public String getCarrier() {
        return carrier;
    }

    public Double getPrice() {
        return price;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getDurationInMinutes() {
        if (departure_date == null || departure_time == null || arrival_date == null || arrival_time == null) {
            return null;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        LocalDateTime departureDateTime = LocalDateTime.parse(departure_date + " " + departure_time, dateTimeFormatter);
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrival_date + " " + arrival_time, dateTimeFormatter);

        long durationInMinutes = ChronoUnit.MINUTES.between(departureDateTime, arrivalDateTime);

        return (int) durationInMinutes;
    }
}
