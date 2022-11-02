package portfolio_backend.web_server.repo_classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import portfolio_backend.web_server.entity_classes.Address;
import portfolio_backend.web_server.entity_classes.BasicDetails;
import portfolio_backend.web_server.entity_classes.Education;
import portfolio_backend.web_server.entity_classes.Project;
import portfolio_backend.web_server.entity_classes.Skills;
import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.entity_classes.WorkExperience;
@Component
public class MongoImpl implements MongoTemplateInterface{

    @Autowired
    MongoTemplate db;
    @Override
    public String updateWorkExperience(String username, ArrayList<WorkExperience> arr) {
        if(arr.get(0).getIdValue()==null)
        {
            System.out.println("here here here here 0");
            arr.get(0).setIdValue(username+System.currentTimeMillis());
            Query query = new Query(Criteria.where("username").is(username));
            Update update = new Update();
            update.push("workExperiences").each(arr);
            db.updateFirst(query, update, User.class);
            return "ok";
        }
        else
        {
            System.out.println("here here here here");
            String id=arr.get(0).getIdValue();
            Query query = new Query(Criteria.where("username").is(username).and("workExperiences.idValue").is(id));
            Update update=new Update();
            update.set("workExperiences.$", arr.get(0));
            db.findAndModify(query, update, User.class);
            return "ok";
        }
    }

    @Override
    public String updateEducation(String username, ArrayList<Education> arr) {
        if(arr.get(0).getIdValue()==null)
        {
            System.out.println("here here here here 0");
            arr.get(0).setIdValue(username+System.currentTimeMillis());
            Query query = new Query(Criteria.where("username").is(username));
            Update update = new Update();
            update.push("education").each(arr);
            db.updateFirst(query, update, User.class);
            return "ok";
        }
        else
        {
            System.out.println("here here here here");
            String id=arr.get(0).getIdValue();
            Query query = new Query(Criteria.where("username").is(username).and("education.idValue").is(id));
            Update update=new Update();
            update.set("education.$", arr.get(0));
            db.findAndModify(query, update, User.class);
            return "ok";
        }
    }

    @Override
    public String updateSkills(String username, ArrayList<Skills> arr) {
        if(arr.get(0).getIdValue()==null)
        {
            System.out.println("here here here here 0");
            for(int i=0;i<arr.size();i++)
            {
                String val=username+System.currentTimeMillis()+i;
                arr.get(i).setIdValue(val);
            }
            Query query = new Query(Criteria.where("username").is(username));
            Update update = new Update();
            update.push("skills").each(arr);
            db.updateFirst(query, update, User.class);
            return arr.toString();
        }
        return "nok";
    }

    @Override
    public boolean updateIspresent(String username) {
        
        Query query = new Query(Criteria.where("username").is(username).and("isDataPresent").is(true));
        User user=db.findOne(query,User.class);
        if(user!=null)
        return true;
        return false;
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

    @Override
    public String updateAdditionalInfo(String username, String additionalInfo) {
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update();
        update.set("additionalInfo", additionalInfo);
        db.updateFirst(query, update, User.class);
        return "ok";
        
    }

    @Override
    public List<User> fetchData(String username) {
       if(checkForUser(username))
       {
        Query query = new Query(Criteria.where("username").is(username));   
        query.fields().exclude("password");
        return db.find(query, User.class);
       }
       return null;
    }

    @Override
    public String updateAddress(String username, Address address) {
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update();
        update.set("address", address);
        db.updateFirst(query, update, User.class);
        return "ok";
    }

    @Override
    public String updateProject(String username, ArrayList<Project> arr) {
        if(arr.get(0).getIdValue()==null)
        {
            System.out.println("here here here here 0");
            arr.get(0).setIdValue(username+System.currentTimeMillis());
            Query query = new Query(Criteria.where("username").is(username));
            Update update = new Update();
            update.push("projects").each(arr);
            db.updateFirst(query, update, User.class);
            return "ok";
        }
        else
        {
            System.out.println("here here here here");
            String id=arr.get(0).getIdValue();
            Query query = new Query(Criteria.where("username").is(username).and("projects.idValue").is(id));
            Update update=new Update();
            update.set("projects.$", arr.get(0));
            db.findAndModify(query, update, User.class);
            return "ok";
        }
        
    }

    @Override
    public String updateBasicDetail(String username, BasicDetails basicDetails) {
        
        Query query = new Query(Criteria.where("username").is(username));
        Update update = new Update();
        update.set("basicDetails",basicDetails);
        db.updateFirst(query, update, User.class);
        return "ok";
    }

    @Override
    public String deleteSkills(String username, ArrayList<Skills>arr) {
        Query query = new Query(Criteria.where("username").is(username).and("skills.idValue").is(arr.get(0).getIdValue()));
        Update update = new Update();
        update.pull("skills", arr.get(0));
        db.findAndModify(query, update, User.class);
        return "ok";
    }

    @Override
    public List<User> fetchDataByID(String id) {
        Query query = new Query(Criteria.where("uid").is(id));   
        query.fields().exclude("password");
        return db.find(query, User.class);
    }

    @Override
    public String fetchUid(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        User user=db.findOne(query,User.class);
        if(user!=null)
        return user.getUid();
        return null;
    }
    
}
