package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Interfaces.ParserInterface;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Parser implements ParserInterface {
    @Override
    public List<FlightObj> parse(String filePath) throws IOException {
        Gson gson = new Gson();
        Type flightListType = new TypeToken<Tickets>() {}.getType();

        try (FileReader reader = new FileReader(filePath)) {
            Tickets tickets = gson.fromJson(reader, flightListType);
            List<FlightObj> allTickets = tickets.getTickets();


            return allTickets.stream()
                    .filter(flight -> "VVO".equals(flight.getOrigin()) && "TLV".equals(flight.getDestination()))
                    .toList();
        }
    }
}
