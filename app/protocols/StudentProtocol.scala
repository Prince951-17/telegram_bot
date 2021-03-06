package protocols

import java.util.Date

import play.api.libs.json.{Json, OFormat}

object StudentProtocol {

  case object GetStudents

  case class AddStudent(student: Student)

  case class UpdateStudents(update: Student)

  case class DeleteStudents(id: Int)

  case class Student(id: Option[Int] = None,
                     first_name: String,
                     last_name: String,
                     birthDay: Date,
                     telegram_id: Int
                    )

  implicit val studentFormat: OFormat[Student] = Json.format[Student]

  case class FindBirthday(birthday: Date)

  implicit val FindFormat: OFormat[FindBirthday] = Json.format[FindBirthday]


}

