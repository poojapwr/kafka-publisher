# kafka-publisher
kafka publisher demo practice, Ref: Javatechie

Start Zookeeper ::
kafka_2.13-2.8.0\bin\windows\zookeeper-server-start.bat kafka_2.13-2.8.0\config\zookeeper.properties

Start Kafka ::
kafka_2.13-2.8.0\bin\windows\kafka-server-start.bat kafka_2.13-2.8.0\config\server.properties

Create Topic ::
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic kafka-test

Consumer Console ::
kafka_2.13-2.8.0\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafka-test
