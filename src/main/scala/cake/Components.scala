package cake

trait MovieDaoComponent {
  trait MovieDao {
    def getMovie(id: String): Movie
  }
}

trait FavoritesServiceComponent {
  trait FavoritesService {
    def getFavoriteVideos(id: String): Vector[Video]
  }
}