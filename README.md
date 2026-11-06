# Spring Boot : Application PetClinic

## Features

### 1.  Unit Test  --> Tag v1.0.0

mvn test -Dspring.profiles.active=h2

## Laboratorio 11

Requiere Java 21. La base H2 carga `schema.sql` y `data.sql`; cada prueba nueva
usa `@Transactional` para revertir sus cambios.

```powershell
$env:JAVA_HOME='C:\Program Files\Java\jdk-21.0.12.1'
$env:MAVEN_OPTS='-Djavax.net.ssl.trustStoreType=Windows-ROOT'
mvn test '-Dtest=VetServiceTest'
mvn test
```

Las clases `VetServiceTest`, `OwnerServiceTest`, `SpecialtyServiceTest`,
`VisitServiceTest` y `TypeServiceTest` comprueban CRUD con H2. La clase
`VetSpecialtyServiceTest` comprueba asignación, búsqueda y eliminación de la
relación. El servicio `ClinicTableService` expone las operaciones usadas por
estas pruebas.
