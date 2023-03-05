# shop API

This is an API first hexagonal-architecture microservice that serves information about products.

Steps in its creation:

1. First, the project was generated with Spring initialzr (https://start.spring.io/).
2. Added openapi-generator in order to generate the API and DTOs from main/resources/api.yml
3. Moved back from Spring boot 3.0.3 to 2.7.9 because 3.0.0 transitioned to JakartaEE 9 and
   openapi-generator does not fully support it
   yet (https://github.com/OpenAPITools/openapi-generator/issues/13124)
4. Created database (flyway)
5. Implemented endpoint (tests, controller, service, mapper, product factory)
6. Refactor and added swagger-ui
7. Migrated to hexagonal architecture
8. Release

API docs are also auto generated based on the OpenAPI 3 specification from annotations, available at

- http://localhost:8080/v3/api-docs (json format)
- http://localhost:8080/v3/api-docs.yaml (yaml format)

Swagger integration available at http://localhost:8080/swagger-ui.html

Tests can be run with `./mvnw clean test`

## About hexagonal architecture

Hexagonal architecture is a model of designing software applications around domain logic to isolate
it from external factors.

![](https://reflectoring.io/images/posts/spring-hexagonal/hexagonal-architecture_hu6764515d7030d45af6f7f498c79e292b_50897_956x0_resize_box_3.png)

In order to achieve this, the code is divided into three layers: application (outside), domain
(inside) and infrastructure (outside).

## Manually test the microservice

To start the microservice, execute the following command in the root folder of the project:

```shell script
./mvnw clean package && java -jar target/shop-0.1.1.jar
```

and you will be able to test the endpoint in the swagger-ui: http://localhost:8080/swagger-ui.html

## Dataset

Provided dataset is loaded via flyway and is tested
in [ProductIntegrationTest.java](src%2Ftest%2Fjava%2Fcom%2Finditex%2Fshop%2Fintegration%2FProductIntegrationTest.java)

## Improvements

1. Decouple domain POJOs from entity POJOs in order to normalize Product class (Product should
   contain a price and a branch, and the price shouldn't contain a product)