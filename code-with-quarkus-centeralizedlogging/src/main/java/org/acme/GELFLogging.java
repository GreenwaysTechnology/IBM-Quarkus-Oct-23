package org.acme;

import jakarta.ws.rs.Path;
import org.jboss.logging.Logger;

@Path("/gelf-logging")
public class GELFLogging {

    private static final Logger LOG =Logger.getLogger(GELFLogging.class);
    public void log(){
        LOG.info("This is ELF logs");
    }
}