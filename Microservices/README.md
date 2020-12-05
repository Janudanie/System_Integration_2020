## My Microservice assignment

### Run in Docker
running the command "docker-compose up" inside the folder "deploy", will start the enviroment up in a docker environment.

a http request to http://localhost:8080/mycars will make a search to the car-catalog service.
a http request to http://localhost:8080/reviews/skoda will get the skoda review from the car-review service



### Run in Kubernetes
This step requires some insight into kubernetes to work.

First move the files *.jar to the directory /data on the kubernets docker 

running the batch file "kubernetes_deploy.bat" inside the folder deploy, will deploy the kubernetes environment.

Use the command "minikube dashboard" to observe your kubernetes

from here you can get the Ip of the service gateway.
This can be used to run the following command inside the kubernetes docker.
curl $IP_SERVICE_GATEWAY:8080/mycars
curl $IP_SERVICE_GATEWAY:8080/reviews/skoda
