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
  val pop : Array[Array[Int]] = Array.fill[Array[Int]](100){chromosome.getGenes()}
  val mockGenes = mock[Chromosome]
  val mockGenes2 = mock[Chromosome]

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


}
