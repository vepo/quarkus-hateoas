package io.vepo.hateoas;

import java.net.URI;

public record Link(LinkType type, String rel, URI uri) {

}
