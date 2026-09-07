package mate.academy.rickandmorty.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharachterDto;
import mate.academy.rickandmorty.dto.external.PageDto;
import mate.academy.rickandmorty.mapper.CharachterMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbInit implements CommandLineRunner {
    private static final String BASE_URL = "https://rickandmortyapi.com/api/character";
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().build();

    private CharachterRepository charachterRepository;
    private final CharachterMapper charachterMapper;

    @Override
    public void run(String... args) throws Exception {

    }
}
