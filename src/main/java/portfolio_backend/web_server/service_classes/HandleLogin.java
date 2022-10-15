package portfolio_backend.web_server.service_classes;


//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.repo_classes.MongoTemplateInterface;

@Service
public class HandleLogin {

    @Autowired
    private MongoTemplateInterface db;
    public String getLogin(User user)
    {
        if(db.checkCredential(user.getUsername(),user.getPassword()))
        return "ok";
        return "nok";
    }
}
