# MicroProfile generated Application

## Introduction

MicroProfile Starter has generated this MicroProfile application for you.

The generation of the executable jar file can be performed by issuing the following command

```shell
mvn clean package
```
This will create an executable jar file **eclipse-store.jar** within the _target_ maven folder. This can be started by executing the following command

```shell
java -jar target/eclipse-store.jar
```

### Liberty Dev Mode

During development, you can use Liberty's development mode (dev mode) to code while observing and testing your changes on the fly.
With the dev mode, you can code along and watch the change reflected in the running server right away;
unit and integration tests are run on pressing Enter in the command terminal; you can attach a debugger to the running server at any time to step through your code.

```shell
mvn liberty:dev
```


To launch the test page, open your browser at the following URL

```
http://localhost:9080/index.html  
```

## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.

Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.

More information on MicroProfile can be found [here](https://microprofile.io/)


## Running databases

```shell
docker-compose -f docker-compose.yml up -d
```

### Couchbase

Couchbase Server, originally known as Membase, is an open-source, distributed multi-model NoSQL document-oriented database software package optimized for interactive applications. These applications may serve many concurrent users by creating, storing, retrieving, aggregating, manipulating and presenting data.

#### Configurations

1. Install docker: https://www.docker.com/
1. https://hub.docker.com/r/couchbase/server/
1. Run docker command:

```shell
docker run -d --name db -p 8091-8097:8091-8097 -p 9123:9123 -p 11207:11207 -p 11210:11210 -p 11280:11280 -p 18091-18097:18091-18097 couchbase
```

1. Access: http://localhost:8091/ui/index.html
1. Select the option "Setup New Cluster"
1. Define "root" as Admin username
1. Define "123456" as Password
1. Define "localhost" as Cluster Name
1. Accept the terms and conditions
1. Go to "Buckets" session
1. Create Bucket "beers" using the "Add Bucket" Option
1. Click at "beers"
1. Add "Hero" and "Villain" as Collection
1. Go to Query session and execute: CREATE PRIMARY INDEX `#primary` ON `heroes`.`_default`.`Hero`


## Testing the API

Inserting:

```shell
curl --location --request POST 'http://localhost:9080/beers/random'
```

```shell
curl --location 'http://localhost:9080/beers/'
curl --location 'http://localhost:9080/beers/?page=1&hop=Magnum'
curl --location 'http://localhost:9080/beers/?page=1&hop=Magnum&malt=Vienna'
```