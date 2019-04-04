import exceptions.ExceptionMaxValueReached;

public class Calculator {

  public Calculator() {}

  /**
   * additionne.
   * @param n1 premier nombre
   * @param n2 deuxième nombre
   * @return total addition
   * @throws ExceptionMaxValueReached exception return.
   */
  public Float addition(Float n1, Float n2) throws ExceptionMaxValueReached {
    Float result = n1 + n2;

    if (result <= Math.max(n1, n2) && n1 > 0 && n2 > 0) {
      throw new ExceptionMaxValueReached(String.valueOf(n1) + "+" 
          + String.valueOf(n2) + " is beyond Float.MAX_VALUE.");
    }

    return n1 + n2;
  }
}
