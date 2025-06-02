# Contact Manager Web Application

A simple web application to manage personal contact information with full CRUD functionality.
Built using **Java**,**Spring Boot**,**Thymeleaf**,**Bootstrap**,and **PostgreSQL**. 

---

## 🛠️ Tech Stack

| Layer      | Technology             |
|------------|------------------------|
| Backend    | Java 21, Spring Boot   |
| Frontend   | Thymeleaf, Bootstrap   |
| Database   | PostgreSQL             |
| Build Tool | Maven                  |

---

## 🔧 Core Features

- **Add Contact** – Enter and save details (Name, Email, Phone, Address)
- **View Contacts** – Display all saved contacts in a table
- **Edit Contact** – Update existing contact info
- **Delete Contact** – Remove contacts with confirmation
- **Search Contacts** – Search by name (case-insensitive)

---
 ## 📂 Folder Structure

~~~
ContactManager/
├── src/
│ ├── main/
│ │ ├── java/com/yts/ContactManager/
│ │ │ ├── controller/
│ │ │ ├── entity/
│ │ │ ├── repository/
│ │ │ └── service/
│ │ └── resources/
│ │ ├── static/
│ │ ├── templates/
│ │ └── application.properties
├── pom.xml
~~~
---
## 🚀 Installation

Follow these steps to run the Contact Manager web application locally:

### 1. Clone the Repository

```bash
git clone https://github.com/ytsNaman/contact-manager.git
cd contact-manager
```

### 2. Configure PostgreSQL Database
Create a PostgreSQL database (e.g., contact_manager_db)

Update your application.properties file with your DB credentials:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/contact_manager_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run the Project
Make sure you have Java 21, Maven, and PostgreSQL installed.
```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```
### 4. Access the Application
Open your browser and go to:
```bash
http://localhost:8080/
```
You should see the Contacts List page.

## Screenshot
![image](https://github.com/user-attachments/assets/bae45dd2-9d10-4938-86c1-3349067f9546)
![image](https://github.com/user-attachments/assets/64192981-5295-40f7-a43c-a3eca15f51bf)



## ✅ Final Deliverables

- A fully functional **CRUD web application** for managing contacts.
- PostgreSQL integration with proper schema handling.
- Clean and responsive **UI built using Thymeleaf + Bootstrap**.
- Modular and maintainable codebase with:
  - MVC structure (Controller, Service, Repository)
  - Proper package organization
- GitHub repository with:
  - Source code
  - `README.md` documentation
  - Application setup instructions
---

## 🤝 Contributing
This project is part of an internship learning journey. Suggestions, improvements, or PRs are welcome!
