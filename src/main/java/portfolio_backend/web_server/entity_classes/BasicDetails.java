package portfolio_backend.web_server.entity_classes;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BasicDetails {
    private String fullName;
    private String contact;
    private String linkedInUrl;
    private String gender;
    private String email;
}
