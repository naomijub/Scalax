/**
  * Created by jnaomi on 21/11/16.
  */
object App {
  def main(args: Array[String]){
    val comp1 = new Complex(2.0, -3.0);
    val comp2 = new Complex(2.3, 1.5);
    println(comp1 toString);
    println(comp2 toString);
    println(comp1 + comp2 toString);
    println(comp1 * comp2 toString);
    println(comp1 equals comp2 toString);
    println(comp1.conjugate() toString);
    println(comp1 / comp2 toString);
    println(comp1.module() toString);
    println(comp2.polar() toString);
  }
}
