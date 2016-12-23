import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite

/**
  * Created by jnaomi on 23/12/16.
  */
class SupportTest extends FunSuite with BeforeAndAfter{
  val popSize = 100
  var support : Support = _

  before{
    support = new Support
  }

  test("Test if support returns a random num between 0 - popSize"){

    val num = support.trueRand()
    assert (num >= 0 && num < popSize)
  }

}
