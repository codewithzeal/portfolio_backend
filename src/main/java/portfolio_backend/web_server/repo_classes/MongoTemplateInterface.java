package portfolio_backend.web_server.repo_classes;

import java.util.ArrayList;
import java.util.List;

import portfolio_backend.web_server.entity_classes.Address;
import portfolio_backend.web_server.entity_classes.BasicDetails;
import portfolio_backend.web_server.entity_classes.Education;
import portfolio_backend.web_server.entity_classes.Project;
import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.entity_classes.WorkExperience;

public interface MongoTemplateInterface {
    public String updateWorkExperience(String username,ArrayList<WorkExperience>arr);
    public String updateEducation(String username,ArrayList<Education>arr);
    public String updateSkills(String username,ArrayList<String>arr);
    public String updateAdditionalInfo(String username,String additionalInfo);
    public String updateAddress(String username,Address address);
    public String updateProject(String username,ArrayList<Project>arr);
    public String updateBasicDetail(String username,BasicDetails basicDetails);

    public boolean updateIspresent(String username);
    public boolean checkForUser(String username);
    public boolean checkCredential(String username,String Password);
    
    public List<User> fetchData(String username);
}
