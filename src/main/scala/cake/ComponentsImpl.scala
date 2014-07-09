package cake

trait MovieDaoComponentImpl extends MovieDaoComponent {
  class MovieDaoImpl extends MovieDao {
    def getMovie(id: String): Movie = new Movie("42", "A Movie")
  }
}

trait FavoritesServiceComponentImpl extends FavoritesServiceComponent {
  class FavoritesServiceImpl extends FavoritesService {
    def getFavoriteVideos(id: String): Vector[Video] = Vector(new Video("1"))
  }
}

trait MovieServiceComponentImpl {
  this: MovieDaoComponent with FavoritesServiceComponent =>

  val favoritesService: FavoritesService
  val movieDao: MovieDao

  class MovieServiceImpl {
    def getFavoriteDecoratedMovies(userId: String): Vector[DecoratedMovie] =
    for (
      favoriteVideo <- favoritesService.getFavoriteVideos(userId);
      val movie = movieDao.getMovie(favoriteVideo.id)
    ) yield DecoratedMovie(movie, favoriteVideo)
  }
}
