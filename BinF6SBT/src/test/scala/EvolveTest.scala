import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
import org.scalatest.Assertions._

/**
  * Created by jnaomi on 06/12/16.
  */
class EvolveTest extends FunSuite with BeforeAndAfter{
  var pop : Array[Array[Int]] = _
  val chromosome = new Chromosome

  before{
    pop = Array.fill[Array[Int]](100){chromosome.getGenes()}
  }

  //This test may fail sometimes because it is possible for two genes to be equal
  test("test if genes are different"){
    for(i <- 1 until 100) {
      assert(chromosome == (pop(i - 1), pop(i)) == true)
    }
  }
}
