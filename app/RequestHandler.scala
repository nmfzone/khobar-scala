import javax.inject.Inject
import play.api.http._
import play.api.mvc._
import play.api.mvc.request.RequestTarget
import play.api.routing.Router

class RequestHandler @Inject() (router: Router,
                                errorHandler: HttpErrorHandler,
                                configuration: HttpConfiguration,
                                filters: HttpFilters)
  extends DefaultHttpRequestHandler(router, errorHandler, configuration, filters) {

  override def handlerForRequest(request: RequestHeader): (RequestHeader, Handler) = {
    super.handlerForRequest {
      if (isApi(request)) {
        addTrailingSlash(request)
      } else {
        request
      }
    }
  }

  /**
    * Determine the request is on API uri.
    *
    * @param request The request
    * @return Boolean indicates the request is on API uri or not.
    */
  private def isApi(request: RequestHeader) = {
    request.uri.startsWith("/api/")
  }

  private def addTrailingSlash(request: RequestHeader): RequestHeader = {
    if (! request.path.endsWith("/")) {
      val path = request.path + "/"
      if (request.rawQueryString.isEmpty) {
        request.withTarget(
          RequestTarget(path = path, uriString = path, queryString = Map())
        )
      } else {
        request.withTarget(
          RequestTarget(path = path,
            uriString = request.uri,
            queryString = request.queryString)
        )
      }
    } else {
      request
    }
  }

}
