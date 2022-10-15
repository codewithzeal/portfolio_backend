package portfolio_backend.web_server.repo_classes;

import org.springframework.data.mongodb.repository.MongoRepository;

import portfolio_backend.web_server.entity_classes.User;

public interface PostRepo extends MongoRepository<User,Integer> {
    
}
