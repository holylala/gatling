/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.http.check.url

import io.gatling.core.check.DefaultFindCheckBuilder
import io.gatling.core.check.extractor.Extractor
import io.gatling.core.session.ExpressionWrapper
import io.gatling.core.validation.SuccessWrapper
import io.gatling.http.check.HttpCheck
import io.gatling.http.check.HttpCheckBuilders._
import io.gatling.http.response.Response

object CurrentLocationCheckBuilder {

  val CurrentLocationExtractor = new Extractor[Response, String] {
    val name = "currentLocation"
    def apply(prepared: Response) = Some(prepared.request.getUrl).success
  }.expression

  val CurrentLocation = new DefaultFindCheckBuilder[HttpCheck, Response, Response, String](
    UrlExtender,
    PassThroughResponsePreparer,
    CurrentLocationExtractor)
}
