package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.api.swapi.SwapiApi;
import ge.tbc.testautomation.config.BaseTest;
import ge.tbc.testautomation.data.model.swapi.responses.PlanetProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class SwapiTests extends BaseTest {

    @Test
    public void swapi_first10_top3MostRecent_and_topRotationPeriod() {

        SwapiApi api = new SwapiApi();


        var list = api.getPlanetsList();

        Assert.assertNotNull(list);
        Assert.assertNotNull(list.results());
        Assert.assertEquals(list.results().size(), 10);


        List<PlanetProperties> planets = list.results().stream()
                .map(item -> api.getPlanetDetails(item.url()).result().properties())
                .toList();

        Assert.assertEquals(planets.size(), 10);


        List<PlanetProperties> top3Recent = planets.stream()
                .filter(p -> p.timestamp() != null)
                .sorted(Comparator.comparing(PlanetProperties::timestamp).reversed())
                .limit(3)
                .toList();

        Assert.assertEquals(top3Recent.size(), 3);

        PlanetProperties newest = top3Recent.get(0);


        Assert.assertNotNull(newest.name());
        Assert.assertFalse(newest.name().isBlank());
        Assert.assertNotNull(newest.timestamp());
        Assert.assertNotNull(newest.rotationPeriod());
        Assert.assertNotNull(newest.climate());
        Assert.assertNotNull(newest.terrain());
        Assert.assertNotNull(newest.population());


        PlanetProperties topRotation = planets.stream()
                .filter(p -> isNumeric(p.rotationPeriod()))
                .max(Comparator.comparingInt(p -> Integer.parseInt(p.rotationPeriod())))
                .orElseThrow(() -> new AssertionError("No planet with numeric rotation_period found in first 10"));

        Assert.assertNotNull(topRotation.name());
        Assert.assertTrue(Integer.parseInt(topRotation.rotationPeriod()) > 0);
        Assert.assertNotNull(topRotation.timestamp());
        Assert.assertNotNull(topRotation.climate());
    }

    private boolean isNumeric(String s) {
        return s != null && s.matches("\\d+");
    }
}

