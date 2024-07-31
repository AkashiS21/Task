package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class FlightMathStat {
    List<FlightObj> flightObjList ;
    public FlightMathStat(List<FlightObj> flightObjList) {
        this.flightObjList = flightObjList;
    }
    public void minDuration(){
        Map<String, List<FlightObj>> flightsByCarrier = flightObjList
                .stream()
                .collect(Collectors.groupingBy(FlightObj::getCarrier));

        System.out.println("Минимальная время полёта для каждого перевозчика:");

        for (Map.Entry<String, List<FlightObj>> entry : flightsByCarrier.entrySet()) {
            String carrier = entry.getKey();
            List<FlightObj> flights = entry.getValue();

            Integer min = flights.stream()
                    .map(FlightObj::getDurationInMinutes)
                    .min(Integer::compareTo)
                    .orElse(null);

            System.out.println("Перевозчик: " + carrier + ", Минимальная время: " + min + " минут");
        }
    }
    public void getDifferenceBetweenAveragePriceAndMedian() {
        List<Double> prices = flightObjList.stream()
                .map(FlightObj::getPrice)
                .sorted()
                .toList();

        if (prices.isEmpty()) {
            System.out.println("Нет данных для расчета.");
            return;
        }

        OptionalDouble average = prices.stream()
                .mapToDouble(Double::doubleValue)
                .average();

        double avgPrice = average.orElse(0.0);
        double medianPrice;
        int size = prices.size();

        if (size % 2 == 1) {
            medianPrice = prices.get(size / 2);
        } else {
            medianPrice = (prices.get(size / 2 - 1) + prices.get(size / 2)) / 2.0;
        }

        double priceDifference = avgPrice - medianPrice;

        System.out.printf("Разница между средней ценой и медианной ценой рейсов из Владивостока в Тель-Авив: %.2f%n", priceDifference);
    }
}
