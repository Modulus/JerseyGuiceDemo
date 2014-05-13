JerseyGuiceDemo
===============

Jersey, Jetty, Google Guice, CdiRunner for tests. For views, pure html :)
To run this, just clone this repository, install maven. And to mvn jetty:run inside the project root folder.


Use
========================
REST api:
http://localhost:8080/api/users/all

#Get user with ident 1
http://localhost:8080/api/users/1

#Get all messages to/from user with identity 3
http://localhost:8080/api/messages/3


HTML:
http://localhost:8080/static/index.html