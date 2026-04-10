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

⭐ 1️⃣ Eureka Dashboard

<img width="500" height="400" alt="Screenshot 2026-04-10 104252" src="https://github.com/user-attachments/assets/8e8e5fe0-e01c-4af2-8702-1a4a19925fe4" />
<img width="500" height="400" alt="Screenshot 2026-04-10 104314" src="https://github.com/user-attachments/assets/10aec444-2284-44c3-9551-eaccde0c97fc" />
<img width="400" height="500" alt="Screenshot 2026-04-10 104356" src="https://github.com/user-attachments/assets/f039912f-2677-4dc3-9ac0-c2f8b3af3dd8" />




🔐 2️⃣ JWT Authentication


<img width="500" height="400" alt="Screenshot 2026-04-10 110207" src="https://github.com/user-attachments/assets/af50d8b1-577b-4757-811f-5507c1704d8e" />
<img width="500" height="400" alt="Screenshot 2026-04-10 110611" src="https://github.com/user-attachments/assets/42552a72-e44b-4740-bf89-2a67607ff32c" />




🌱 3️⃣ Zone Service


<img width="500" height="400" alt="Screenshot 2026-04-10 111301" src="https://github.com/user-attachments/assets/d794de9b-9379-4056-b642-95d61c828c92" />
<img width="500" height="400" alt="Screenshot 2026-04-10 111348" src="https://github.com/user-attachments/assets/4fcae966-f6bb-4206-99b2-cb127c740c19" />




🌡 4️⃣ Sensor Service




🤖 5️⃣ Automation Service




🔄 6️⃣ End-to-End Flow




🌾 7️⃣ Crop Service





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
