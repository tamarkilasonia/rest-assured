package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.api.client.EscuelaAuthApi;
import ge.tbc.testautomation.api.client.EscuelaUsersApi;

import ge.tbc.testautomation.data.model.request.escuelajs.LoginRequest;
import ge.tbc.testautomation.data.model.request.escuelajs.UserCreateRequest;

import ge.tbc.testautomation.data.model.response.escuelajs.AuthTokensResponse;
import ge.tbc.testautomation.data.model.response.escuelajs.UserProfileResponse;

import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EscuelaSteps {

    private final EscuelaUsersApi usersApi = new EscuelaUsersApi();
    private final EscuelaAuthApi authApi = new EscuelaAuthApi();

    public void createUser(UserCreateRequest request) {
        usersApi.createUser(request)
                .then()
                .statusCode(anyOf(is(201), is(200)));
    }

    public AuthTokensResponse login(LoginRequest request) {
        Response res = authApi.login(request)
                .then()
                .statusCode(201)
                .extract()
                .response();

        AuthTokensResponse tokens = res.as(AuthTokensResponse.class);

        assertThat(tokens.getAccess_token(), notNullValue());
        assertThat(tokens.getRefresh_token(), notNullValue());

        return tokens;
    }

    public UserProfileResponse profile(String accessToken) {
        Response res = authApi.profile(accessToken)
                .then()
                .statusCode(200)
                .extract()
                .response();

        return res.as(UserProfileResponse.class);
    }
}
