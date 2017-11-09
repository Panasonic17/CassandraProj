package Convertors;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonConvertorToCSVFromYoutube implements ConvertorFromJsonToCSV {
    static JSONParser parser = new JSONParser();

    public String convert(String json) throws ParseException {
        StringBuilder row = new StringBuilder();
        Object obj = parser.parse(json);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject id = (JSONObject) jsonObject.get("id");
        JSONObject snippet = (JSONObject) jsonObject.get("snippet");
        row.append(id.get("videoId") + ",");
        row.append(snippet.get("publishedAt") + ",");
        row.append(snippet.get("channelId") + ",");
        row.append(snippet.get("title") + ",");
        row.append(snippet.get("description") + ",");
        row.append(snippet.get("channelTitle") + ",");
        return row.toString();
    }
}
