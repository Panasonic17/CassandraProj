import com.satori.rtm.model.AnyJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonConventorToCsv {
    static JSONParser parser = new JSONParser();

    public static String convert(String json) throws ParseException {
        StringBuilder row = new StringBuilder();
        Object obj = parser.parse(json);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject stat = (JSONObject) jsonObject.get("statistics");
        JSONObject snippet = (JSONObject) jsonObject.get("snippet");
        String description = snippet.get("description").toString().trim().replace("\n", "");
//        System.out.println(description);
        row.append(jsonObject.get("id") + ",");
        row.append(stat.get("like_count") + ",");
        row.append(stat.get("dislike_count") + ",");
        row.append(stat.get("view_count") + ",");
        row.append(snippet.get("published_at") + ",");
        row.append(snippet.get("title").toString().trim().replace("\n", "") + ",");
        row.append(description + ",");
        row.append(snippet.get("channel_title") + ",");
        row.append(snippet.get("tags"));

        return row.toString();
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(convert("{\"id\":\"mYBCyPMI7rM\",\"snippet\":{\"published_at\":\"Jul 6, 2016\",\"title\":\"\n    Top 5 Prostitution Facts\n  \",\"description\":\"It's probably not actually the oldest profession–our money is on hunter-gatherer for that– but it might be close. Welcome to WatchMojo's Top 5 facts where we count down five random facts about a fascinating subject. Suggestion Tool►►http://www.WatchMojo.com/suggest Subscribe►►http://www.youtube.com/subscription_c... Facebook►►http://www.Facebook.com/WatchMojo Twitter►►http://www.Twitter.com/WatchMojo Instagram►►http://instagram.com/watchmojo Channel Page►►http://www.youtube.com/watchmojoSince almost all the research we found on the subject looked at the situations of female prostitutes engaged by men, that's what these facts focus on.Special thanks to our users christo or submitting the idea using our interactive suggestion tool at http://www.WatchMojo.com/suggest Want a WatchMojo cup, mug, t-shirts, pen, sticker and even a water bottle?  Get them all when you order your MojoBox gift set here:http://watchmojo.com/store/WatchMojo is a leading producer of reference online video content, covering the People, Places and Trends you care about.We update DAILY with 4-5 Top 10 lists, Origins, Biographies, Versus clips on movies, video games, music, pop culture and more!\",\"channel_title\":\"WatchMojo.com\",\"tags\":[\"News & Politics\"]},\"statistics\":{\"view_count\":\"1335674\",\"like_count\":\"8990\",\"dislike_count\":\"626\"}}\n"));
    }
}
