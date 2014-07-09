package dsl

object Implicits {

  implicit class CommandString(commandString: String) {

    def sh = Command(commandString).run

    def |(nextCommand: String) = Vector(commandString, nextCommand)

  }

  implicit class CommandVector(previousCommands: Vector[String]) {

    def sh = {
      val commandString = previousCommands.mkString("|")
      Command("/bin/bash", "-c", commandString).run
    }

    def |(nextCommand: String) = {

    }
  }

}
