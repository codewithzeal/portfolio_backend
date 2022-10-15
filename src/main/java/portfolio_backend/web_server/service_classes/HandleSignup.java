package portfolio_backend.web_server.service_classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.repo_classes.MongoTemplateInterface;
import portfolio_backend.web_server.repo_classes.PostRepo;
@Component
public class HandleSignup {
    @Autowired
    private MongoTemplateInterface db;
    @Autowired
    private PostRepo obj;
    public String signup(User user)
    {
        if(db.checkForUser(user.getUsername()))
        return "ae";
        else
        {
            obj.save(user);
            return "ok";
        }
    }


}
