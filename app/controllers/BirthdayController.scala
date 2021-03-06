package controllers

import akka.util.Timeout
import com.typesafe.scalalogging.LazyLogging
import javax.inject._
import org.webjars.play.WebJarsUtil
import play.api.mvc._

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.DurationInt

@Singleton
class BirthdayController @Inject()(val controllerComponents: ControllerComponents,
                                   implicit val webJarsUtil: WebJarsUtil
                                 )
                                  (implicit val ec: ExecutionContext)
  extends BaseController with LazyLogging {

  implicit val defaultTimeout: Timeout = Timeout(60.seconds)

  def index: Action[AnyContent] = Action {
    Ok(views.html.birthday_congratulation())
  }

}
