package org.specs
import org.specs.runner._
import org.specs.matcher._
import org.specs.samples._
import org.specs.mock._
import org.specs.specification._
import org.specs._
import org.specs.io._
import org.specs.collection._
import org.specs.util._


object allSpecsSuite extends JUnit3(allSpecs)
object allSpecs extends Specification {
    "The specifications" areSpecifiedBy (
        fileSystemSpec,  
        fileWriterSpec,  
        allUtilSpec,
        matchersSpec, 
        specificationSpec, 
        sugarSpec, 
        consoleReporterSpec,  
        beforeAfterSpec, 
        specsFinderSpec,
        specsRunnerSpec,
        stackSpecification,
        junit3TestSuiteSpec,
        xmlRunnerSpec,
        mocksSpec)
}

object allUnits extends Specification {
  "The unit tests" areSpecifiedBy (
      extendedThrowableUnit,
      fileSystemUnit, 
      collectionUnit,  
      allUtilUnit, 
      specificationUnit, 
      allMatchersUnit, 
      protocolsUnit,
      xmlRunnerUnit)
}

object allSpecsAndUnits extends Specification {
  "The specs and unit tests for the specs project" areSpecifiedBy (allSpecs, allUnits)
}
object allRunner extends ConsoleRunner(allSpecsAndUnits)
object all extends JUnit3(allSpecsAndUnits)
object allXml extends XmlRunner(allSpecsAndUnits)