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
 curl --header "Content-Type: application/json" --request POST --data '[{"value": 0.5, "metadata": ""}, {"value": 0.6, "metadata": ""}]' http://localhost:8080/list  
```

### Append to list (malformed body)

```bash
 curl --header "Content-Type: application/json" --request POST --data '[{"value": 0.5; "metadata": ""}]' http://localhost:8080/list  
```

### Clear list

```bash
curl --request DELETE http://localhost:8080/list
```
