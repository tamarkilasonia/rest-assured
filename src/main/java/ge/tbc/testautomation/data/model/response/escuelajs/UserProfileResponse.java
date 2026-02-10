package ge.tbc.testautomation.data.model.response.escuelajs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileResponse {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String role;
    private String avatar;
}
