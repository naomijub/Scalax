/**
  * Created by jnaomi on 21/11/16.
  */
class Complex (real: Double, imaginary: Double) {
  def re() = real;
  def imag() = imaginary;
  override def toString() = "" + re + (if (imag < 0) " " else " + ") + imag + "i"
  def +(arg: Complex): Complex = return new Complex(re + arg.re, imag + arg.imag)
  def -(arg: Complex): Complex = return new Complex(re - arg.re, imag - arg.imag)
  def *(arg: Complex): Complex = return new Complex((re * arg.re) - (imag * arg.imag), (re * arg.imag) + (arg.re * imag))
  def equals(arg: Complex): Boolean = return (arg.re == re && arg.imag == imag)
  def conjugate(): Complex = return new Complex(re, -imag)
  def /(arg: Complex): Complex = {
    val comAux = this * arg
    val conj = arg * arg.conjugate()
    return new Complex(comAux.re / conj.re, comAux.imag / conj.re)
  }
  def module(): Double = return Math.sqrt(Math.pow(re, 2) + Math.pow(imag, 2))
  def polar(): String = return " " + module + ".eˆ " + toDegree(Math.acos(re / module())) + "i"
  def toDegree(arg: Double): Double = return (arg * 180 / Math.PI)
}
