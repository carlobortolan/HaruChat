# HaruChat

**A basic REST-API for a chat application using Spring.**

> __NOTE__: _As this project was mainly used for learning purposes, it has private api keys / tokens exposed and
does not include any tests (yet)._

## Core functionalities

- API that creates basis for a chat platform consisting of multiple users that can start conversations (either direct
  conversations or group conversations) and exchange messages
- Full CRUD-Operations available (_see Endpoints below_)
- User data securely stored and encrypted in database
- Integration of Spring-Security:
    - Basic Authentication by username (email) and password
    - JWT Token Authentication (by bearer token) for stateless access without needing to provide the credentials in
      every request

## How it works

(The use of tools such as [POSTMAN](https://www.postman.com/) is highly recommended)

### Credentials for easy access:

- username: `admin`

- password: `password`

> POST/http://localhost:8081/api/users with Basic Authentication using the above credentials.

You can now access the API as an Admin using the provided JWT-Token as Bearer Token.

To access the database go to http://localhost:8080/h2-console/. \
To access the API go to http://localhost:8080/login.

> **NOTE:** _(per default this API uses the H2-DataBase which doesn't need additional programs to be used. To change
this to MySQL or similar DBMS read [here](#setting-up-persistent-database-with-mysql))._

## Endpoints

<details><summary><b>Authentication</b></summary>

| **HTTP** | **URL**        | **Authentication** | **Request Body (JSON)**          | **Response Body (JSON)** | 
|----------|----------------|--------------------|----------------------------------|--------------------------|
| GET      | */api/welcome* | no                 | serialized authentication object | [empty]                  | 
| GET      | */api/token*   | yes (basic)        | serialized authentication object | [empty]                  | 

> Welcome message: \
> <span style="color:lawngreen"> GET </span> */api/welcome*
>
> Request new JWT-Token: \
> <span style="color:lawngreen"> GET </span> */api/token*
</details>

<details><summary><b>Users</b></summary>

| **HTTP** | **URL**            | **Authentication** | **Request Body (JSON)** | **Response Body (JSON)**  | 
|----------|--------------------|--------------------|-------------------------|---------------------------|
| POST     | */api/users*       | yes                | serialized user object  | serialized user object    | 
| GET      | */api/users*       | yes                | [empty]                 | serialized Iterable<User> | 
| GET      | */api/users/basic* | yes                | [empty]                 | serialized Iterable<User> | 
| GET      | */api/users/{id}*  | yes                | [empty]                 | serialized user object    | 
| PUT      | */api/users/{id}*  | yes                | serialized user object  | [empty]                   | 
| DELETE   | */api/users/{id}*  | yes                | [empty]                 | [empty]                   | 

> Save a new user: \
> <span style="color:lawngreen"> POST </span> */api/users*

> Find all users: \
> <span style="color:lawngreen"> GET </span> */api/users/basic*
>
> Find all basic users: \
> <span style="color:lawngreen"> GET </span> */api/users/basic*
>
> Find a specific user: \
> <span style="color:lawngreen"> GET </span> */api/users/{id}*


> Update or replace a user: \
> <span style="color:lawngreen"> PUT </span> */api/users/{id}*

> Delete a specific user:\
> <span style="color:lawngreen"> DELETE </span> */api/users/{id}*
</details>

<details><summary><b>Messages</b></summary>

| **HTTP** | **URL**                 | **Authentication** | **Request Body (JSON)**   | **Response Body (JSON)**     | 
|----------|-------------------------|--------------------|---------------------------|------------------------------|
| POST     | */api/messages*         | yes                | serialized message object | serialized message object    | 
| GET      | */api/messages*         | yes                | [empty]                   | serialized Iterable<Message> | 
| GET      | */api/messages/by/{id}* | yes                | [empty]                   | serialized Iterable<Message> | 
| GET      | */api/messages/{id}*    | yes                | [empty]                   | serialized message object    | 
| PUT      | */api/messages/{id}*    | yes                | serialized message object | [empty]                      | 
| DELETE   | */api/messages/{id}*    | yes                | [empty]                   | [empty]                      | 
| DELETE   | */api/messages/{time}*  | yes                | [empty]                   | [empty]                      | 

> Save a new message: \
> <span style="color:lawngreen"> POST </span> */api/messages*


> Find all messages: \
> <span style="color:lawngreen"> GET </span> */api/messages*
>
> Find all messages sent by a specific user: \
> <span style="color:lawngreen"> GET </span> */api/messages/by/{id}*
>
> Find a specific message: \
> <span style="color:lawngreen"> GET </span> */api/messages/{id}*


> Update or replace a message: \
> <span style="color:lawngreen"> PUT </span> */api/messages/{id}*

> Delete a specific message:\
> <span style="color:lawngreen"> DELETE </span> */api/messages/{id}*
>
> Delete all messages sent before a certain date:\
> <span style="color:lawngreen"> DELETE </span> */api/messages/{time}*
</details>

<details><summary><b>Conversations</b></summary>

| **HTTP** | **URL**                               | **Authentication** | **Request Body (JSON)**        | **Response Body (JSON)**          | 
|----------|---------------------------------------|--------------------|--------------------------------|-----------------------------------|
| POST     | */api/conversations*                  | yes                | serialized conversation object | serialized conversation object    | 
| GET      | */api/conversations*                  | yes                | [empty]                        | serialized Iterable<Conversation> | 
| GET      | */api/conversations/{id}*             | yes                | [empty]                        | serialized conversation object    | 
| GET      | */api/conversations/of/{id}*          | yes                | [empty]                        | serialized Iterable<Conversation> | 
| GET      | */api/conversations/of/{id}/active*   | yes                | [empty]                        | serialized Iterable<Conversation> | 
| GET      | */api/conversations/of/{id}/inactive* | yes                | [empty]                        | serialized Iterable<Conversation> | 
| PUT      | */api/conversations/{id}*             | yes                | serialized conversation object | [empty]                           | 
| DELETE   | */api/conversations/{id}*             | yes                | [empty]                        | [empty]                           | 

> Save a new conversation: \
> <span style="color:lawngreen"> POST </span> */api/conversations*


> Find all conversations: \
> <span style="color:lawngreen"> GET </span> */api/conversations*
>
> Find all conversations of a specific user: \
> <span style="color:lawngreen"> GET </span> */api/conversations/of/{id}*
>
> Find all active conversations of a specific user: \
> <span style="color:lawngreen"> GET </span> */api/conversations/of/{id}/active*
>
> Find all inactive conversations of a specific user: \
> <span style="color:lawngreen"> GET </span> */api/conversations/by/{id}/inactive*
>
> Find a specific conversation: \
> <span style="color:lawngreen"> GET </span> */api/conversations/{id}*


> Update or replace a conversation: \
> <span style="color:lawngreen"> PUT </span> */api/conversations{id}*

> Delete a specific conversation:\
> <span style="color:lawngreen"> DELETE </span> */api/conversations/{id}*
</details>

## Setting up persistent database with MySQL

Per default the standard H2-DataBase is used.
To change this to a MySQL database:

1. Create a new schema called "haruchat" in MySQL
2. Open [application.properties](src/main/resources/application.properties)
    - change: `spring.datasource.url=jdbc:h2:mem:testdb` \
      to: `spring.datasource.url=jdbc:mysql://localhost:3306/haruchat
      `

    - add:
      ```
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      spring.jpa.hibernate.ddl-auto=update
      ```
    - insert your MySQL credentials in `spring.datasource.username=`and `spring.datasource.password=`

## What's next

- Adding unit tests
- Integration of this API in a mobile App, most likely written in Kotlin or creation of a React web-app using this API
- ...

## License

### Licensed under

GNU Affero General Public License v3.0 ([ AGPL-3.0 license ](https://www.gnu.org/licenses/))
