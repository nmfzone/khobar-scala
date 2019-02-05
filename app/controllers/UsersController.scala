package controllers

import javax.inject._
import play.api.mvc._
import scala.Array._

@Singleton
class UsersController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val users = range(1, 20)

    Ok(views.html.users.index(users))
  }

}
