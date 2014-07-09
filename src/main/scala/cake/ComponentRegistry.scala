package cake

object ComponentRegistry extends MovieServiceComponentImpl with FavoritesServiceComponentImpl with MovieDaoComponentImpl {

  val favoritesService = new FavoritesServiceImpl
  val movieDao = new MovieDaoImpl
  val movieService = new MovieServiceImpl
}
