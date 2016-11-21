/**
  * Created by jnaomi on 21/11/16.
  */
object App {
  def main(args: Array[String]){
    val comp1 = new Complex(2.0, -3.0);
    val comp2 = new Complex(2.3, 1.5);
    println(comp1 toString);
    println(comp2 toString);
    val comp3 = comp1 + comp2
    println(comp3 toString);
  }
}
