import Array._
/**
  * Created by jnaomi on 06/12/16.
  */
class Evolve {
  val chromosomeSize = 44
  val geneValues = 2
  var rg = new scala.util.Random(141)
  val chromosome = new Chromosome

  def mutate(arg : Array[Int]) : Array[Int] = {
    val gene = rg.nextInt(413) % chromosomeSize
    val geneMutation = rg.nextInt(413) % geneValues
    val auxGene = arg.clone()
    auxGene(gene) = geneMutation

    return auxGene
  }

  def crossover(arg1: Array[Int], arg2 : Array[Int]) : Array[Int] = {
    val crossedGene1 = for (i <- 0 until chromosomeSize if i < chromosomeSize/2) yield arg1(i)
    val crossedGene2 = for (i <- 0 until chromosomeSize if i >= chromosomeSize/2 && i < chromosomeSize) yield arg2(i)
    val crossedGene = concat(crossedGene1.toArray, crossedGene2.toArray)

    return crossedGene
  }

  def max(arg1: Tuple2[Double, Int], arg2 : Tuple2[Double, Int]): Tuple2[Double, Int] = if (arg1._1 > arg2._1) arg1 else arg2

  def roulette(arg1 : Array[Tuple2[Double, Int]]) : Int = {
    val bestIndex = arg1.reduceLeft(max)
    return bestIndex._2
  }

  //should return the whole array
  def getBest(arg1: Array[Array[Int]]) : Int = {
    def generateTuplesIdxFit(chromArg: Array[Int], idx: Int) : Tuple2[Double, Int] = {
      return Tuple2[Double, Int](chromosome.fitness(chromArg), idx)
    }
    val popTuples = for(i <- 0 until arg1.length) yield generateTuplesIdxFit(arg1(i), i)
    val bestIndex = popTuples.reduceLeft(max)
    return bestIndex._2
  }
}
