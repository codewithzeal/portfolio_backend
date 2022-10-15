package portfolio_backend.web_server.service_classes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.repo_classes.MongoTemplateInterface;

@Component
public class HandleFecth {
    @Autowired
    private MongoTemplateInterface db;

    public List<User> getData(String username)
    {
        return db.fetchData(username);
    }
}
