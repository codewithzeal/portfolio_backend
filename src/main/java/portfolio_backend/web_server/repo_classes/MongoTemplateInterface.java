package portfolio_backend.web_server.repo_classes;

import java.util.ArrayList;

import portfolio_backend.web_server.entity_classes.Education;
import portfolio_backend.web_server.entity_classes.WorkExperience;

public interface MongoTemplateInterface {
    public void updateWorkExperience(String username,ArrayList<WorkExperience>arr);
    public void updateEducation(String username,ArrayList<Education>arr);
    public void updateSkills(String username,ArrayList<String>arr);
    public void updateIspresent(String username,boolean val);
    public boolean checkForUser(String username);
    public boolean checkCredential(String username,String Password);
}
