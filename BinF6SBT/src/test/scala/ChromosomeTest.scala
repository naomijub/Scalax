import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
/**
  * Created by jnaomi on 23/12/16.
  */
class ChromosomeTest extends FunSuite with BeforeAndAfter{
  val chromosome = new Chromosome
  val fitOnes : Array[Int] = Array.fill[Int](44)(1)
  val fitOne : Array[Int] = Array.fill[Int](44)(0)
  val fitZero : Array[Int] = (for (i <- 0 until 44) yield if (i % 2 == 0)  0 else 1).toArray

  test("chromossome fitZero has fitness == 0"){
    assert(chromosome.fitness(fitZero) == 0)
  }

  test("chromossome fitOne has fitness == 1"){
    assert(chromosome.fitness(fitOne) == 1)
  }

  test("chromossome fitOnes has fitness == 1"){
    assert(chromosome.fitness(fitOnes) == 1)
  }
}

