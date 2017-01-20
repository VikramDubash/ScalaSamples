package sample.hello

import akka.actor.{Actor, ActorLogging, Props}

/**
  * Created by vikra on 1/19/2017.
  */
class HelloWorld extends Actor with ActorLogging {


  override def preStart(): Unit = {
    log.info("Starting Hello World Actor");

    val greeter = context.actorOf(Props[Greeter], "greeter");

    greeter ! Greeter.Greet
  }

  override def receive: Receive = {
    case Greeter.Done => {
      log.info("Received Done")
      context.stop(self)
    }
  }
}
