package portfolio_backend.web_server.service_classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.repo_classes.MongoTemplateInterface;
@Component
public class HandleUpdate {
    @Autowired
    private MongoTemplateInterface db;

    public void doUpdate(String type,User user)
    {
        if(type.equals("we")&&db.checkForUser(user.getUsername()))
        db.updateWorkExperience(user.getUsername(),user.getWorkExperiences());
        else if(type.equals("edu")&&db.checkForUser(user.getUsername()))
        db.updateEducation(user.getUsername(), user.getEducation());
        else if(type.equals("skills")&&db.checkForUser(user.getUsername()))
        db.updateSkills(user.getUsername(),user.getSkills());
        else if(type.equals("ai")&&db.checkForUser(user.getUsername()))
        db.updateAdditionalInfo(user.getUsername(), user.getAdditionalInfo());
        else if(type.equals("projects")&&db.checkForUser(user.getUsername()))
        db.updateProject(user.getUsername(),user.getProjects());
        else if(type.equals("address")&&db.checkForUser(user.getUsername()))
        db.updateAddress(user.getUsername(),user.getAddress());

    }
}
