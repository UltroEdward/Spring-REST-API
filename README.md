
# VOTE APP, API

Simple back-end application with API for Voating services


## Technologies

*Java 8
*Spring Boot
*Spring Data and Hibernate
*MySql

[Introduction](intro.md)

## Install

*Install MySQL
*Edit application.properties with URL, username, password (default is: jdbc:mysql://localhost:3306/VOTE, root, root)
*Run db_create.sql with application schema and sample data
*Run jar

## Usage

Check swagger page for api examples /swagger-ui.html#

Work flow:
By default root page is /swagger-ui.html# with all endpoints
*Create question (POST /questions)
*Create answers for this question (POST /answers)
*Create vote room (POST /rooms) with question id from first step
*Run vote room (GET /rooms/{id}/run) - in response you will get URL to making votes
*Add some votes with provided URL (POST /votes/rooms/{id})
*Any time for open room hit (POST /votes/rooms/{id}) for getting stats



