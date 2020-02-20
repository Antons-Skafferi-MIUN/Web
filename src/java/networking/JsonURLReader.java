package networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JsonURLReader {

    public String readJsonFromURL(String URLString) {
        StringBuilder JsonResponse = new StringBuilder("");

        try {
            URL url = new URL(URLString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            JsonResponse.append(new Scanner(inputStream, "UTF-8")
                    .useDelimiter("\\Z").next());
        } catch (IOException ex) {
        }
        return JsonResponse.toString();
    }
}
