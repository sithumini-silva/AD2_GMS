# 🌱 AGMS - Automated Greenhouse Management System

## 📌 Overview

The **Automated Greenhouse Management System (AGMS)** is a cloud-native, microservice-based platform designed to automate and optimize greenhouse operations. The system integrates with an external IoT data provider to monitor environmental conditions and automatically trigger actions based on predefined rules.

---

## 🎯 Objectives

* Automate greenhouse monitoring
* Improve crop yield using real-time data
* Reduce manual errors
* Enable smart decision-making using rule-based automation

---

## 🏗️ System Architecture

This project follows a **Microservices Architecture** with the following components:

### 🔧 Infrastructure Services

* **Eureka Server** – Service Discovery
* **Spring Cloud Config Server** – Centralized Configuration
* **API Gateway** – Routing + JWT Security

### 📦 Domain Microservices

* **Zone Management Service** (Port: 8081)
* **Sensor Telemetry Service** (Port: 8082)
* **Automation Service** (Port: 8083)
* **Crop Inventory Service** (Port: 8084)

---

## ⚙️ Technologies Used

* Spring Boot
* Spring Cloud (Eureka, Config, Gateway)
* OpenFeign / RestTemplate
* JWT Authentication
* MySQL / MongoDB (based on service)
* Postman (API Testing)

---

## 🔄 System Workflow

1. External IoT API provides real-time temperature & humidity
2. Sensor Service fetches data every 10 seconds
3. Data is sent to Automation Service
4. Automation Service:

    * Fetches zone thresholds from Zone Service
    * Applies rules:

        * Temp > max → Turn Fan ON
        * Temp < min → Turn Heater ON
5. Actions are logged and available for users

---

## 🚀 How to Run the Project

### Step 1: Start Config Server

```bash
cd config-server
mvn spring-boot:run
```

---

### Step 2: Start Eureka Server

```bash
cd eureka-server
mvn spring-boot:run
```

---

### Step 3: Start API Gateway

```bash
cd api-gateway
mvn spring-boot:run
```

---

### Step 4: Start Microservices

Run each service one by one:

```bash
cd zone-service
mvn spring-boot:run
```

```bash
cd sensor-service
mvn spring-boot:run
```

```bash
cd automation-service
mvn spring-boot:run
```

```bash
cd crop-service
mvn spring-boot:run
```

---

## 🔐 Authentication

* JWT-based authentication implemented at API Gateway
* All requests must include:

```
Authorization: Bearer <token>
```

---

## 🌐 External IoT API

Base URL:

```
http://104.211.95.241:8080/api
```

### Key APIs:

* Register
* Login
* Refresh Token
* Device Management
* Telemetry Data

---

## 📡 API Endpoints (Summary)

### Zone Service

* POST /api/zones
* GET /api/zones/{id}
* PUT /api/zones/{id}
* DELETE /api/zones/{id}

### Sensor Service

* GET /api/sensors/latest

### Automation Service

* POST /api/automation/process
* GET /api/automation/logs

### Crop Service

* POST /api/crops
* PUT /api/crops/{id}/status
* GET /api/crops

---

## 🧪 Testing

* Postman Collection included in root directory
* Test all endpoints using:

    * JSON body
    * Authorization headers

---

## 📊 Eureka Dashboard

Access:

```
http://localhost:8761
```

👉 Screenshot included in `/docs` folder showing all services as **UP**

---

## 📁 Project Structure

```
AGMS/
│
├── config-server/
├── eureka-server/
├── api-gateway/
├── zone-service/
├── sensor-service/
├── automation-service/
├── crop-service/
│
├── docs/
│   └── eureka-dashboard.png
│
├── postman_collection.json
└── README.md
```

---

## ✅ Features Implemented

✔ Microservices Architecture
✔ Service Discovery (Eureka)
✔ Centralized Config (Spring Cloud Config)
✔ API Gateway Routing
✔ JWT Security
✔ External IoT Integration
✔ Inter-Service Communication
✔ Rule-Based Automation

---

📸 REQUIRED SCREENSHOTS

✅ Eureka Dashboard
![Screenshot 2026-04-10 104314.png](..%2F..%2F..%2F..%2FPictures%2FScreenshots%2FScreenshot%202026-04-10%20104314.png)
![Screenshot 2026-04-10 104252.png](..%2F..%2F..%2F..%2FPictures%2FScreenshots%2FScreenshot%202026-04-10%20104252.png)
![Screenshot 2026-04-10 104356.png](..%2F..%2F..%2F..%2FPictures%2FScreenshots%2FScreenshot%202026-04-10%20104356.png)

---

## 👨‍💻 Author

**Sithu Silva**

---

## 📌 Notes

* Ensure all services are running before testing
* External API requires valid JWT token
* Sensor service runs scheduled task every 10 seconds

---

## ⭐ Conclusion

AGMS demonstrates a real-world implementation of a distributed microservices system with secure communication, centralized configuration, and real-time data processing for smart agriculture.

---
