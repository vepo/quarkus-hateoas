package io.vepo.hateoas;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuario")
@ApplicationScoped
public class UsuarioRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listar() {
        return Arrays.asList(new Usuario(1l, "vepo", "Victor Osório"));
    }
}