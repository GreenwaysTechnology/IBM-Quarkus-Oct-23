package org.acme;


import com.ibm.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("users")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public List<String> getUsers() {
        return userService.getUsers();
    }
}
