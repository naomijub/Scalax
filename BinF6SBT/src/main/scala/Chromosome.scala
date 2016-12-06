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
}
