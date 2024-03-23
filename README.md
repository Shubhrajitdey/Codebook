CodeBook
CodeBook is a RESTful API service developed using Spring Boot to manage the leaderboard for a coding platform. It utilizes MongoDB to persist the data and provides endpoints for various leaderboard management operations.

Problem Description
While coding platforms usually host multiple contests while maintaining numerous leaderboards, CodeBook focuses on managing the leaderboard of a specific contest. It assumes the platform has only one contest with a single leaderboard and gives virtual awards to users called Badges based on their score.

Installation Guide
Prerequisites
⚙️ MongoDB installed on your local machine
💻 Spring Boot and Java version 8 or higher
Steps
Clone the repository by using the command given below:
    git clone https://github.com/bhooshanmate/CodeBook.git
    cd CodeBook
Run the project by using the following command:
    mvn spring-boot:run
Connect to the API using Postman on port 8080
    http://localhost:8080
Usage
API Endpoints
HTTP Verbs	Endpoints	Action
GET	/users	To get all participants
GET	/users/{userId}	To get a particular participant
POST	/users	To create new participants
PUT	/users/{userId}	To update scores
DELETE	/users/{userId}	To remove participants from contest
Checkout this Postman collections - 
