package ge.tbc.testautomation.api.tests;

import ge.tbc.testautomation.data.model.response.toolsqa.BooksResponse;
import ge.tbc.testautomation.steps.ToolsQaSteps;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ToolsQaBooksTests {

    private final ToolsQaSteps steps = new ToolsQaSteps();

    @Test
    public void testBooksPagesLessThan1000_and_LastTwoAuthors() {

        BooksResponse response = steps.getBooks();

        boolean allLessThan1000 = response.getBooks().stream()
                .allMatch(b -> b.getPages() != null && b.getPages() < 1000);

        assertThat(allLessThan1000, is(true));

        int size = response.getBooks().size();
        assertThat(size, greaterThanOrEqualTo(2));

        String secondLastAuthor = response.getBooks().get(size - 2).getAuthor();
        String lastAuthor = response.getBooks().get(size - 1).getAuthor();

        assertThat(secondLastAuthor, equalTo("Marijn Haverbeke"));
        assertThat(lastAuthor, equalTo("Nicholas C. Zakas"));
    }
}
