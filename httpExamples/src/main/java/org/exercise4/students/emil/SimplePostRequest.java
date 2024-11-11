import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SimplePostRequest {

    private static final HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        String json = "{\"name\":\"John\",\"job\":\"Developer\"}";
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://reqres.in/api/users"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
