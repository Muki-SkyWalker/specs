package scala.specs
import scala.specs.runner._
import scala.specs.matcher._
import scala.io._
import scala.util._
import scala.specs.mock._
import scala.specs.runner._
import scala.specs.specification._
import scala.specs.samples._

object allSpecsSuite extends JUnit3(allSpecs)
object allSpecs extends Specification {
    "The specifications" areSpecifiedBy (
        fileWriterSpec,  
        timerSpec,
        matchersSpec, 
        specificationSpec, 
        sugarSpec, 
        consoleReporterSpec,  
        beforeAfterSpec, 
        specsFinderSpec,
        specsRunnerSpec,
        stackSpecification,
        junit3TestSuiteSpec,
        mocksSpec)
}

object allUnits extends Specification {
  "The unit tests" areSpecifiedBy (
      fileSystemUnit,  
      extendedIterableUnit,  
      extendedListUnit,  
      specificationUnit, 
      allMatchersUnit, 
      protocolsUnit)
}

object allSpecsAndUnits extends Specification {
  "The specs and unit tests for the specs project" areSpecifiedBy (allSpecs, allUnits)
}
object allRunner extends ConsoleRunner(allSpecsAndUnits)
object all extends JUnit3(allSpecsAndUnits)