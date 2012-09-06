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
 
package br.ufrj.greco.casablanca.searchbackend.searchcomponents

import br.ufrj.greco.casablanca.searchbackend._
import br.ufrj.greco.casablanca.searchbackend.resources._
import scala.collection.mutable.ArrayBuffer

trait SearchComponent {

  val result : Option[Variable]
  val key = SearchComponent.getFreeID
  val optional = false
  var lines = new ArrayBuffer[SparqlLine]()

  def addLine(s:Resource, p:Resource, o:Resource) {
    val line = new SparqlLine(s, p, o)
    lines += line
  }
}

object SearchComponent {

  private var IDCount = 0

  def getFreeID : String = {
    this.synchronized {
      IDCount += 1
      IDCount.toString
    }
  }
  
}




