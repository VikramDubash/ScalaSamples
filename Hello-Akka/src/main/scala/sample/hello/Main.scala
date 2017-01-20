package sample.hello

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props, Terminated}

/**
  * Created by vikra on 1/19/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {

    var system = ActorSystem("Hello");
    val a = system.actorOf(Props[HelloWorld], "helloWorld")
    system.actorOf(Props(classOf[Terminator], a), "terminator")
  }


  class Terminator(ref: ActorRef) extends Actor with ActorLogging {
    context watch ref

    def receive = {
      case Terminated(_) =>
        log.info("{} has terminated, shutting down system", ref.path)
        context.system.terminate()
    }
  }

}
