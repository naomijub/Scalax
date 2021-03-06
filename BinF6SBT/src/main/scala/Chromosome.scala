import java.util.Calendar
/**
  * Created by jnaomi on 06/12/16.
  */
class Chromosome {
  def getGenes() : Array[Int] = return Array.fill[Int](44){(scala.util.Random.nextInt(101) + Calendar.getInstance().get(Calendar.MILLISECOND)) % 2}

  def ==(arg1: Array[Int], arg2: Array[Int]) : Boolean = {
    if (!arg1.sameElements(arg2)){
      return true
    }
    return false
  }

  def X(arg : Array[Int]) : Double = {
    var sum = 0.0
    for(i <- 0 until 22){
      sum += arg(i) * Math.pow(2.0, i)
    }
    return (sum / 20971.515) - 100
  }

  def Y(arg : Array[Int]) : Double = {
    var sum = 0.0
    for(i <- 22 until 44){
      sum += arg(i) * Math.pow(2.0, i - 22)
    }
    return (sum / 20971.515) - 100
  }
  def fitness(arg : Array[Int]) : Double = {
    val x = X(arg)
    val y = Y(arg)
    println("X: ", x, " Y: ", y)
    val fit = 0.5 - (Math.pow(Math.sin( Math.sqrt((x * x) + (y * y))), 2.0) - 0.5)/(1.0 + (0.001 * Math.pow((x * x) + (y * y), 2)))
    return fit
  }

}
