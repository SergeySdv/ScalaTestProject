sealed trait Json

final case class JsObject(get: Map[String, Json]) extends Json

final case class JsString(get: String) extends Json

final case class JsNumber(get: Double) extends Json

case object JsNull extends Json

// Serialise to Json
trait JsonWriter[A] {
  def write(value: A): Json
}

final case class Person(name: String, email: String)

object JsonWriterInstances {
  implicit val StingWriter: JsonWriter[String] =
    new JsonWriter[String] {
      def write(value: String): Json =
        JsString(value)
    }

  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      def write(value: Person): Json =
        JsObject(Map(
          "name" -> JsString(value.name),
          "email" -> JsString(value.email)
        ))
    }
}

object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json =
    w.write(value)
}

import JsonWriterInstances._

Json.toJson(Person("Dave", "dave@emample.com"))

def implicitly[A](implicit value: A): A =
  value

implicitly[JsonWriter[String]]

implicit def optionWriter[A]
(implicit writer: JsonWriter[A]): JsonWriter[Option[A]] =
  new JsonWriter[Option[A]] {
    def write(option: Option[A]): Json =
      option match {
        case Some(aValue) => writer.write(aValue)
        case None => JsNull
      }
  }

Json.toJson((Option("Simple string")))


