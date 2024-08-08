# springboot-devservice
An example of how to configure SpringBoot to manage services at start on local dev to help and debug.

It is build with Gradle Kotlin DSL, on Spring Boot 3.3.2.


## What is it?

Since Spring Boot 3.1, it is possible to start services at start time. This is very useful for local development.

This project is configured to start a local Postgres database and a local Keycloak server.

The keycloak server listen on port 8080, the server on 8081 and postgresql on port 30000.

## Testing with Keycloak

You can test the authenticated access with the endpoint in `PUT` (`/shelves` or `/books`). All `GET` endpoints are accessible without authentication.

You can use the following credentials to authenticate:
admin / admin

You can get an access token with the following curl command:
```curl
curl --request POST \
  --url http://localhost:8080/realms/springbootdevservices/protocol/openid-connect/token \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data grant_type=password \
  --data client_id=admin-cli \
  --data username=admin \
  --data password=admin
````

## How to build
```bash
./gradlew build
```

## How to run

In your IDE you can run the test class `TestSpringbootDevservicesApplication`.
