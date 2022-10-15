package portfolio_backend.web_server.controller_classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import portfolio_backend.web_server.entity_classes.UpdateType;
import portfolio_backend.web_server.entity_classes.User;
//import portfolio_backend.web_server.service_classes.HandleFecth;
import portfolio_backend.web_server.service_classes.HandleLogin;
//import portfolio_backend.web_server.service_classes.HandleSignup;
//import portfolio_backend.web_server.service_classes.HandleUpdate;
import portfolio_backend.web_server.service_classes.HandleSignup;
import portfolio_backend.web_server.service_classes.HandleUpdate;

@RestController
public class Handlers {

    @Autowired
    private HandleLogin login;
    @Autowired
    private HandleSignup signup;
    // @Autowired
    // private HandleSignup singup;
    @Autowired
    private HandleUpdate update;
    // @Autowired
    // private HandleFecth fetch;

    @PostMapping(path="/login",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    String checkLogin(@RequestBody User user)
    {
        return login.getLogin(user);
        //return login.getLogin(user);
    }

    @PostMapping(path="/signup",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    String insertUser(@RequestBody User user)
    {
        return signup.signup(user);
    }

    @PostMapping(path="/update",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void handleUpdate(@RequestBody UpdateType updateType)
    {
        update.doUpdate(updateType.getType(),updateType.getUser());
    }
}
