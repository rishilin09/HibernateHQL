# **HibernateHQL**
### **Description**
_This project is about the integration of SpringBoot with Hibernate Framework. It is a simple project which has 5 functionalities into it which are:_
 - _**Creating a new data into the table**_
 - _**Reading all the data from the table**_
 - _**Reading only one data from the table using empId column**_
 - _**Update the data of the table using empId column**_

# **What is Hibernate?**

[![Hibernate](https://www.javatpoint.com/images/hibernate/hibernate2.png "Hibernate")](https://www.javatpoint.com/images/hibernate/hibernate2.png "Hibernate")

_**Hibernate** is a Java-based framework that simplifies database interaction. It maps Java objects to database tables, handles SQL queries, and manages connections. It offers
transparent persistence, caching, and supports various databases. Hibernate makes
database programming easier and more efficient._

# **How to install the project?**
To create a Spring Project,
1.  First go to [Spring Initializr](https://start.spring.io/ "Spring Initializr") website and generate spring mvc project.

2. Import the newly created project in eclipse.

3. To run this project we need some dependencies therefore following are the dependencies needed in this project.

	- **spring-boot-starter-thymeleaf**
	- **spring-boot-starter-web**
	- **hibernate-core**
		- ***6.2.2.final***
	- **mysql-connector-j**
	- **spring-boot-configuration-processor**
	- **lombok**

4. Run your project as a“SpringBootApplication".

# **Directory Structure**

_Following is the directory structure of the project:_
```
C:.
├───java
│   └───com
│       └───spitSpring
│           └───HiberanateHQL
│               │   HiberanateHqlApplication.java
│               │
│               ├───controller
│               │       HibernateController.java
│               │
│               ├───hibernate
│               │   ├───dao
│               │   │       EmployeeDAO.java
│               │   │
│               │   ├───entity
│               │   │       Employee.java
│               │   │
│               │   └───util
│               │           HibernateUtil.java
│               │
│               └───service
│                   │   HibernateService.java
│                   │
│                   └───impl
│                           HibernateServiceImpl.java
│
└───resources
    │   application.properties
    │   hibernate.cfg.xml
    │
    ├───static
    │       Create.css
    │       Delete.css
    │       Home.css
    │       Read.css
    │       ReadOne.css
    │
    └───templates
            Create.html
            Delete.html
            Home.html
            Read.html
            ReadOne.html
            Update.html
```

# How to use the project?
1. The home page is the **home.html** file where we have 5 buttons for each of the CRUD operations** (i.e Create, Read-one, Read-all, Update, Delete).**
2. Upon clicking any of the button we will be redirected to any of the pages (**i.e Create.html, ReadOne.html, Read.html, Update.html and Delete.html)**
3. Each and every page will have the UI to perform the CRUD operations.

# Endpoints

- **`/create`** : This endpoint will redirect to the Create.html file where a form will be displayed to get inputs for the new data into the database.

- **`/read`**: This endpoint will redirect to Read.html file where all the data from the table will get displayed in the tabular form.

- **`/update & /updateForm`** : This endpoints will be used to update the data in the table using **Update.html**. **/update** will be used to get the empId from the user and on the basis of it a form will be displayed with the values already present in the input fields. User will update the required values and then the **/updateForm** will be invoked which will update the values in the table.

- **`/fetchByID`** : This endpoint will redirect to **ReadOne.html** page which will have a form input field which will accept empId and on the basis of it data is been fetched and displayed on the screen.

- **`/deletebyId`** : This endpoint will redirect to **Delete.html** page which will have a form input field which will accept empId and on the basis of it data is been deleted from the table.


# Technologies used:
- Spring Boot
- Hibernate ORM Framework
- MySQL Workbench
