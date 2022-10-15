package portfolio_backend.web_server.service_classes;

import org.springframework.beans.factory.annotation.Autowired;

import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.repo_classes.MongoTemplateInterface;

public class HandleUpdate {
    @Autowired
    private MongoTemplateInterface db;

    public void doUpdate(String type,User user)
    {
        if(type=="we"&&db.checkForUser(user.getUsername()))
        db.updateWorkExperience(user.getUsername(),user.getWorkExperiences());

    }
}
