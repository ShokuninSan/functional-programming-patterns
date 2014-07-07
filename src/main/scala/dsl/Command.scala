package dsl

import scala.io.Source
import scala.collection.JavaConversions._

class Command(commandParts: List[String]) {

  def run = {
    val processBuilder = new ProcessBuilder(commandParts)
    val process = processBuilder.start()
    val status = process.waitFor()
    val output = Source.fromInputStream(process.getInputStream).mkString
    val error = Source.fromInputStream(process.getErrorStream).mkString
    CommandResult(status, output, error)
  }

}

object Command {
  def apply(commandString: String) = new Command(commandString.split("\\s").toList)
}