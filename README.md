# spring-boot-application-deployed-on-kubernetes
This is a simple demo which deployment spring-boot application on kubernetes cluster.

### Deployment Steps From CLI:

* **Start the k8s cluster.**

* ```bash
  minikube start
  ```

* **Create our first pod.**

  ```bash
  kubectl create deployment k8s-demo --image=isalemnabeel/k8s-demo
  ```

  ```bash
  kubectl get pods
  ```

  ```bash
  kubectl get deployments
  ```

  ```bash
  kubectl describe pod k8s-demo
  ```

* **Lunch k8s dashboard.**

  ```bash
  minikube dashboard
  ```
  
* **Lunch k8s tunnel.**

  ```bash
  minikube tunnel
  ```
  
* **Expose Deployment.**

  ```bash
  kubectl expose deployment k8s-demo-deployment --name=k8s-demo-service --port=9409 --target-port=9409 --type=LoadBalancer
  ```
  
* **Open your browser:**

  http://localhost:9409/lucky-day

------

### Deployment Steps From Yaml File [k8s-demo-deployment.yaml]:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: k8s-demo-deployment
  labels:
    app: k8s-demo
spec:
  replicas: 1
  selector:
    matchLabels:
      app: k8s-demo
  template:
    metadata:
      labels:
        app: k8s-demo
    spec:
      containers:
      - name: k8s-demo
        image: isalemnabeel/k8s-demo
        ports:
        - containerPort: 9409
```

```bash
kubectl apply -f k8s-demo-deployment.yaml
```
* **Lunch k8s dashboard.**

  ```bash
  minikube dashboard
  ```
  
* **Lunch k8s tunnel.**

  ```bash
  minikube tunnel
  ```
  
* **Expose Deployment.**

  ```bash
  kubectl expose deployment k8s-demo-deployment --name=k8s-demo-service --port=9409 --target-port=9409 --type=LoadBalancer
  ```
  
* **Open your browser:**

  http://localhost:9409/lucky-day