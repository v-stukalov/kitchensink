# Demo project for Spring Boot Quickstart: kitchensink

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This is a project to migrate a legacy JBoss Java application to a more modern platform.
Original application to migrate is the ‘kitchensink’ JBoss application available in the Red Hat JBoss EAP Quickstarts GitHub [repository](https://github.com/jboss-developer/jboss-eap-quickstarts/tree/8.0.x/kitchensink). 

Spring Boot is an auto-configured microservice-based web framework that provides built-in features for security and database access.

With Spring boot, we can quickly create stand-alone applications without having to make too many configuration changes.

## Technologies
Project is created with:
* Java 21
* Spring Boot 3.3.3
* Maven 3.9.4

## Setup
To run this project, install it locally using git and maven:

```
$ git clone https://github.com/v-stukalov/kitchensink.git
$ cd kitchensink
$ mvn clean install
$ mvn spring-boot:run
```