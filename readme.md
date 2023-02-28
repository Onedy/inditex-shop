1. First, the project was generated with Spring initialzr (https://start.spring.io/).
2. Added openapi-generator
3. Moved back from Spring boot 3.0.3 to 2.7.9 because 3.0.0 transitioned to JakartaEE 9 and openapi-generator does not fully support it yet (https://github.com/OpenAPITools/openapi-generator/issues/13124)