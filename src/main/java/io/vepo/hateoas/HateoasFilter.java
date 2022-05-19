package io.vepo.hateoas;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
@PreMatching
public class HateoasFilter implements ContainerResponseFilter {
    private static Logger logger = LoggerFactory.getLogger(HateoasFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        var entity = responseContext.getEntity();
        System.out.println(entity);

        responseContext.setEntity(transform(entity));

    }

    private Object transform(Object entity) {
        if (entity instanceof List<?> entityList) {
            return entityList.stream().map(this::transform).toList();
        } else if (entity instanceof Usuario usuario) {
            try {
                return new HateoasUsuarioResponse(usuario.id(), usuario.username(), usuario.nome(),
                        Arrays.asList(new Link(LinkType.GET, "self", new URI("/usuarios/" + usuario.id()))));
            } catch (URISyntaxException e) {
                e.printStackTrace();
                return entity;
            }

        } else {
            return entity;
        }
    }
}
