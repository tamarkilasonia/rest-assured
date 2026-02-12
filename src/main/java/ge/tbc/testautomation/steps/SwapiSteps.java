package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.api.swapi.SwapiApi;
import ge.tbc.testautomation.data.model.swapi.responses.PlanetProperties;

import java.util.Comparator;
import java.util.List;

public class SwapiSteps {

    private final SwapiApi api = new SwapiApi();

    public List<PlanetProperties> getAllFirst10Planets() {
        var list = api.getPlanetsList();

        return list.results().stream()
                .map(item -> api.getPlanetDetails(item.url())
                        .result()
                        .properties())
                .toList();
    }

    public List<PlanetProperties> getTop3MostRecent() {
        return getAllFirst10Planets().stream()
                .filter(p -> p.timestamp() != null)
                .sorted(Comparator.comparing(PlanetProperties::timestamp).reversed())
                .limit(3)
                .toList();
    }

    public PlanetProperties getTopRotationPlanet() {
        return getAllFirst10Planets().stream()
                .filter(p -> isNumeric(p.rotationPeriod()))
                .max(Comparator.comparingInt(p -> Integer.parseInt(p.rotationPeriod())))
                .orElseThrow(() -> new RuntimeException("No numeric rotation_period found"));
    }

    private boolean isNumeric(String s) {
        return s != null && s.matches("\\d+");
    }
}
