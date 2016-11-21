/**
  * Created by jnaomi on 21/11/16.
  */
class Complex (real: Double, imaginary: Double) {
  def re() = real;
  def imag() = imaginary;
  override def toString() = "" + re + (if (imag < 0) " " else " + ") + imag + "i"
  def +(arg: Complex): Complex = return new Complex(re + arg.re, imag + arg.imag)
}
