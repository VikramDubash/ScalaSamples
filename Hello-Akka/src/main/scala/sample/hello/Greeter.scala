package sample.hello

import akka.actor.{Actor, ActorLogging}

/**
  * Created by vikra on 1/19/2017.
  */


object Greeter {

  case object Greet

  case object Done

}

class Greeter extends Actor with ActorLogging {

  override def receive: Receive = {
    case Greeter.Greet => {
      log.info("Received Greeting")
      sender() ! Greeter.Done
    }
  }
}
