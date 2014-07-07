package dsl

object Implicits {

  implicit class CommandString(commandString: String) {
    def run = Command(commandString).run
  }

}
