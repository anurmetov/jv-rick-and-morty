package mate.academy.rickandmorty.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;
import lombok.AllArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharachterDto;
import mate.academy.rickandmorty.mapper.CharachterMapper;
import mate.academy.rickandmorty.repository.CharachterRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacterClient {
    private static final String BASE_URL = "https://rickandmortyapi.com/api/character";
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().build();

    private final CharachterMapper charachterMapper;

    public CharachterDto getRandomCharacter() {
        try {
            Random rand = new Random();
            int randomId = rand.nextInt(0, 826);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(BASE_URL + "/" + randomId))
                    .build();

            HttpResponse<String> response = HTTP_CLIENT.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            CharachterDto charachterDto =
                    objectMapper.readValue(response.body(), CharachterDto.class);
            return charachterDto;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            throw new RuntimeException(e);
        }
    }
}
