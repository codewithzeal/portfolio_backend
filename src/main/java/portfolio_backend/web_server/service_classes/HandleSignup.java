package portfolio_backend.web_server.service_classes;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.repo_classes.MongoTemplateInterface;
import portfolio_backend.web_server.repo_classes.PostRepo;
import portfolio_backend.web_server.utilities.HashGenerator;
@Component
public class HandleSignup {
    @Autowired
    private MongoTemplateInterface db;
    @Autowired
    private PostRepo obj;
    @Autowired 
    private HashGenerator hash;
    public String signup(User user) throws NoSuchAlgorithmException
    {
        if(db.checkForUser(user.getUsername()))
        return "ae";
        else
        {
            user.setUid(hash.createMD5Hash(user.getUsername()));
            obj.save(user);
            return "ok";
        }
    }


}
