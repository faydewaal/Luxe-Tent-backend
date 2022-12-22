package nl.novi.luxetent.models;

import nl.novi.luxetent.repositories.TentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TentTest {
    private Tent tentTest;

    @Autowired
    private TentRepository tentRepository;

    @BeforeEach
    void tearDown() {
        tentTest = new Tent();
    }

    @Test
    void test_GettersAndSetters() {
        tentTest.setTitle("title");
        assertEquals("title", tentTest.getTitle());
    }

    @Test
    void test_SaveToDatabase() {
        tentTest.setId(50L);
        tentTest.setTitle("Luxe Tent");
        tentTest.setDescription("Welkom bij de luxe tent");
        tentTest.setPricePerNight(99);
        tentTest.setMaxNumberOfPersons(2);
        tentTest.setStreet("Molenstraat");
        tentTest.setHouseNumber("4a");
        tentTest.setCity("Breda");
        tentTest.setProvince("Noord-Brabant");
        tentRepository.save(tentTest);

        java.util.Optional<Tent> maybeTent = tentRepository.findById(50L);

        if (maybeTent.isPresent()) {
        }
        Tent databaseTent = tentRepository.findById(50L).get();
        assertNotNull(databaseTent);
        assertEquals("Luxe Tent", databaseTent.getTitle());
    }

    @Test
    public void test_Read() {
        Tent tentFromRepository = tentRepository.findById(50L).get();
        assertEquals("Luxe Tent", tentFromRepository.getTitle());
    }

    @Test
    public void test_ReadAll() {
        List<Tent> tentList = tentRepository.findAll();
        assertThat("At least one disc in database", tentList.size() > 0);
    }
}