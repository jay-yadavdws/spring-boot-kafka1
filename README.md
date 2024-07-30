# Spring-Boot-Kafka
Spring Boot With Kafka Initial Setup &amp; Configuration Project

 * The Project has docker-compose file that can be used to create Kafka Broker.

### Some important Kafka Commands: 


* Download Kafka on Linux : 

   1. `wget https://archive.apache.org/dist/kafka/3.6.0/kafka_2.13-3.6.0.tgz`

  2. `tar xzf kafka_2.13-3.6.0.tgz`

  3. `mv kafka_2.13-3.6.0 kafka`

  4. `cd kafka/`

    
* Setup Kafka Server using Kraft :
  1. `./bin/kafka-storage.sh random-uuid`  : Generate Cluster Id <cluster_id>
  2. `./bin/kafka-storage.sh format -t <cluster_id> -c ./config/kraft/server.properties`
  3. `./bin/kafka-server-start.sh ./config/kraft/server.properties`                     ----------   Start The Kafka server

Command 2 Creates a `/tmp/kraft-combined-logs/` folder

### Start Kafka Server with Kraft In One Command :
`./bin/kafka-storage.sh format -t $(./bin/kafka-storage.sh random-uuid) -c ./config/kraft/server.properties  && ./bin/kafka-server-start.sh ./config/kraft/server.properties`

### Topic Commands
1. `./bin/kafka-topics.sh --list --bootstrap-server localhost:9092`
2. `./bin/kafka-topics.sh --describe --bootstrap-server localhost:9092`
3. `./bin/kafka-topics.sh --create --topic topic1 --bootstrap-server localhost:9092`
4. `./bin/kafka-topics.sh --delete --topic topic1 --bootstrap-server localhost:9092`

### Send Message to Topic
1. `./bin/kafka-console-producer.sh -- topic topic1 -- bootstrap-server localhost:9092`
2. `./bin/kafka-console-producer.sh --topic topic1 --bootstrap-server localhost:9092 --property="parse.key=true;key.delimiter=:"`   -- Send msg with key-value


