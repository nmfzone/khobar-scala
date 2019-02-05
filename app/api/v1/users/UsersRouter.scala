package api.v1.users

import io.lemonlabs.uri.dsl._
import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class UsersRouter @Inject()(controller: UsersController) extends SimpleRouter {

  val prefix = "/api/v1/users"

  def link(id: String): String = {
    val url = prefix / id
    url.toString()
  }

  override def routes: Routes = {
    case GET(p"/") =>
      controller.index
  }

}
