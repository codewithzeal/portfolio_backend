package portfolio_backend.web_server.service_classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.repo_classes.MongoTemplateInterface;
@Component
public class HandleUpdate {
    @Autowired
    private MongoTemplateInterface db;

    public String doUpdate(String type,User user)
    {
        if(type.equals("we")&&db.checkForUser(user.getUsername()))
        return db.updateWorkExperience(user.getUsername(),user.getWorkExperiences());
        else if(type.equals("edu")&&db.checkForUser(user.getUsername()))
        return  db.updateEducation(user.getUsername(), user.getEducation());
        else if(type.equals("skills")&&db.checkForUser(user.getUsername()))
        return  db.updateSkills(user.getUsername(),user.getSkills());
        else if(type.equals("ai")&&db.checkForUser(user.getUsername()))
        return  db.updateAdditionalInfo(user.getUsername(), user.getAdditionalInfo());
        else if(type.equals("projects")&&db.checkForUser(user.getUsername()))
        return  db.updateProject(user.getUsername(),user.getProjects());
        else if(type.equals("address")&&db.checkForUser(user.getUsername()))
        return  db.updateAddress(user.getUsername(),user.getAddress());
        else if(type.equals("basic")&&db.checkForUser(user.getUsername()))
        return  db.updateBasicDetail(user.getUsername(), user.getBasicDetails());
        else if(type.equals("dellskill")&&db.checkForUser(user.getUsername()))
        return  db.deleteSkills(user.getUsername(), user.getSkills());
        return "";
    }
}
