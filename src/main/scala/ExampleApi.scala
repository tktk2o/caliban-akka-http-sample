import GetUserService.GetUserService
import caliban.GraphQL.graphQL
import caliban.schema.GenericSchema
import caliban.{ GraphQL, RootResolver }
import zio.URIO
import zio.clock.Clock
import zio.console.Console

import scala.language.postfixOps

object ExampleApi extends GenericSchema[GetUserService] {

  case class Queries(
    users: URIO[GetUserService, Seq[UserSchema]],
    user: UserIdArgs => URIO[GetUserService, Option[UserSchema]]
  )

  val api: GraphQL[Console with Clock with GetUserService] =
    graphQL(
      RootResolver(
        Queries(
          GetUserService.findUsers,
          args => GetUserService.findUser(args.id)
        )
      )
    )

}
