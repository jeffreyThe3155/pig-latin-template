import java.lang.*;

public class PigLatinTranslator
{
  public static Book translate(Book input)
  {
    Book translatedBook = new Book();

    // Add code here to populate translatedBook with a translation of the input book.
    // Curent do-nothing code will return an empty book.

    return translatedBook;
  }

  public static String translate(String input)
  {
    // System.out.println("Translate String: '" + input + "'");

    // Replace this code to translate a string input.
    // The input to this function could be any English string. 
    // A sentence, paragraph, or a single word. 
    // It should call translateWord at least once.
    //String[] words = input.split(" +");
    StringBuilder result = new StringBuilder();
    StringBuilder buffer = new StringBuilder();
    for(char c : input.toCharArray()) {
      //if a Char is a non-
      if(!Character.isLetterOrDigit(c)) {
        result.append(translateWord(buffer.toString()));
        buffer.delete(0,buffer.length());
        result.append(c);
      } else buffer.append(c);
    }
    result.append(translateWord(buffer.toString()));
    return result.toString();
  }

  //below is the list of vowels we used
  private static boolean isConsonant(char input) {
    return "aeiouyAEIOUY".indexOf(input) < 0;
  }

  private static String translateWord(String input)
  {
    // System.out.println("translateWord: '" + input + "'");

    // Replace this code to correctly translate a single word.
    // Start here first!
    String result;
    /* if (input.substring(0, 1).equals("a") || input.substring(0, 1).equals("e") || input.substring(0, 1).equals("i") || input.substring(0, 1).equals("o") || input.substring(0, 1).equals("u") || input.substring(0, 1).equals("y")) {
      result = input + "ay"
    } else {
      result = input
      while (result.substring(0, 1).equals())
    } */
    if (input.length() == 0) {
      return "";
    }
    char firstChar;
    if (isConsonant(firstChar = input.charAt(0))) {
      int index = 1;
      StringBuilder consonants = new StringBuilder();
      boolean isCapital = Character.isUpperCase(firstChar);
      consonants.append(Character.toLowerCase(firstChar));


      while (index < input.length() && isConsonant(input.charAt(index))) {
        consonants.append(input.charAt(index++));
      }
      char vowel = input.charAt(index);
      vowel = isCapital ? Character.toUpperCase(vowel) : vowel;
      result = vowel + input.substring(index + 1);
      result += consonants;

    } else result = input;
    result += "ay";
    System.out.println(result);
    return result;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}