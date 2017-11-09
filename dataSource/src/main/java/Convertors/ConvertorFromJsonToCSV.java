package Convertors;

import org.json.simple.parser.ParseException;

/**
 * Created by Oleksandr_Shainoga on 11/9/2017.
 */
public interface ConvertorFromJsonToCSV {
    public String convert(String json) throws ParseException;
}
