package twitter4j

/**
 * Generate fake Tripper's status.
 */
object FakeTwStatusGen {
  def getTestTwStatus(): Status = {
    new StatusJSONImpl(new JSONObject(getRandomStrStatus()))
  }

  def genTwStatuses(count: Int): List[Status] = {
    List.fill(count)(new StatusJSONImpl(new JSONObject(getRandomStrStatus())))
  }

  def getRandomStrStatus(): String = {
    getFirstPart + genCoordinates(-97.51087576, 35.46500176) + "," + genPlace("US", "United States") + getLastPart
  }

  def genCoordinates(x: Double, y: Double): String = {
    s"""{"type": "Point", "coordinates": [$x, $y]}"""
  }

  def genPlace(cc: String, country: String): String = {
    s"""
      |"place": {
      |    "id": "07d9db48bc083000",
      |    "url": "https://api.twitter.com/1.1/geo/id/07d9db48bc083000.json",
      |    "place_type": "poi",
      |    "name": "McIntosh Lake",
      |    "full_name": "McIntosh Lake",
      |    "country_code": "$cc",
      |    "country": "$country",
      |    "bounding_box": {
      |      "type": "Polygon",
      |      "coordinates": [
      |        [
      |          [
      |            -105.14544,
      |            40.192138
      |          ],
      |          [
      |            -105.14544,
      |            40.192138
      |          ],
      |          [
      |            -105.14544,
      |            40.192138
      |          ],
      |          [
      |            -105.14544,
      |            40.192138
      |          ]
      |        ]
      |      ]
      |    },
      |    "attributes": {
      |    }
      |  }
      |""".stripMargin
  }

  private def getFirstPart = {
    """
      |{
      |  "created_at": "Mon May 06 20:01:29 +0000 2019",
      |  "id": 1125490788736032770,
      |  "id_str": "1125490788736032770",
      |  "text": "It is some text contain many good info about BigData, machine learning, etc.",
      |  "truncated": true,
      |  "entities": {
      |    "hashtags": [],
      |    "symbols": [],
      |    "user_mentions": [],
      |    "urls": [
      |      {
      |        "url": "https://t.co/Rbc9TF2s5X",
      |        "expanded_url": "https://twitter.com/i/web/status/1125490788736032770",
      |        "display_url": "twitter.com/i/web/status/1…",
      |        "indices": [
      |          117,
      |          140
      |        ]
      |      }
      |    ]
      |  },
      |  "metadata": {
      |    "iso_language_code": "en",
      |    "result_type": "recent"
      |  },
      |  "source": "<a href=\"https://mobile.twitter.com\" rel=\"nofollow\">Twitter Web App</a>",
      |  "in_reply_to_status_id": null,
      |  "in_reply_to_status_id_str": null,
      |  "in_reply_to_user_id": null,
      |  "in_reply_to_user_id_str": null,
      |  "in_reply_to_screen_name": null,
      |  "user": {
      |    "id": 2244994945,
      |    "id_str": "2244994945",
      |    "name": "Twitter Dev",
      |    "screen_name": "TwitterDev",
      |    "location": "Internet",
      |    "description": "Your official source for Twitter Platform news, updates & events. Need technical help? Visit https://t.co/mGHnxZU8c1 ⌨️ #TapIntoTwitter",
      |    "url": "https://t.co/FGl7VOULyL",
      |    "entities": {
      |      "url": {
      |        "urls": [
      |          {
      |            "url": "https://t.co/FGl7VOULyL",
      |            "expanded_url": "https://developer.twitter.com/",
      |            "display_url": "developer.twitter.com",
      |            "indices": [
      |              0,
      |              23
      |            ]
      |          }
      |        ]
      |      },
      |      "description": {
      |        "urls": [
      |          {
      |            "url": "https://t.co/mGHnxZU8c1",
      |            "expanded_url": "https://twittercommunity.com/",
      |            "display_url": "twittercommunity.com",
      |            "indices": [
      |              93,
      |              116
      |            ]
      |          }
      |        ]
      |      }
      |    },
      |    "protected": false,
      |    "followers_count": 501947,
      |    "friends_count": 1473,
      |    "listed_count": 1507,
      |    "created_at": "Sat Dec 14 04:35:55 +0000 2013",
      |    "favourites_count": 2186,
      |    "utc_offset": null,
      |    "time_zone": null,
      |    "geo_enabled": true,
      |    "verified": true,
      |    "statuses_count": 3389,
      |    "lang": "en",
      |    "contributors_enabled": false,
      |    "is_translator": false,
      |    "is_translation_enabled": null,
      |    "profile_background_color": "null",
      |    "profile_background_image_url": "null",
      |    "profile_background_image_url_https": "null",
      |    "profile_background_tile": null,
      |    "profile_image_url": "null",
      |    "profile_image_url_https": "https://pbs.twimg.com/profile_images/880136122604507136/xHrnqf1T_normal.jpg",
      |    "profile_banner_url": "https://pbs.twimg.com/profile_banners/2244994945/1498675817",
      |    "profile_link_color": "null",
      |    "profile_sidebar_border_color": "null",
      |    "profile_sidebar_fill_color": "null",
      |    "profile_text_color": "null",
      |    "profile_use_background_image": null,
      |    "has_extended_profile": null,
      |    "default_profile": false,
      |    "default_profile_image": false,
      |    "following": false,
      |    "follow_request_sent": false,
      |    "notifications": false,
      |    "translator_type": "null"
      |  },
      |  "geo": null,
      |  "coordinates": """.stripMargin
  }

  private def getLastPart = {
    """,
      |  "contributors": null,
      |  "is_quote_status": true,
      |  "quoted_status_id": 1125479034513645569,
      |  "quoted_status_id_str": "1125479034513645569",
      |  "quoted_status": {
      |    "created_at": "Mon May 06 19:14:46 +0000 2019",
      |    "id": 1125479034513645569,
      |    "id_str": "1125479034513645569",
      |    "text": "It's easy to express yourself by Retweeting with a comment. What if you could take it a step further and include me… https://t.co/YTqpNZZ8M9",
      |    "truncated": true,
      |    "entities": {
      |      "hashtags": [],
      |      "symbols": [],
      |      "user_mentions": [],
      |      "urls": [
      |        {
      |          "url": "https://t.co/YTqpNZZ8M9",
      |          "expanded_url": "https://twitter.com/i/web/status/1125479034513645569",
      |          "display_url": "twitter.com/i/web/status/1…",
      |          "indices": [
      |            117,
      |            140
      |          ]
      |        }
      |      ]
      |    },
      |    "metadata": {
      |      "iso_language_code": "en",
      |      "result_type": "recent"
      |    },
      |    "source": "<a href=\"http://twitter.com\" rel=\"nofollow\">Twitter Web Client</a>",
      |    "in_reply_to_status_id": null,
      |    "in_reply_to_status_id_str": null,
      |    "in_reply_to_user_id": null,
      |    "in_reply_to_user_id_str": null,
      |    "in_reply_to_screen_name": null,
      |    "user": {
      |      "id": 17874544,
      |      "id_str": "17874544",
      |      "name": "Twitter Support",
      |      "screen_name": "TwitterSupport",
      |      "location": "Twitter HQ",
      |      "description": "Your official source for Twitter Support. We're available 24/7 via Direct Message to answer account questions. Follow us for tips, tricks, and announcements.",
      |      "url": "https://t.co/heEvRrl4yN",
      |      "entities": {
      |        "url": {
      |          "urls": [
      |            {
      |              "url": "https://t.co/heEvRrl4yN",
      |              "expanded_url": "https://help.twitter.com",
      |              "display_url": "help.twitter.com",
      |              "indices": [
      |                0,
      |                23
      |              ]
      |            }
      |          ]
      |        },
      |        "description": {
      |          "urls": []
      |        }
      |      },
      |      "protected": false,
      |      "followers_count": 5861908,
      |      "friends_count": 17,
      |      "listed_count": 15129,
      |      "created_at": "Thu Dec 04 18:51:57 +0000 2008",
      |      "favourites_count": 313,
      |      "utc_offset": null,
      |      "time_zone": null,
      |      "geo_enabled": true,
      |      "verified": true,
      |      "statuses_count": 27955,
      |      "lang": "en",
      |      "contributors_enabled": false,
      |      "is_translator": false,
      |      "is_translation_enabled": null,
      |      "profile_background_color": "null",
      |      "profile_background_image_url": "null",
      |      "profile_background_image_url_https": "null",
      |      "profile_background_tile": null,
      |      "profile_image_url": "null",
      |      "profile_image_url_https": "https://pbs.twimg.com/profile_images/941807338171777025/PRP6vwDq_normal.jpg",
      |      "profile_banner_url": "https://pbs.twimg.com/profile_banners/17874544/1499274456",
      |      "profile_link_color": "null",
      |      "profile_sidebar_border_color": "null",
      |      "profile_sidebar_fill_color": "null",
      |      "profile_text_color": "null",
      |      "profile_use_background_image": null,
      |      "has_extended_profile": null,
      |      "default_profile": false,
      |      "default_profile_image": false,
      |      "following": false,
      |      "follow_request_sent": false,
      |      "notifications": false,
      |      "translator_type": "null"
      |    },
      |    "geo": null,
      |    "coordinates": null,
      |    "place": null,
      |    "contributors": null,
      |    "is_quote_status": false,
      |    "retweet_count": 1466,
      |    "favorite_count": 3990,
      |    "favorited": false,
      |    "retweeted": false,
      |    "possibly_sensitive": false,
      |    "lang": "en"
      |  },
      |  "retweet_count": 20,
      |  "favorite_count": 44,
      |  "favorited": false,
      |  "retweeted": false,
      |  "possibly_sensitive": false,
      |  "lang": "en"
      |}
    """.stripMargin
  }
}
