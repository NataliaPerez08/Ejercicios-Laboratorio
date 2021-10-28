/**
 * Autor: Natalia Pérez Romero
 * Fecha: 19-10-2021
 */
import java.io.IOException;
import java.util.Scanner;

public class Main {
  /**
   * Este método regresa si una cadena es una palabra, es decir si un una cadena
   * no es un punto, no tiene digitos, y no tiene puntos intermedios
   **/
  public static boolean isWord(String str) {
    if (str.isEmpty())
      return false;
    if (str.charAt(0) == 46 && str.length() == 1)
      return false;

    for (int i = 0; i < str.length(); i++) {
      int last = str.length() - 1;
      if (str.charAt(i) == 46 && i != last)
        return false;
      if (str.charAt(i) >= 48 && str.charAt(i) <= 57)
        return false;
    }
    return true;
  }

  /**
   * Este método recibe una oración cuenta las palabras y los caracteres de las
   * palabras y regresa la puntación.
   **/
  public static int evaluteSentence(String msg) {
    int countWords = 0;
    int numCharacters = 0;
    int average = 0;

    msg = msg.trim();
    String[] arrayOfWords = msg.split(" ");
    for (String word : arrayOfWords) {
      word = word.trim();
      if (isWord(word)) {
        countWords++;
        numCharacters += word.length();
      }
    }

    if (countWords == 0)
      average = 0;
    else
      average = numCharacters / countWords;

    if (average <= 3)
      return 250;
    if (average >= 4 && average <= 5)
      return 500;
    if (average >= 6)
      return 1000;
    return 0;
  }

  public static void main(String[] args) throws IOException {
    Scanner scaner = new Scanner(System.in);
    String msg = scaner.nextLine();
    System.out.println(evaluteSentence(msg) + "\n");
    scaner.close();
  }
}