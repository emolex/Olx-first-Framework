package BaseClasses.jsonData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser {
    public static void parseJson() {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader("data.json"));
            JSONObject jsonObject = (JSONObject) object;
            UserData.pass = (String) jsonObject.get("pass");
            UserData.email = (String) jsonObject.get("email");
            UserData.browser = (String) jsonObject.get("browser");
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }


    }
}
