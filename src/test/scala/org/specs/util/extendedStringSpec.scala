package org.specs.util
import org.specs._
import org.specs.runner._
import org.specs.util.ExtendedString._

class extendedStringSpec extends Specification with JUnit with DataTables {
  "the uncapitalize function" should {
    "lower-case only the first letter of a string" in {
      "Hello".uncapitalize must_== "hello"
    }
    "lower-case only the first letter of a one letter string" in {
      "H".uncapitalize must_== "h"
    }
  }
  "the uncamel function" should {
    "uncapitalize words except the first one and insert spaces in a camel word" in {
      "source"      | "target"          |>
      ""            ! ""                |  
      "my"          ! "my"              |  
      "My"          ! "My"              |  
      "MyClass"     ! "My class"        |  
      "myClass"     ! "my class"        |  
      "MyClassName" ! "My class name"   | { (source, target) => 
        source.uncamel must_== target 
      }
    }
  }
  "the removeAll function" should {
    "remove a simple character" in {
      "hello".removeAll("l") must_== "heo"
    }
    "remove two characters" in {
      "hello".removeAll("lo") must_== "hel"
    }
    "remove regexp characters" in {
      "he(l)(l)o".removeAll(")(") must_== "he(ll)o"
    }
  }
  "the removeFrom function" should {
    "remove everything from a given substring" in {
      "hello$world$hi".removeFrom("$") must_== "hello"
    }
  }
  "the groups function" should {
    "return Nil if the pattern is null" in {
      "hello".groups(null) must beEmpty
    }
    "return Nil if no group is found in a string according to a pattern" in {
      "hello".groups("(z)") must beEmpty
    }
    "return Nil if no group is found in a string according to a pattern, even if parenthesis are omitted" in {
      "hello".groups("z") must beEmpty
    }
    "return the found group if there is only one" in {
      "hello".groups("(e)") must_== List("e")
    }
    "return the found groups when there are several" in {
      "hello".groups("(l)") must_== List("l", "l")
    }
    "return nothing if the parenthesis are omitted, even if there's a match" in {
      "hello".groups("l") must beEmpty
    }
  }
  "the replaceGroups function" should {
    "leave the string as it is if nothing is found" in {
      "hello".replaceGroups("(z)", (s: String) => s.size) must_== "hello"
    }
    "replace every found group with the application of a function" in {
      "hello".replaceGroups("(l)", (s: String) => s.size) must_== "he11o"
    }
    "replace every found group with the application of a function, replacing only the group" in {
      "wor<code>l</code>d".replaceGroups("<code>(l)</code>", (s: String) => s.size) must_== "wor<code>1</code>d"
    }
  }
  "the findAll function" should {
    "return Nil if the pattern is null" in {
      "hello".findAll(null) must beEmpty
    }
    "return Nil if no group is found in a string according to a pattern" in {
      "hello".findAll("z") must beEmpty
    }
    "return the found group if there is only one" in {
      "hello".findAll("e") must_== List("e")
    }
    "return the found groups when there are several" in {
      "hello".findAll("l") must_== List("l", "l")
    }
  }
}
