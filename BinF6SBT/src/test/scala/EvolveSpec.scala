import org.scalatest.FlatSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._

/**
  * Created by jnaomi on 06/12/16.
  */
class EvolveSpec extends FlatSpec with BeforeAndAfter with MockitoSugar{
  var evolve : Evolve = _
  val chromosome = new Chromosome
  val mockGenes = mock[Chromosome]
  val mockGenes2 = mock[Chromosome]
  val mockPop = Array(
    Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0,
      1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1),
    Array(1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0,
      1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
    Array(1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0,
      1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1),
    Array(1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0,
      1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1),
    Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0)
  )
  val mockTupleFitIdx = Array((0.5, 3), (0.94, 32), (0.2, 5), (0.8, 51), (0.17, 45))


  before {
    evolve = new Evolve
    when(mockGenes.getGenes).thenReturn(Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0,
      1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1))
    when(mockGenes2.getGenes).thenReturn(Array(1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0,
      1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1))
  }

  behavior of "evolve with mocked chromossomes"

  it should "return a different gene when mutating is invoked" in{
    //test may fail due to randomness
    val mutatedGenes = evolve.mutate(mockGenes.getGenes)
    assert(chromosome.==(mutatedGenes, mockGenes.getGenes) == true)
  }

  it should "return a mix of mock and mock2 by half/half" in {
    val crossedoverGenes = evolve.crossover(mockGenes.getGenes, mockGenes2.getGenes)
    val mockCrossGene = Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,0, 1, 0,
      1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    assert(chromosome.==(crossedoverGenes, mockCrossGene) == false)
  }

  it should "return the best fitness index within an Array of tuples(fitness, index)" in {
    val bestIndex = evolve.roulette(mockTupleFitIdx)
    assert(bestIndex == 32)
  }

  it should "check for the best chromossome" in {
    val bestGenesIdx = evolve.getBest(mockPop)
    assert(bestGenesIdx == 4)
  }
}
