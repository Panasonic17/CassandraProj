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
 }

  def main(args: Array[String]): Unit = {
    val text="x49T4Vyb7m0,1124,11,78783,Feb 24, 2015,MDK ft. Nick Sadler - Phoenix (Orchestral Mix) [Free Download],Buy MDK Merch: http://shop.morgandavidking.comFree Downloads: http://www.morgandavidking.com/free-d...Click “Show More�? to see the description & MDK social media pages ▼ Description:This is the third and final remix of Phoenix on this EP, and it's quite different from the other two. It's another orchestral mix, which I know you're all quite fond of. Hope you enjoy!Follow the official MDK social media pages to keep up to date with my latest releases ▼WEBSITE: http://www.morgandavidking.comSPOTIFY: http://open.spotify.com/artist/4AFmCA...YOUTUBE: http://www.youtube.com/MDKOfficialYTSOUNDCLOUD: http://www.soundcloud.com/MDKOfficialTWITTER: http://www.twitter.com/MDKOfficialINSTAGRAM: http://www.instagram.com/morgandavidkingFACEBOOK: http://www.facebook.com/MDKOfficialGOOGLE PLUS: http://www.google.com/+MDKOfficialYT,MDK,[\"Music\"]";
     parce(text)
  }
}
