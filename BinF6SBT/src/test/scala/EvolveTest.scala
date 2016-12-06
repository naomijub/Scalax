import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._

/**
  * Created by jnaomi on 06/12/16.
  */
class EvolveTest extends FunSuite with BeforeAndAfter with MockitoSugar{
  var pop : Array[Array[Int]] = _
  val chromosome = new Chromosome
  val mockGenes = mock[Chromosome]

  before{
    pop = Array.fill[Array[Int]](100){chromosome.getGenes()}
    when(mockGenes.getGenes).thenReturn(Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0,
      1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1))
  }

  //This test may fail sometimes because it is possible for two genes to be equal
  test("test if genes are different"){
    for(i <- 1 until 100) {
      assert(chromosome == (pop(i - 1), pop(i)) == true)
    }
  }

  test("Test if X value is 100 for Mock Chromosome"){

    val x = chromosome.X(mockGenes.getGenes)
    println(x)
    assert(x.toInt == 100)
  }

  test("Test if Y is 33 for Mock Chromosome"){
    val y = chromosome.Y(mockGenes.getGenes)
    println(y)
    assert(y.toInt == 33)
  }

  test("Fitness for Mock Chromossome is "){
    val fit = chromosome.fitness(mockGenes.getGenes)
    assert(fit == 0.4100047789612904)
  }
}
