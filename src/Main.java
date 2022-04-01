import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class Main {
    public static void main(String[] args) {

        String language = "en";
        String apikey = System.getenv("IMDB_APIKEY");
        URI apiURL = URI.create("https://imdb-api.com/" + language + "/API/Top250Movies/" + apikey);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(apiURL)
                .header("Content-type", "application/json")
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

    }
}
