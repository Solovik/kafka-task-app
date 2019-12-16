package com.solovik.kafkaapp

import twitter4j.{FakeTwStatusGen, GeoQuery, Status, StatusDeletionNotice, StreamListener, TwitterStreamFactory}

object TwProducer {


  def main(args: Array[String]): Unit = {
    val twStatus = FakeTwStatusGen.getTwStatus()
    println(twStatus.getUser.getName)
    val gl = twStatus.getGeoLocation
    println(gl)
    val gq: GeoQuery = new GeoQuery(gl)
    println(gq)

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


}
