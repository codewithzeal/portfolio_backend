package portfolio_backend.web_server.service_classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import portfolio_backend.web_server.repo_classes.MongoTemplateInterface;

@Component
public class HandleVerifyUserName {
    @Autowired
    private MongoTemplateInterface db;

    public String Verify(String Username)
    {
        if(db.checkForUser(Username))
        return "nok";
        return "ok";
    }
}
