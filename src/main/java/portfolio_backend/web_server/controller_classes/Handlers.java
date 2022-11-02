package portfolio_backend.web_server.controller_classes;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import portfolio_backend.web_server.entity_classes.UpdateType;
import portfolio_backend.web_server.entity_classes.User;
import portfolio_backend.web_server.service_classes.HandleFecth;
//import portfolio_backend.web_server.service_classes.HandleFecth;
import portfolio_backend.web_server.service_classes.HandleLogin;
//import portfolio_backend.web_server.service_classes.HandleSignup;
//import portfolio_backend.web_server.service_classes.HandleUpdate;
import portfolio_backend.web_server.service_classes.HandleSignup;
import portfolio_backend.web_server.service_classes.HandleUpdate;
import portfolio_backend.web_server.service_classes.HandleVerifyUserName;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Handlers {

    @Autowired
    private HandleLogin login;
    @Autowired
    private HandleSignup signup;
    @Autowired
    private HandleUpdate update;
    @Autowired
    private HandleFecth fetch;
    @Autowired
    private HandleVerifyUserName verify;

    private  Map<String,String> map=new HashMap<String,String>();  
    private  Map<String,Long> maptime=new HashMap<String,Long>();
    @PostMapping(path="/login",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    List<String> checkLogin(@RequestBody User user,HttpSession obj)
    {
        //System.out.println(obj.getId());
        List <String>arr=new ArrayList<String>();
        String val=login.getLogin(user);
        if(val=="ok"){
            long time=System.currentTimeMillis();
            map.put(user.getUsername(), obj.getId().toString());
            maptime.put(user.getUsername(),time);
            arr.add(obj.getId().toString());
            arr.add(fetch.getUid(user.getUsername()));
            return arr;
        }
        return null;
        //return login.getLogin(user);
    }

    @PostMapping(path="/checksession/{uname}")
    String checkSession(HttpSession obj,@PathVariable String uname)
    {
        if(map.get(uname)!=null){
            long currtime=System.currentTimeMillis();
            long prevtime=maptime.get(uname);
            if(currtime-prevtime<=180000*2*48)
            return map.get(uname).toString();
        }
        return "nok";
    }

    @PostMapping(path="/signup",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    String insertUser(@RequestBody User user) throws NoSuchAlgorithmException
    {
        return signup.signup(user);
    }

    @PostMapping(path="/update",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    String handleUpdate(@RequestBody UpdateType updateType)
    {
       return update.doUpdate(updateType.getType(),updateType.getUserToUpdate());
    }

    @PostMapping(path="/fetch/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> fetchUser(@PathVariable String username)
    {
        return fetch.getData(username);
    }

    @PostMapping(path="/fetchbyid/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    List<User>fetchById(@PathVariable String id)
    {
        return fetch.getDataByID(id);
    }

    @PostMapping(path="/verify",produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    String verifyUserName(@RequestBody User user)
    {
        return verify.Verify(user.getUsername());
    }
}
