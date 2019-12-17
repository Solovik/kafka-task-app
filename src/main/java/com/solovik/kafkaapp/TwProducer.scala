package com.solovik.kafkaapp

import java.util.Properties
import java.util.concurrent.{Executors, TimeUnit}

import twitter4j.{FakeTwStatusGen, GeoQuery, Status, StatusDeletionNotice, StreamListener, TwitterStreamFactory}
import org.apache.kafka.clients.producer._

object TwProducer {


  def main(args: Array[String]): Unit = {
    val twStatus = FakeTwStatusGen.getTwStatus()
    println(twStatus.getUser.getName)
    val gl = twStatus.getGeoLocation
    println(gl)
    val gq: GeoQuery = new GeoQuery(gl)
    println(gq)


    val props = new Properties()
//    val bootstrapServer = args(0)
//    val topic = args(1)
//    val parallelism = args(2).toInt
    val topic = "SV"
    val parallelism = 1

//    println("bootstrapServer: " + bootstrapServer + ", topic: " + topic + ", parallelism: " + parallelism)

//    props.put("bootstrap.servers", bootstrapServer)
      props.put("bootstrap.servers", "sandbox-hdp.hortonworks.com:6667")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    println("Going to create KafkaProducer")
    val producer = new KafkaProducer[String, String](props)
    producer.send(new ProducerRecord[String, String](topic, "key", "value"))
    producer.close()

    /*println("start parallel sending")
    val pool = Executors.newFixedThreadPool(parallelism)
    for (i <- 1 to parallelism) {
      println("start " + i)
      pool.submit(
        new Runnable {
          override def run(): Unit = {
            for (c <- 1 to Int.MaxValue) {
              producer.send(generateRecord(topic, i, c))
              TimeUnit.MILLISECONDS.sleep(200)
            }
          }
        })
    }*/

    Stream.continually()

/*    val listener = new StreamListener () {
      def onStatus(status: Status): Unit = {
        // todo write to kafka topic
        println(status.getUser.getName + " : " + status.getText)


      }

      def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice): Unit = { }
      def onTrackLimitationNotice(numberOfLimitedStatuses: Int): Unit = { }
      def onException(ex: Exception): Unit = { ex.printStackTrace() }
    }
    val twitterStream = new TwitterStreamFactory().getInstance()
    twitterStream.addListener(listener)*/

  }
  def generateRecord(topic: String, i: Int, c: Int): ProducerRecord[String, String] = {
    new ProducerRecord(topic, "bookingId_" + i + "_" + c, "book_" + i + "_" + c)
  }

}
