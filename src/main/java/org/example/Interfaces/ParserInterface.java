package org.example.Interfaces;



import org.example.FlightObj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ParserInterface {
    public List<FlightObj> parse(String filePath) throws FileNotFoundException, IOException;
}

