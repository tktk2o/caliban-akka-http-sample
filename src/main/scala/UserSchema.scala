case class UserSchema(id: Int, name: String)
case class UserIdArgs(id: Int) extends AnyVal

object Users {

  val sample = Seq(
    UserSchema(1, "name1"),
    UserSchema(2, "name2")
  )

}
