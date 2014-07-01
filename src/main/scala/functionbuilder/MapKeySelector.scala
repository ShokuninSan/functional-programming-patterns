package functionbuilder

import scala.annotation.tailrec

object MapKeySelector {

  def selector(path: Symbol*): (Map[Symbol, Any]) => Option[Any] = {

    if (path.length == 0)
      throw new IllegalArgumentException

    @tailrec
    def go(path: Seq[Symbol], ds: Map[Symbol, Any]): Option[Any] = {
      if (path.length == 1)
        ds.get(path(0))
      else
        ds.get(path.head) match {
          case Some(rest: Map[Symbol, Any]) => go(path.tail, rest)
          case _ => None
        }
    }

    (ds: Map[Symbol, Any]) =>  go(path.toSeq, ds)
  }

}
