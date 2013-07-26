package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  val loggerServer = Logger
  val loggerClient = Logger("client")

  def index = Action {
    loggerServer.error("server")
    loggerClient.error("client")
    Ok(views.html.index())
  }

  def p1 = Action {
    Ok(views.html.page1())
  }

  def p2 = Action {
    Ok(views.html.page2())
  }

  def p3 = Action {
    Ok(views.html.page3())
  }

  def p4 = Action {
    Ok(views.html.page4())
  }

  def p5 = Action {
    Ok(views.html.page5())
  }
}
