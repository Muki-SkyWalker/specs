package scala.specs.mock
import scala.specs.runner._


object mocksUnit extends JUnit3(
    protocolsUnit)
object protocolsUnit extends Specification {
  "Mocks protocols" areSpecifiedBy (inAnyOrderUnit,
                                    inSequenceUnit,
                                    numberOfMessagesUnit,
                                    mockerUnit)
}
