package portfolio_backend.web_server.entity_classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Education {

  private String institute;
    private String stream;
    private String startDate;
    private String endDate;
    private String cgpa;

}
