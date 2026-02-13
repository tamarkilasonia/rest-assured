package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.api.client.ToolsQaBookStoreApi;
import ge.tbc.testautomation.data.model.response.toolsqa.Book;
import ge.tbc.testautomation.data.model.response.toolsqa.BooksResponse;

import io.restassured.response.Response;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ToolsQaSteps {

    private final ToolsQaBookStoreApi api = new ToolsQaBookStoreApi();

    public BooksResponse getBooks() {
        Response res = api.getBooks()
                .then().statusCode(200)
                .extract().response();

        BooksResponse br = res.as(BooksResponse.class);
        assertThat(br.getBooks(), is(not(empty())));
        return br;
    }

    public void validateAllPagesLessThan1000(BooksResponse response) {
        boolean ok = response.getBooks().stream()
                .allMatch(b -> b.getPages() != null && b.getPages() < 1000);

        assertThat("Some book has pages >= 1000", ok, is(true));
    }

    public void validateLastTwoAuthors(BooksResponse response, String expectedSecondLast, String expectedLast) {
        List<Book> books = response.getBooks();
        assertThat(books.size(), greaterThanOrEqualTo(2));

        String secondLast = books.get(books.size() - 2).getAuthor();
        String last = books.get(books.size() - 1).getAuthor();

        assertThat(secondLast, equalTo(expectedSecondLast));
        assertThat(last, equalTo(expectedLast));
    }
}
