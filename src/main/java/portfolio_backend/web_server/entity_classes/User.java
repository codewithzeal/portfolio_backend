package portfolio_backend.web_server.entity_classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
class WorkExperience
{
    private  String organization;
    private String postition;
    private String startDate;
    private String endDate;

}
@Getter
@Setter
@ToString
class Education
{
    private String institute;
    private String stream;
    private String startDate;
    private String endDate;
    private String cgpa;
}


@Getter
@Setter
@ToString
class Skills
{
    private String skills;
}


@Getter
@Setter
@ToString
public class User {
    private String username;
    private String password;
    private Education education;
    private WorkExperience workExperience;
    private Skills skills;
    private String additionalInfo;
}
