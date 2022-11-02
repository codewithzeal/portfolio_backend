package portfolio_backend.web_server.entity_classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Skills {
    private String idValue;
    private String skillLevel;
    private String skillName;
}
