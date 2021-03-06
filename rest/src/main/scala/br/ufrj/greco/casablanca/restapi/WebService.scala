/**
 * Copyright 2012 Arthur Bit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package br.ufrj.greco.casablanca.restapi

import javax.ws.rs.core.Response
import net.liftweb.json._

class WebService {

  /**
   * Format the the response string to enable cross domain access.
   */
  def ok(response : String ) : Response = {
    Response.ok().entity(response).header("Access-Control-Allow-Origin","*").build();
  }

  def json(xml : scala.xml.NodeSeq) : String = {
    val jval = Xml.toJson(xml)
    val valid = jval.transform(jsonTransform)
    Printer.compact(render(valid))
  }

  val jsonTransform : PartialFunction[JValue, JValue] = { case x => x}

}
