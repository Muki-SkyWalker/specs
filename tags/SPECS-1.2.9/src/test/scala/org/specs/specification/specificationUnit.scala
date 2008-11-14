package org.specs

import org.specs._
import org.specs.matcher._
import org.specs.Sugar._
import org.specs.runner._
import org.specs.util._
import scala.collection.mutable._
import scalacheck.Gen._
import org.specs.matcher.MatcherUtils._

class specificationUnitTest extends Runner(specificationUnit) with JUnit with Console
object specificationUnit extends Specification with Scalacheck {

  "A specification" should {
    "have a description corresponding to its unqualified class name, whatever the class name" in {
      def classNames = for {
        packageName <- elements("com", "scala")
        className <- elements(packageName + "s", packageName + ".specs", packageName + ".other.normal")
        name <- elements(className, className + "$inner", className + "$inner$", className + "$2", className + "$2$")
      } yield name

      classNames must pass { name : String => 
        specification.createDescription(name) must (not(beMatching("\\$")) and 
                                           not(beMatching("\\.")) and
                                           not(beInt))
      }
   }  
  "create a default sut and example if an assertion is created alone" in {
    object nudeSpec extends Specification {
        "name" mustEqual "name"
    }
      nudeSpec.suts.size mustBe 1
      nudeSpec.suts.head.examples.size mustBe 1
      nudeSpec.assertionsNb mustBe 1
   }

  }
  def isInt(s: String): Boolean = {try {s.toInt} catch {case _ => return false}; true}
  def beInt = new Matcher[String](){
    def apply(s: => String) = (isInt(s), q(s) + " is an integer", q(s) + " is not an integer")
  }
  object specification extends Specification
}


