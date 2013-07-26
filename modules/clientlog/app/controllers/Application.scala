package controllers.clientlog

import play.api._
import play.api.mvc._

import play.api.Play.current
import play.api.libs._
import play.api.libs.iteratee._
import play.api.libs.json._
import scala.language.reflectiveCalls
import utils._

object Application extends Controller {

  val ( output, channel ) = Concurrent.broadcast[JsValue]

  def index = Action {
    Ok(views.html.clientlog.index(current))
  }

  def live = Action {
    Ok.feed(
    output &>
        EventSource[JsValue]() ><>
    Enumeratee.map(_.getBytes("UTF-8"))
      ).as("text/event-stream")
  }

  def push = Action {
    LiveLogger.error(Json.obj( "error" -> "nnnn", "name" -> "toto" ))
    Ok( "Pushed")
  }

}

object Assets extends controllers.AssetsBuilder