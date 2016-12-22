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
    assert(chromosome.getGenes.length == 44)
  }

  it should "have all genes 0 or 1" in {
    var i = 0
    for(i <- chromosome.getGenes){
      assert(i == 0 || i == 1)
    }
  }

}