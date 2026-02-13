package ge.tbc.testautomation.api.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public abstract class BaseApi {

    public static final RequestSpecification ESCUELA_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://api.escuelajs.co")
            .setBasePath("/api")
            .setContentType("application/json")
            .log(LogDetail.ALL)
            .build()
            .filters(new ResponseLoggingFilter());

    public static final RequestSpecification BOOKER_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://restful-booker.herokuapp.com")
            .setContentType("application/json")
            .log(LogDetail.ALL)
            .build()
            .filters(new ResponseLoggingFilter());

    public static final RequestSpecification TOOLSQA_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://bookstore.toolsqa.com")
            .setContentType("application/json")
            .log(LogDetail.ALL)
            .build()
            .filters(new ResponseLoggingFilter());
}
