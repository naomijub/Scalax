
/**
  * Created by jnaomi on 23/12/16.
  */
object App {
  val chromosome = new Chromosome
  val evolve = new Evolve
  val suprt = new Support
  val popSize = 100


  def main(args: Array[String]): Unit ={
    var pop = for(i <- 0 until popSize) yield chromosome.getGenes()
    var bestFit : Double = 0.0
    var bestChromosome : String = " "

    while (bestFit < 0.99) {
      val popCrossOver = for (j <- 0 until popSize) yield suprt.crossoverManager(pop.toArray)

      val popMutate = for (j <- 0 until popSize) yield evolve.mutate(popCrossOver(j))

      val best = evolve.getBest(popMutate.toArray)
      println(best._1.toList.toString())


      pop = popMutate
      bestFit = chromosome.fitness(best._1)
      bestChromosome = best._1.toList.toString()
    }

    println(bestChromosome, " Fitness: ", bestFit.toString)
  }


}
