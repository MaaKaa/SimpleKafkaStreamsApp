A simple Spring Cloud Stream app using Apache Kafka Streams binder. 

## Table of contents
* [Background](#background)
* [Technologies](#technologies)
* [Setup](#setup)
* [Status](#status)
* [Contact](#contact)

## Background
Spring Cloud Stream is a framework for building highly scalable event-driven microservices connected with shared messaging systems. It supports a variety of binder implementations - e.g. for the Apache Kafka Streams.
Learn more: https://spring.io/projects/spring-cloud-stream

## Features
This simple application was built to test Spring Cloud Services and Kafka Streams binder. 

It defines two kafka topics to which some events are being sent. 

Firstly, the stream of events comes to the 1st topic, then the events from this stream are filtered, and then the events that match the given predicate are processed to the second topic.

## Technologies
Used tools/ frameworks:

- Java 11
- Gradle
- Spring Boot
- Spring Cloud Stream with Apache Kafka Streams binder 
- IntelliJ Ultimate Edition

## Setup
1. First, make sure you have Apache Kafka and Zookeeper installed and running on you device. To do so, you can follow this tutorial: https://kafka.apache.org/quickstart

2. Download the project and open it in your IDE. Then, run it (if you use IntelliJ, click Shift+F10). 

3. Open another terminal, go to the kafka folder and create a kafka producer:

> bin/kafka-console-producer.sh --broker-list localhost:9092 --topic first-topic

4. Open another terminal, go to the kafka folder and create a kafka consumer:

> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic second-topic

5. Now in the producer terminal window type the line representing the event in JSON:

> {"content":"ExemplaryContent","type":"NEW"}

6. In the consumer terminal window you should now see:

> {"content":"ExemplaryContent","type":"NEW"}

which means, that the consumer has consumed the event correctly.

Please note, that if you'd like to send the following event from the producer:

> {"content":"ExemplaryContent","type":"INCORRECT"} 

then it won't be consumed by the consumer, because it does not match the given predicate.

## Status
Project is: _finished_ 

## Contact
Created by [Marzena Kacprowicz](http://zrobtowinternecie.pl/) - feel free to contact me!

