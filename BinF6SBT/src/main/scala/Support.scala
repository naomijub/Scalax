import java.util.Calendar

/**
  * Created by jnaomi on 23/12/16.
  */
class Support {
  val popSize = 100
  val chromosome = new Chromosome
  val evolve = new Evolve

  def trueRand() : Int = {
    return (scala.util.Random.nextInt(101) + Calendar.getInstance().get(Calendar.MILLISECOND)) % popSize
  }

  def parent(pop: Array[Array[Int]]) : Tuple2[Double, Int] = {
    val rand = trueRand()
    return Tuple2(chromosome.fitness(pop(rand)), rand)
  }

  def crossoverManager (pop: Array[Array[Int]]) : Array[Int] = {
    val parent1 = for(i <- 1 to 5) yield parent(pop)
    val parent2 = for(i <- 1 to 5) yield parent(pop)
    return evolve.crossover(pop(evolve.roulette(parent1.toArray)), pop(evolve.roulette(parent2.toArray)))
  }
}
