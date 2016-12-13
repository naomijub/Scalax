
/**
  * Created by jnaomi on 06/12/16.
  */
class Evolve {
  val chromosomeSize = 44
  val geneValues = 2
  var rg = new scala.util.Random(141)

  def mutate(arg : Array[Int]) : Array[Int] = {
    val gene = rg.nextInt(413) % chromosomeSize
    val geneMutation = rg.nextInt(413) % geneValues
    val auxGene = arg.clone()
    auxGene(gene) = geneMutation

    return auxGene
  }

  def crossover(arg1: Array[Int], arg2 : Array[Int]) : Array[Int] = {
    val crossedGene = new Array[Int](44)

    return crossedGene
  }
}
