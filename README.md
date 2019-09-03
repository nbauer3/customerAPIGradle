# customerAPIGradle

To download, run command: `git clone https://github.com/nbauer3/customerAPIGradle.git`

Next use command: `gradle build`

Finally, run the app: `gradle bootRun`

# Running with Docker

First, make sure no other docker images are using port 8080: `docker ps -a`

Next, build new docker image: `docker build -t <insert image name here> .`

Check status of new docker image: `docker images`

Run new docker image on port 8080: `docker run -p 8080:8080 -it <insert image name here>`
