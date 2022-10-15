package portfolio_backend.web_server.service_classes;


import org.springframework.stereotype.Service;

import portfolio_backend.web_server.entity_classes.User;

@Service
public class HandleLogin {
    public String getLogin(User user)
    {
        System.out.println("here "+user.getPassword()+" "+user.getUsername());
        if(user.getUsername().equals("naman")&&user.getPassword().equals("naman"))
        return "ok";
        else
        return "nok";
    }
}
