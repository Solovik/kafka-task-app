package com.solovik.kafkaapp

import java.util.Properties

import twitter4j.{FakeTwStatusGen, Status}
import org.apache.kafka.clients.producer._

object TwProducer {
  val words: List[String] = List("big", "data", "ai", "machine learning", "course")
  val countryCode = "us"

  def main(args: Array[String]): Unit = {

    // Get fake statuses and filter them
    val twStatuses: List[Status] = FakeTwStatusGen.genTwStatuses(100)
    val filtered: List[Status] = twStatuses.filter(_.getPlace.getCountryCode.equalsIgnoreCase(countryCode)).filter(containWord)
    println(s"Statuses count:  ${filtered.length}")

    val topic = "svtopic" // args(1)


    val props = new Properties()
    //    props.put("bootstrap.servers", bootstrapServer)
    //      props.put("bootstrap.servers", "sandbox-hdp.hortonworks.com:6667")
    //    props.put("bootstrap.servers", args[0])
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    println("Create KafkaProducer")
    val producer = new KafkaProducer[String, String](props)
    val first = filtered.head
    producer.send(new ProducerRecord[String, String](topic, 1, s"${first.getId}", s"${first}"))

    producer.close()
  }

  def containWord(status: Status): Boolean = {
    words.exists(status.getText.contains)
  }

  def generateRecord(topic: String, i: Int, c: Int): ProducerRecord[String, String] = {
    new ProducerRecord(topic, "bookingId_" + i + "_" + c, "book_" + i + "_" + c)
  }
}
