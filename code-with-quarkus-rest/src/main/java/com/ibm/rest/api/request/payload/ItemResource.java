package com.ibm.rest.api.request.payload;

import com.ibm.rest.api.entity.Item;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("item")
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {

    @POST
    public Item save(Item item){
        System.out.println(item);
        return item;
    }
}
