package portfolio_backend.web_server.entity_classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Project {
    private String idValue;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private String url;
}
