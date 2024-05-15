# Software Engineering Summer 2024

This repository is used to showcase concepts such as build automation, code quality monitoring, continuous integration, 
behavior-driven development, as well as architectures for web applications.

## Spring Boot Web Application

### Start application

```bash
mvn spring-boot:run
```

### Get list

```bash
curl http://localhost:8080/list
```

### Append to list

```bash
 curl --header "Content-Type: application/json" --request POST --data '[0.5, 0.6]' http://localhost:8080/list  
```

### Append to list with verbose output

```bash
 curl --verbose --header "Content-Type: application/json" --request POST --data '[0.5, 0.6]' http://localhost:8080/list  
```

### Append to list with verbose output (malformed body)

```bash
 curl --verbose --header "Content-Type: application/json" --request POST --data '[0.5, 0.6' http://localhost:8080/list  
```

### Clear list

```bash
curl --request DELETE http://localhost:8080/list
```
