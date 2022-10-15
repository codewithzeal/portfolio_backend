package portfolio_backend.web_server.repo_classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import portfolio_backend.web_server.entity_classes.Education;
import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.entity_classes.WorkExperience;
@Component
public class MongoImpl implements MongoTemplateInterface{

    @Autowired
    MongoTemplate db;
    @Override
    public void updateWorkExperience(String username, ArrayList<WorkExperience> arr) {
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update();
        update.push("education").each(arr);
        db.updateFirst(query, update, User.class);
    }

    @Override
    public void updateEducation(String username, ArrayList<Education> arr) {
        
        
    }

    @Override
    public void updateSkills(String username, ArrayList<String> arr) {
        
        
    }

    @Override
    public void updateIspresent(String username, boolean val) {
        
        
    }

    @Override
    public boolean checkForUser(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        User user=db.findOne(query, User.class);
        if(user!=null)
        return true;
        return false;

    }

    @Override
    public boolean checkCredential(String username, String Password) {
        
        Query query = new Query(Criteria.where("username").is(username).and("password").is(Password));
        User user=db.findOne(query,User.class);
        if(user!=null)
        return true;
        return false;
    }
    
}
