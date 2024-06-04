package business.abstracts;

import entities.User;
import enums.PersonType;

public interface AuthControlService {
     void addUser(User user);
    boolean authenticate(String username, String password);
    boolean authorize(User user, PersonType requiredRole);
}
