# HaruChat

**A basic REST-API for a chat application using Spring.**

> __NOTE__: _As this project was mainly used for learning purposes, it has private api keys / tokens exposed and
does not include any tests (yet)._

## Core functionalities

- API that enables user 
- Full CRUD-Operations available (_see Endpoints below_)
- User data securely stored and encrypted in database
- Integration of Spring-Security:
    - Basic Authentication by username (email) and password
    - JWT Token Authentication (by bearer token) for stateless access without needing to provide the credentials in every request

## How it works

(The use of tools such as POSTMAN is highly recommended)

### Credentials for easy access:

- username: `admin`

- password: `password`

> POST/http://localhost:8081/api/users with Basic Authentication using the above credentials.

You can now access the API as an Admin using the provided JWT-Token as Bearer Token.

To access the database go to http://localhost:8080/h2-console/. \
To access the api go to http://localhost:8080/login.

## Endpoints

<details><summary><b>Authentication</b></summary>

> Welcome message: \
> <span style="color:lawngreen"> GET </span> */api/welcome*
>
> Request new JWT-Token: \
> <span style="color:lawngreen"> GET </span> */api/token*
</details>

<details><summary><b>Users</b></summary>

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


> Update or replace a user \
> <span style="color:lawngreen"> PUT </span> */api/users/{id}*

> Delete a specific user:\
> <span style="color:lawngreen"> DELETE </span> */api/users/{id}*
</details>

<details><summary><b>Messages</b></summary>

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


> Update or replace a message \
> <span style="color:lawngreen"> PUT </span> */api/messages/{id}*

> Delete a specific message:\
> <span style="color:lawngreen"> DELETE </span> */api/messages/{id}*
>
> Delete all messages sent before a certain date:\
> <span style="color:lawngreen"> DELETE </span> */api/messages/{time}*
</details>

<details><summary><b>Conversations</b></summary>

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


> Update or replace a conversation \
> <span style="color:lawngreen"> PUT </span> */api/conversation*

> Delete a specific conversation:\
> <span style="color:lawngreen"> DELETE </span> */api/conversation/{id}*
</details>

## What's next
- Adding unit tests
- Integration of this API in a mobile App, most likely written in Kotlin
- ...

## License

### Licensed under

GNU Affero General Public License v3.0 ([ AGPL-3.0 license ](https://www.gnu.org/licenses/))
