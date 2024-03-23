# CodeBook
CodeBook is a RESTful API service developed using Spring Boot to manage the leaderboard for a coding platform. It utilizes MongoDB to persist the data and provides endpoints for various leaderboard management operations.

# Problem Description
While coding platforms usually host multiple contests while maintaining numerous leaderboards, CodeBook focuses on managing the leaderboard of a specific contest. It assumes the platform has only one contest with a single leaderboard and gives virtual awards to users called Badges based on their score.

# Installation Guide
## Prerequisites
- :gear: [MongoDB](https://docs.mongodb.com/manual/installation/) installed on your local machine
- :computer: [Spring Boot](https://spring.io/projects/spring-boot) and [Java](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) version 8 or higher
### Steps
- Clone the repository by using the command given below:
``` Shell
    git clone https://github.com/Shubhrajitdey/Codebook.git
    cd Codebook
```
- Run the project by using the following command:
``` Shell
   ./gradlew bootRun
```
- Connect to the API using Postman on port 8080
``` Shell
    http://localhost:8080
```    
# Usage
### API Endpoints
| HTTP Verbs | Endpoints | Action |
| --- | --- | --- |
| GET | /users | To get all participants |
| GET | /users/{userId} | To get a particular participant |
| POST | /users | To create new participants |
| PUT | /users/{userId} | To update scores |
| DELETE | /users/{userId} | To remove participants from contest |

### Checkout this Postman collections - https://www.postman.com/mycriobuildout/workspace/crio-build-out/collection/33820042-e55fe69b-6b0f-48c6-a915-0af58dfd9a1e?action=share&creator=33820042
