# 💸 Expense Tracker — Backend

A REST API built with **Spring Boot** following MVC architecture, connected to **MySQL**, deployed on **Railway**.

🔗 **Live:** [https://financeapp-production-fd54.up.railway.app](https://financeapp-production-fd54.up.railway.app)

---

## 🚀 Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java |
| Framework | Spring Boot |
| Architecture | MVC (Model - View - Controller) |
| Database | MySQL |
| Deployment | Railway |

---

## 🗂 Project Structure

```
src/
└── main/
    └── java/
        └── com/yourapp/
            ├── controller/
            │   └── ExpenseController.java
            ├── service/
            │   └── ExpenseService.java
            ├── repository/
            │   └── ExpenseRepository.java
            ├── model/
            │   └── Expense.java
            └── FinanceAppApplication.java
└── resources/
    └── application.properties
```

---

## 📡 API Endpoints

Base URL: `https://financeapp-production-fd54.up.railway.app/api/v1`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/get_Expense` | Get all expenses |
| `POST` | `/create_Expense` | Create a new expense |
| `GET` | `/get_by_category/{category}` | Filter by `Debit` or `Credit` |
| `GET` | `/expenses_by_date?category=X&sort=sort=date_desc` | Get by category sorted by date |

### POST `/create_Expense` — Request Body

```json
{
  "amount": 154.55,
  "category": "Debit",
  "description": "Party",
  "date": "2026-04-23"
}
```

---

## 🧱 MVC Layers

| Layer | File | Responsibility |
|-------|------|---------------|
| Model | `Expense.java` | Entity mapped to `expenses` table in MySQL |
| Repository | `ExpenseRepository.java` | JPA queries — findAll, findByCategory, sort by date |
| Service | `ExpenseService.java` | Business logic between controller and repository |
| Controller | `ExpenseController.java` | Handles HTTP requests, returns responses, try-catch on every endpoint |

---

## 🛡 Error Handling

Every controller method is wrapped in a `try-catch` block:

- **Success** → returns `200 OK` or `201 Created` with data
- **Failure** → returns `500 Internal Server Error` with error message

---

## 🔧 application.properties

```properties
server.port=8080

spring.datasource.url=${MYSQL_URL}
spring.datasource.username=${MYSQL_USER}
spring.datasource.password=${MYSQL_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

> Railway automatically injects `MYSQL_URL`, `MYSQL_USER`, and `MYSQL_PASSWORD` as environment variables.

---

## ⚠️ CORS

Configured with `@CrossOrigin(origins = "*")` on the controller to allow requests from the frontend at [https://finance-app-frontend-gold-ten.vercel.app](https://finance-app-frontend-gold-ten.vercel.app).

---

## 🌐 Deployment — Railway

1. Push code to GitHub
2. Go to [railway.app](https://railway.app) → New Project → Deploy from GitHub
3. Add **MySQL** plugin from Railway dashboard
4. Railway injects DB credentials automatically as environment variables
5. App goes live at the Railway domain

## Get Expense
<img width="843" height="491" alt="image" src="https://github.com/user-attachments/assets/14b02769-0407-4a63-a271-0a7e668fb279" />

## Create Expense
<img width="883" height="449" alt="image" src="https://github.com/user-attachments/assets/07fffeb8-fdba-43ca-8920-715b4e155607" />

## Category and Sorted
<img width="856" height="469" alt="image" src="https://github.com/user-attachments/assets/f9f5bf24-b600-4210-829c-d1532e9a6a7c" />



MIT
