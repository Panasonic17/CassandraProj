package parsers

import model.Video

/**
  * Created by Oleksandr_Shainoga on 11/6/2017.
  */
object CSVToVideo {
 def parce(row:String): Video ={
   val data=row.split(",")
   val tags=row.split(",[\"")(1).replace("]","").replace("\"","").replace(","," ").split(" ")
   Video(data(0),data(4),data(5),data(6),data(7),tags,data(3).asInstanceOf[Int],data(1).asInstanceOf[Int],data(2).asInstanceOf[Int])
   //case class Video (id:,published_at:,title:,description:,channel_title:,tags:Array[String],view_count:,like_count:,dislike_count:)
//   row.append(jsonObject.get("id") + ",") 0
//   row.append(stat.get("like_count") + ",")1
//   row.append(stat.get("dislike_count") + ",")2
//   row.append(stat.get("view_count") + ",")3
//   row.append(snippet.get("published_at") + ",")4
//   row.append(snippet.get("title").toString.trim.replace("\n", "") + ",")5
//   row.append(description + ",")6
//   row.append(snippet.get("channel_title") + ",")7
//   row.append(snippet.get("tags"))8
 }
}
