import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

  // The time complexity is:
  // O(n^2)
  public static void timesTable(int x) { 
    for(int i = 1; i <= x; i++) { // n
        for(int j = 1; j <= x; j++) { // n
            System.out.print(i*j + " ");
        }
        System.out.println();
    }
  }

  // The time complexity is:
  // O(n)
  public static void printLetters(String word) {
    char[] letters = word.toCharArray(); // O(n)

    for (char letter : letters) { //O(n)
        System.out.println(letter);
    }
  }

  // The time complexity is:
  // O(n)
  public static boolean isBanned(String password) {
    String[] bannedPasswords = {"password", "hello", "qwerty"};
    boolean banned = false;
    for(String bannedPassword : bannedPasswords) { // O(n)
        if(password.equals(bannedPassword)) {
            banned = true;
        }
    }
    return banned;
  }


  // The time complexity is:
  // O(n)
  public static int computeProduct(int[] nums) {
    int total = 1;
    for(int num : nums) { // O(n)
        total *= num; // O(1)
    }
    return total;
  }

  // The time complexity is:
  // O(n)
  public static void describeProduct(int[] nums) {
    System.out.println("About to compute the product of the array..."); // O(1)
    int product = computeProduct(nums); // O(n)
    System.out.println("The product I found was " + product);
  }


  // The time complexity is:
  // O(n)
  public static int computeFactorial(int n) {
    int result = 1;
    for(int i = 1; i <= n; i++) { // O(n)
        result *= n; // O(1)
    }
    return result;
  }

  // Assume that the largest number is no bigger than the length
  // of the array
  // Answer: O(n^2)
  public static void computeAllFactorials(int[] nums) {
    for(int num : nums) { //O(n)
        int result = computeFactorial(num); //O(n)
        System.out.println("The factorial of " + num + " is " + result);
    }
  }


  // The time complexity is:
  // O(n)
  public static void checkIfContainedArrayList(ArrayList<String> arr, String target) {
    if (arr.contains(target)) { // O(n)
        System.out.println(target + " is present in the list");
    } else {
        System.out.println(target + " is not present in the list");
    }
  }


  // assume n = wordsA.length = wordsB.length
  // The time complexity is:
  // O(n^2)
  public static boolean containsOverlap(String[] wordsA, String[] wordsB) {
    for(String wordA : wordsA) { // n
        for(String wordB : wordsB) { // n
            if(wordA.equals(wordB)) {
                return true;
            }
        }
    }
    return false;
  }

  // The time complexity is:
  // O(n)
  public static boolean containsOverlap2(String[] wordsA, String[] wordsB) {
    Set<String> wordsSet = new HashSet<>(); //O(1)
    for(String word : wordsA) {
        wordsSet.add(word); // O(n)
    }

    for(String word : wordsB) {
        if(wordsSet.contains(word)) { //O(1)
            return true;
        }
    }

    return false;
  }

  // The time complexity is:
  // O(n)
  public static void printCharacters(char[] chars) {
    for (int i = 0; i < chars.length; i++) { // O(n)
      char character = chars[i];
      System.out.println("The character at index " + i + " is " + character); //O(1)
    }
  }

  // The time complexity is:
  // O(1)
  public static double computeAverage(double a, double b) {
    return (a + b) / 2.0; // operations = O(1)
  }

  // The time complexity is:
  // O(1)
  public static void checkIfContainedHashSet(HashSet<String> set, String target)
  {
    if (set.contains(target)) { // O (1)
      System.out.println(target + " is present in the set");
    } else {
      System.out.println(target + " is not present in the set");
    }
  }

  // emailLookup attempts to find the email associated with a name.
  // The name at index i of names corresponds to the email at index i of emails
  // A queryName is given, and this method returns the corresponding email if it is found
  // Otherwise, it returns "Person not found"
  // What is the time complexity of this method?
  // YOUR ANSWER HERE: O(n)
  public static String emailLookup(String[] names, String[] emails, String queryName) {
    for(int i = 0; i < names.length; i++) { // O(n)
      if (names[i].equals(queryName)) { // O(1)
        return emails[i];
      }
    }
    return "Person not found";
  }

  // Suppose that emailLookupEfficient performs the same task as emailLookup
  // However, instead of two arrays it is passed a map where the
  // keys are names and the values are emails.
  // Write this method to efficiently return the corresponding email or "Person not found" if appropriate
  // What is the time complexity of your solution?
  // YOUR ANSWER HERE: O(1)
  public static String emailLookupEfficient(HashMap<String, String> namesToEmails, String queryName) { // O(1)
    String email = namesToEmails.get((queryName));
    if (email == null) {
      return "Person not found";
    } else {
      return email;
    }
  }

  // What is the time complexity of this method?
  // (assume the set and list have the same number of elements)
  // YOUR ANSWER HERE: O(n^2)
  public static boolean hasCommon(HashSet<String> wordSet, ArrayList<String> wordList) {
    for(String word : wordSet) { // O(n)
      if(wordList.contains(word)) { // O(n)
        return true;
      }
    }
    return false;
  }

  // Rewrite hasCommon so it does the same thing as hasCommon, but with a better time complexity.
  // Do not change the datatype of wordSet or wordList.
  // What is the time complexity of your new solution?
  // YOUR ANSWER HERE: O(n)
  public static boolean hasCommonEfficient(HashSet<String> wordSet, ArrayList<String> wordList) { // O(1)
    for (String word: wordList) {
      if (wordSet.contains(word)) { // O(n)
        return true;
      }
    }
    return false;
  }

  // Suppose you are building a dashboard that displays real-time stock prices.
  // You want to keep track of the current price of each stock, with the stock's ticker symbol as the key.
  // The prices will be updated frequently throughout the day, and you need to efficiently update
  // and access the current price for each stock. The order of the ticker symbols is not important.
  // What would be a good choice of data structure?

  // YOUR ANSWER HERE: I am choosing between TreeMap or HashMap. Using TreeMap would maintain 
  // elements in sorted order which does not apply to this case as order is not important.
  // also and would require to use O(log n) for its look up time which typically is slower 
  //than O(1) for HashMaps. I think chosing HashMaps as data structure would be the ideal choice.

  // Suppose you are building a music player application where users can create playlists.
  // Songs can be added to the end of the playlist in the order the user chooses, and the user can
  // skip to the next or previous song. Most operations involve adding songs and accessing them by
  // their position in the playlist.
  // What would be a good choice of data structure?

  // YOUR ANSWER HERE: For this case, I would say using an ArrayList would be practical since
  // its ease of use and elements can be randomly accessed, but there might insufficient capacity 
  // of the songs that can only be stored. 

  // Suppose you are developing a search feature that keeps track of the user's
  // recent search queries. You want to store the queries in the order they were made,
  // so you can display them to the user for quick access. The number of recent searches is
  // relatively small, and it is more important to preserve the order of the searches than
  // to optimize for fast lookups or deletions.
  // What would be a good choice of data structure?

  // YOUR ANSWER HERE: I think LinkedLists would be a good choice for this search feature as
  // it will maintain the order of the elements and can be helpful for adding new elements
  // to the end of the list. 