package parsers

import model.{Snippet, Statistics, Video}
//import spray.json.JsonParser


object PraseVideoFromSatoriJson {

// def parceVideoJson(json:String):Video ={
//   val jsonAst = JsonParser(json)
//   val jsonObjFields= jsonAst.asJsObject.fields
////    val json = parse(json)
////    val data= Json.parse(json)
//    val id=jsonObjFields.get("id").get.toString()
//    val jsonSnippetObjFields=jsonObjFields.get("snippet").get.asJsObject.fields
//   val jsonStatObjFields=jsonObjFields.get("statistics").get.asJsObject.fields
////    val jsonStat=(data \ "statistics")
//   val sinppet=Snippet(jsonSnippetObjFields.get("published_at").get.convertTo[String],jsonSnippetObjFields.get("title").get.convertTo[String],jsonSnippetObjFields.get("description").get.convertTo[String],jsonSnippetObjFields.get("channel_title").get.convertTo[String],jsonSnippetObjFields.get("tags").get.convertTo[Array[String]])
////      val stat=Statistics((jsonStat \ "view_count").as[String],(jsonStat \ "like_count").as[String],(jsonStat \ "dislike_count").as[String])
//   val stat=Statistics(jsonSnippetObjFields.get("view_count").get.asInstanceOf[Int],jsonSnippetObjFields.get("like_count").get.asInstanceOf[Int],jsonSnippetObjFields.get("dislike_count").get.asInstanceOf[Int])
//
////   val sinppet=Snippet((jsonSnippet \ "published_at").as[String],(jsonSnippet \ "title").as[String],(jsonSnippet \ "description").as[String],(jsonSnippet \ "channel_title").as[String],(jsonSnippet \ "tags").as[Array[String]])
////    val stat=Statistics((jsonStat \ "view_count").as[String],(jsonStat \ "like_count").as[String],(jsonStat \ "dislike_count").as[String])
//
////val jsonAst = JsonParser(json)
////    jsonAst.prettyPrint
//   Video(id,sinppet,stat)
// }
}
