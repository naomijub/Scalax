import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite

/**
  * Created by jnaomi on 05/12/16.
  */
class GeneTests extends FunSuite with BeforeAndAfter {
  var gene: Chromosome = _

  before {
    gene = new Chromosome
  }

  describe("A Chromosome") {
    it("Sould have 44 genes"){
      assert(gene.getGenes.size == 44)
    }

  }

}
