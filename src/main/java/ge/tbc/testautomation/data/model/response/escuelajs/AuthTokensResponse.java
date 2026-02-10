package ge.tbc.testautomation.data.model.response.escuelajs;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthTokensResponse {

    private String access_token;
    private String refresh_token;
}
