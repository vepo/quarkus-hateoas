# Quarkus HETEOAS

Passos

1. Escreva a classe de recurso normalmente, ver [UsuarioRecurso.java](src/main/java/io/vepo/hateoas/UsuarioRecurso.java).
2. Adicione um filtro para transformar a respostsa, ver [ContainerResponseFilter.java](src/main/java/io/vepo/hateoas/HateoasFilter.java)
3. Inspecione os valores a transforme o tipo antes de escreve no formato desejado.