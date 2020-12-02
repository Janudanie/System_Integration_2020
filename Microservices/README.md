### My Microservice assignment

running the command "docker-compose up" inside the folder "deploy", will start the enviroment up.
To deploy it in Kubernetes, have the default stack of Docker be kubernetes, and use "docker stack deploy --compose-file .\docker-compose.yaml mytest"

There are not alot of reviews, but going to "localhost:8080/reviews/skoda" should get the review of a skoda out.

Use the command "minikube dashboard" to observe your kubernetes
