package portfolio_backend.web_server.controller_classes;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import portfolio_backend.web_server.entity_classes.UpdateType;
import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.service_classes.HandleFecth;
//import portfolio_backend.web_server.service_classes.HandleFecth;
import portfolio_backend.web_server.service_classes.HandleLogin;
//import portfolio_backend.web_server.service_classes.HandleSignup;
//import portfolio_backend.web_server.service_classes.HandleUpdate;
import portfolio_backend.web_server.service_classes.HandleSignup;
import portfolio_backend.web_server.service_classes.HandleUpdate;
import portfolio_backend.web_server.service_classes.HandleVerifyUserName;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Handlers {

    @Autowired
    private HandleLogin login;
    @Autowired
    private HandleSignup signup;
    @Autowired
    private HandleUpdate update;
    @Autowired
    private HandleFecth fetch;
    @Autowired
    private HandleVerifyUserName verify;

    @PostMapping(path="/login",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    String checkLogin(@RequestBody User user,HttpSession obj)
    {
        //System.out.println(obj.getId());
        String val=login.getLogin(user);
        if(val=="ok")
        return obj.getId();
        return "nok";
        //return login.getLogin(user);
    }

    @PostMapping(path="/checkSession")
    String checkSession(HttpSession obj)
    {
        System.out.println(obj.getMaxInactiveInterval());
        return "ok";
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
        update.doUpdate(updateType.getType(),updateType.getUserToUpdate());
    }

    @PostMapping(path="/fetch/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> fetchUser(@PathVariable String username)
    {
        return fetch.getData(username);
    }

    @PostMapping(path="/verify",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    String verifyUserName(@RequestBody User user)
    {
        return verify.Verify(user.getUsername());
    }
}
