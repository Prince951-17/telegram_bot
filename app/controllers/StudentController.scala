package controllers


import java.util.Date
import java.util.concurrent.TimeUnit

import akka.actor.{ActorRef, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import com.typesafe.scalalogging.LazyLogging
import javax.inject._
import org.webjars.play.WebJarsUtil
import play.api.libs.json.Json
import play.api.mvc._
import protocols.StudentProtocol.{AddStudent, Student}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.{DurationInt, _}

@Singleton
class StudentController @Inject()(val controllerComponents: ControllerComponents,
                                  @Named("student-manager") val studentManager: ActorRef,
                                  implicit val webJarsUtil: WebJarsUtil
                                 )
                                 (implicit val ec: ExecutionContext)
  extends BaseController with LazyLogging {

  implicit val defaultTimeout: Timeout = Timeout(60.seconds)

  def index: Action[AnyContent] = Action {
    Ok(views.html.student(""))
  }

  def studentPost = {
    (studentManager ? AddStudent(Student(None, "Maftunbek", "Raxmatov", new Date, 123546))).mapTo[Int].map { pr =>
      Ok(Json.toJson(s"ajji: $pr"))
    }
  }

  def getStudentByBirthday = {
    (studentManager ? AddStudent(Student(None, "Maftunbek", "Raxmatov", new Date, 123546))).mapTo[Int].map { pr =>
      Ok(Json.toJson(s"ajji: $pr"))
    }
  }

}
