package portfolio_backend.web_server.repo_classes;

import java.util.ArrayList;
import java.util.List;

import portfolio_backend.web_server.entity_classes.Education;
import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.entity_classes.WorkExperience;

public interface MongoTemplateInterface {
    public void updateWorkExperience(String username,ArrayList<WorkExperience>arr);
    public void updateEducation(String username,ArrayList<Education>arr);
    public void updateSkills(String username,ArrayList<String>arr);
    public boolean updateIspresent(String username);
    public boolean checkForUser(String username);
    public boolean checkCredential(String username,String Password);
    public void updateAdditionalInfo(String username,String additionalInfo);
    public List<User> fetchData(String username);
}
