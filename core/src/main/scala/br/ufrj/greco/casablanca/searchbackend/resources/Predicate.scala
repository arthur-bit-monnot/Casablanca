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
 
package br.ufrj.greco.casablanca.searchbackend.resources

class Predicate(uri:String) extends URI(uri) {

  /**
   * This key represent the variable name to store partial results in the SPARQL
   * query. 
   */
  val key = defaultKey

  def defaultKey = Predicate.getKey(xmlUri)
}


object Predicate {
  /**
   * A list of char alloweds in SPARQL variable names.
   */
  val allowedKeyChars = ('a' to 'z') ++ ('A' to 'Z') ++ ('0' to '9')

  def getKey(str:String) : String = 
    str.filter(allowedKeyChars.contains(_)).mkString
}