@echo off
REM deploy the applications
kubectl apply -f ".\Kubernetes deploy\cars.yaml"
kubectl apply -f ".\Kubernetes deploy\eureka.yaml"
kubectl apply -f ".\Kubernetes deploy\gateway.yaml"
kubectl apply -f ".\Kubernetes deploy\mongodb.yaml"
kubectl apply -f ".\Kubernetes deploy\reviews.yaml"

REM deploy the services
kubectl apply -f ".\Kubernetes deploy\serviceCar.yaml"
kubectl apply -f ".\Kubernetes deploy\serviceEureka.yaml"
kubectl apply -f ".\Kubernetes deploy\serviceGateway.yaml"
kubectl apply -f ".\Kubernetes deploy\servicemongodb.yaml"
kubectl apply -f ".\Kubernetes deploy\serviceReviews.yaml"