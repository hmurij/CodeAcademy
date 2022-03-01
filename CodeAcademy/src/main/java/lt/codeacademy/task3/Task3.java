package lt.codeacademy.task3;

// Naudodami HttpClient ir GET užklausą iškvieskite šį adresą http://api.population.io:80/1.0/population/2019/Lithuania/.
// Atspausdinkite gautą rezultatą. Galite iš JSON formato gautus duomenis paversti į Java objektus iratspausdinti
// informaciją struktūrizuotai.
// Daugiau šio serviso metodų: http://api.population.io/

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task3 {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        System.out.println(response.body());
    }
}
