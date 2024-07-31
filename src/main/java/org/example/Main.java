package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Parser parser = new Parser();
            String filePath = "src/main/resources/tickets.json";
            List<FlightObj> flights = parser.parse(filePath);

            FlightMathStat stats = new FlightMathStat(flights);
            stats.minDuration();
            stats.getDifferenceBetweenAveragePriceAndMedian();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}