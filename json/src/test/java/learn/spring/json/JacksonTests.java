package learn.spring.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import learn.spring.json.domain.Book;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JacksonTests {
    @Test
    public void testThatObjectMapperCanCreatedJsonFromJavaObject() throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = Book.builder()
                .isbn("978-0-13-478627-5")
                .title("The Enigma of Eternity")
                .author("Aria Montgomery")
                .yearPublished("2005")
                .build();
        String result = objectMapper.writeValueAsString(book);
        assertThat(result)
                .isEqualTo(
                        "{\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria"
                                + " Montgomery\",\"year\":\"2005\"}"
                );
    }
    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJsonObject() throws JsonProcessingException{
        Book book = Book.builder()
                .isbn("978-0-13-478627-5")
                .title("The Enigma of Eternity")
                .author("Aria Montgomery")
                .yearPublished("2005")
                .build();
        String json =
                "{\"test\":\"test\",\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of"
                        + " Eternity\",\"author\":\"Aria Montgomery\",\"year\":\"2005\"}";
        final ObjectMapper objectMapper = new ObjectMapper();
        Book result = objectMapper.readValue(json, Book.class);
        assertThat(result).isEqualTo(book);
    }
}
