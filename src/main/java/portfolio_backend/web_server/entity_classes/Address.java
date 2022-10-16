package portfolio_backend.web_server.entity_classes;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class Address {
    private String adrline1;
    private String city;
    private String state;
    private String pinCode;
    private String country;
}
