package api.v1.users

import javax.inject._
import play.api.mvc._
import play.api.libs.json.Json

@Singleton
class UsersController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val users: Map[String, String] = Map("message"->"Users listing", "status"->"200")

    val users2 = users.map({ case (k,v) => k -> (v + "hai") })
    print(users2)

    Ok(Json.toJson(users))
  }

}
