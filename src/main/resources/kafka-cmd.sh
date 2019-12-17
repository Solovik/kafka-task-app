/usr/hdp/3.0.1.0-187/kafka/bin
./kafka-topics.sh --list --zookeeper localhost:2181
./kafka-topics.sh --create --bootstrap-server localhost:2181 --replication-factor 1 --partitions 1 --topic SV
./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic SV

./kafka-console-consumer.sh --bootstrap-server localhost:2181 --topic SV --from-beginning
./kafka-console-producer.sh --broker-list localhost:2181 --topic SV

./kafka-console-consumer.sh --bootstrap-server sandbox-hdp.hortonworks.com:2181 --topic SV --from-beginning
./kafka-console-producer.sh --broker-list sandbox-hdp.hortonworks.com:2181 --topic SV
