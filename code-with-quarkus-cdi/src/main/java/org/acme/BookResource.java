package org.acme;

import com.ibm.service.interfaces.ISBNGenerator;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("books")
public class BookResource {
    @Inject
    ISBNGenerator isbnGenerator;

    @GET
    public String getISBN() {
        return isbnGenerator.generateISBNNumber();
    }
}
