Task:
1. Create app on Java SE 1.8, Spring Boot (REST API)
<br>
2. Functions:
<br>
-create vote room
<br>
-run voting
<br>
-close voting
<br>
-show stats
<br>
3. Install:
<br>
-Install MySQL and edit application.properties with URL, username, password. 
<br>
Default is: jdbc:mysql://localhost:3306/VOTE, root, root
<br>
-Run db_create.sql with application schema and sample data
<br>
4. Work flow
<br>
By default root page is /swagger-ui.html# with all endpoints
<br>
4.1 Create question (POST /questions)
<br>
4.2 Create answers (POST /answers) for this question
<br>
4.3 Create vote room (POST /rooms) with question id from step 4.1
<br>
4.4 Run vote room (GET /rooms/{id}/run) - in response you will get URL to making votes
<br>
4.5 Add some votes with provided URL (POST /votes/rooms/{id})
<br>
4.6 Any time for open room hit (POST /votes/rooms/{id}) for getting stats
<br>




