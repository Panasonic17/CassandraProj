package model

case class Snippet(published_at: String, title: String, description: String, channel_title: String, tags: Array[String]) {
  override def toString = "published_at =" + published_at + '\n' +
                          "title =" + title + '\n' +
                          "description =" + description + '\n' +
                          "channel_title =" + channel_title + '\n' +
                          "tags =" + tags + '\n'

}