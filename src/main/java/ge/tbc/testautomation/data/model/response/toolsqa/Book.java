package ge.tbc.testautomation.data.model.response.toolsqa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    private String isbn;
    private String title;
    private String subTitle;
    private String author;

    @JsonProperty("publish_date")
    private String publishDate;

    private String publisher;
    private Integer pages;
    private String description;
    private String website;
}
