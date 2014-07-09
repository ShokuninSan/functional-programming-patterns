import cake._
import dsl.CommandResult
import org.scalatest.{Matchers, FlatSpec}

class CakeSpec  extends FlatSpec with Matchers {

  trait MovieDaoComponentTestImpl extends MovieDaoComponent {
    class MovieDaoTestImpl extends MovieDao {
      override def getMovie(id: String): Movie = new Movie("42", "A test movie")
    }
  }

  trait FavoritesServiceComponentTestImpl extends FavoritesServiceComponent {
    class FavoritesServiceTestImpl extends FavoritesService {
      override def getFavoriteVideos(id: String): Vector[Video] = Vector(new Video("2"))
    }
  }

  object TestComponentRegistry extends MovieServiceComponentImpl with MovieDaoComponentTestImpl with FavoritesServiceComponentTestImpl {
    val favoritesService = new FavoritesServiceTestImpl
    val movieDao = new MovieDaoTestImpl
    val movieService = new MovieServiceImpl
  }

  "A TestComponentRegistry" should "return a result from movieService" in {
    val result = TestComponentRegistry.movieService.getFavoriteDecoratedMovies("2")
    result.size shouldEqual(1)
  }

}