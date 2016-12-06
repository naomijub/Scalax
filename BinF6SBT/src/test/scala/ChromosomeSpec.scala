import org.scalatest.FlatSpec
import org.scalatest.BeforeAndAfter

/**
  * Created by jnaomi on 06/12/16.
  */
class ChromosomeSpec extends FlatSpec with BeforeAndAfter{
  var chromosome : Chromosome = _

  before{
    chromosome = new Chromosome
  }

  behavior of "a Chromosome in BinaryF6"

  it should "have 44 genes" in {
    assert(chromosome.getGenes.size == 44)
  }

}