package portfolio_backend.web_server.entity_classes;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Document(collection = "portfolio")
public class User {
    @Id
    private String username;
    private String password;
    private Boolean isDataPresent=Boolean.FALSE;
    private ArrayList<Education> education=new ArrayList<>();
    private ArrayList<WorkExperience> workExperiences=new ArrayList<>();
    private ArrayList<String> skills=new ArrayList<>();
    private String additionalInfo;
}
