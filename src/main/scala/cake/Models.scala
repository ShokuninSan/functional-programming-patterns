package cake

case class Movie(id: String, title: String)
case class Video(id: String)
case class DecoratedMovie(movie: Movie, video: Video)