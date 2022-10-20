package portfolio_backend.web_server.entity_classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class WorkExperience {
    
    private String idValue;
    private  String organization;
    private String position;
    private String startDate;
    private String endDate;

}
