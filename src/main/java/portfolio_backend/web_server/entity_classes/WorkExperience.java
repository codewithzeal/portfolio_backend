package portfolio_backend.web_server.entity_classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class WorkExperience {
    
    private  String organization;
    private String postition;
    private String startDate;
    private String endDate;

}
