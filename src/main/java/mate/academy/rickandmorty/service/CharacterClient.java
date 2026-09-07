package mate.academy.rickandmorty.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.PageDto;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.repository.CharacterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterClient implements CommandLineRunner {
    private static final String BASE_URL = "https://rickandmortyapi.com/api/character";
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().build();

    private final CharacterMapper characterMapper;
    private final CharacterRepository characterRepository;

    @Override
    public void run(String... args) throws Exception {
        loadAllCharactersToDB();
    }

    private void loadAllCharactersToDB() {
        try {
            HttpRequest httpRequest = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(new URI(BASE_URL))
                    .build();

            HttpResponse<String> response = HTTP_CLIENT
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            PageDto pageDto = objectMapper
                    .readValue(response.body(), PageDto.class);
            int numberOfPages = pageDto.info().getPages();

            System.out.println("Loading Data "
                    + "with 1s delay pro page (about 20s) to load all the data to DB:...");
            for (int i = 1; i <= numberOfPages; i++) {
                Thread.sleep(500);
                HttpRequest pageRequest = HttpRequest
                        .newBuilder()
                        .GET()
                        .uri(new URI(BASE_URL + "/?page=" + i))
                        .build();

                HttpResponse<String> pageResponse = HTTP_CLIENT
                        .send(pageRequest, HttpResponse.BodyHandlers.ofString());
                PageDto page = objectMapper.readValue(pageResponse.body(), PageDto.class);
                page.results().stream().map(characterMapper::toEntity)
                        .forEach(characterRepository::save);

                System.out.println("Data from 'Rick and Morty' API at Page "
                        + i + " has been successfully loaded to DB.");

            }
            System.out.println("Data was completely loaded to DB. Element in DB: "
                    + pageDto.info().getCount());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            throw new RuntimeException(e);
        }
    }

}
