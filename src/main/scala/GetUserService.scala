import Users.sample
import zio.{Has, Ref, UIO, URIO, ZLayer}

object GetUserService {

  type GetUserService = Has[Service]

  trait Service {
    def findUsers: UIO[Seq[UserSchema]]

    def findByUserId(id: Int): UIO[Option[UserSchema]]
  }

  def findUsers: URIO[GetUserService, Seq[UserSchema]] = URIO.accessM(_.get.findUsers)

  def findUser(id: Int): URIO[GetUserService, Option[UserSchema]] = URIO.accessM(_.get.findByUserId(id))

  def make(initial: Seq[UserSchema] = sample): ZLayer[Any, Nothing, GetUserService] = ZLayer.fromEffect {
    for {
      users <- Ref.make(initial)
    } yield new Service {

      def findUsers: UIO[Seq[UserSchema]] = users.get

      def findByUserId(id: Int): UIO[Option[UserSchema]] = users.get.map(_.find(c => c.id == id))
    }
  }

}
