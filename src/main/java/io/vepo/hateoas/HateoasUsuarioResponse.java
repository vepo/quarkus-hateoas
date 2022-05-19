package io.vepo.hateoas;

import java.util.List;

public record HateoasUsuarioResponse(long id, String username, String nome, List<Link> links) {

}
