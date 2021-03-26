package music

import statistics.Statistics

import scala.io.Source

class Song(val title: String, val artist: String, val youtubeId: String, val ratings: List[SongRating]) {

  def averageRating(): Double = {
    // This is an example of calling your average function to get the average rating of a song
    Statistics.average(ratings, (rating: SongRating) => rating.rating)
  }

  def averageEnergyRating(): Double = {
    // This is an example of calling your average function to get the average energy rating of a song
    Statistics.average(ratings, (rating: SongRating) => rating.energy)
  }

  // comment this in when you complete LT3 to compute the bayesian average of song ratings
//  def bayesianRating(extraRatings: Int, valueOfExtraRatings: Int): Double = {
//    Statistics.bayesianAverage(this.ratings, (rating: SongRating) => rating.rating, extraRatings, valueOfExtraRatings)
//  }

}


object Song {


  def readSongsFromFile(filename: String): List[Song] = {
    // Read all lines of the file into a List
    val file = Source.fromFile(filename)
    val lines: List[String] = file.getLines().toList
    file.close()

    List()
    // TODO: Parse the lines and return a List of Songs containing all the information from the file
  }


  def makeIncubator(songs: List[Song]): List[Double] => Song = {
    genes: List[Double] => {
      // assumes there is only 1 gene and converts that Double to an Int and retrieves the song at
      // that position in the list
      val geneSong: Int = (genes.head.abs * songs.length).toInt % songs.length
      songs(geneSong)
    }
  }



}