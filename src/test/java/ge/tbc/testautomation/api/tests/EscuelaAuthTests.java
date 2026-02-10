package ge.tbc.testautomation.api.tests;

import ge.tbc.testautomation.data.model.request.escuelajs.LoginRequest;
import ge.tbc.testautomation.data.model.request.escuelajs.UserCreateRequest;
import ge.tbc.testautomation.data.model.response.escuelajs.AuthTokensResponse;
import ge.tbc.testautomation.data.model.response.escuelajs.UserProfileResponse;
import ge.tbc.testautomation.steps.EscuelaSteps;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EscuelaAuthTests {

    private final EscuelaSteps steps = new EscuelaSteps();

    @Test
    public void testCreateUser_Login_Profile() {

        UserCreateRequest user = new UserCreateRequest(
                "Tamar",
                "tamar" + System.currentTimeMillis() + "@mail.com",
                "123456",
                "https://i.pravatar.cc/150"
        );

        steps.createUser(user);

        AuthTokensResponse tokens = steps.login(new LoginRequest(user.getEmail(), user.getPassword()));
        assertThat(tokens.getAccess_token(), notNullValue());
        assertThat(tokens.getRefresh_token(), notNullValue());

        UserProfileResponse profile = steps.profile(tokens.getAccess_token());
        assertThat(profile.getEmail(), equalTo(user.getEmail()));
        assertThat(profile.getName(), equalTo(user.getName()));
    }
}
