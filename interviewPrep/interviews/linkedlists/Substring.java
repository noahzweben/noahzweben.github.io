////////////////////////////////////////////////////// Convert integer to binary:
import java.util.*;
class DecimalBinaryStack
{
  public static void main(String[] args) 
  { 
    Scanner in = new Scanner(System.in);
 
    // Create Stack object
    Stack<Integer> stack = new Stack<Integer>();
 
    // User input 
    System.out.println("Enter decimal number: ");
    int num = in.nextInt();
 
    while (num != 0)
    {
      int d = num % 2;
      stack.push(d);
      num /= 2;
    } 
 
    System.out.print("\nBinary representation is:");
    while (!(stack.isEmpty() ))
    {
      System.out.print(stack.pop());
    }
    System.out.println();
  }
}

////////////////////////////////////////////////////////////////////////// Substring Iterative
/ Returns true if str1[] is a subsequence of str2[]. m is 
// length of str1 and n is length of str2
bool isSubSequence(char str1[], char str2[], int m, int n)
{
   int j = 0; // For index of str1 (or subsequence
 
   // Traverse str2 and str1, and compare current character 
   // of str2 with first unmatched char of str1, if matched 
   // then move ahead in str1
   for (int i=0; i<n&&j<m; i++)
       if (str1[j] == str2[i])
         j++;
 
   // If all characters of str1 were found in str2
   return (j==m);
}
////////////////////////////////////////////////////////// Substring Recursive 

bool isSubSequence(char str1[], char str2[], int m, int n)
{
    // Base Cases
    if (m == 0) return true;
    if (n == 0) return false;
 
    // If last characters of two strings are matching
    if (str1[m-1] == str2[n-1])
        return isSubSequence(str1, str2, m-1, n-1);
 
    // If last characters are not matching
    return isSubSequence(str1, str2, m, n-1);


///////////////////////////////////////// First non-repeated character --> HashMap duh

/////////////// Reverse A String Recursively
  String reverseRecursively(String myStr){
    if (myStr.length() == 0) return myStr;
    return reverseRecursively(myStr.subSTring(1))+myStr.charAt(0);
  }

String reverseIteratively(String myStr) {
  String returnStr = "";
  for (int=myStr.length()-1; i>-1; i--) {
    returnStr+= myStr.chartAt(i);
  }
  return myStr;

}

/////////////////////////////////////////////////// is Palindrome
boolean isPal(String myStr) {
  if (myStr.length() == 0 || 1) return true;
  if  ( myStr.charAt(0) != myStr.charAt(myStr.length()-1) ) return false;
  return isPal(myStr.subString(1,myStr.length()-1));
}

// to ignore spaces can have a pointer at beginning and end and say while pointer0 < pointer1 check, if one is space in/dec-crement 1 

///////////////////////////////////////////////// Remove duplicates in a string
have a boolean[256], then set to true if its there, and go thoruhg and if something is not in there add it to string if is, ignore


///////////////////////////////////////////////// push zeroes to the right
void pushZerosToEnd(int arr[], int n)
{
    int count = 0;  // Count of non-zero elements
 
    // Traverse the array. If element encountered is non-
    // zero, then replace the element at index 'count' 
    // with this element
    for (int i = 0; i < n; i++)
        if (arr[i] != 0)
            arr[count++] = arr[i]; // here count is 
                                   // incremented
 
    // Now all non-zero elements have been shifted to 
    // front and  'count' is set as index of first 0. 
    // Make all elements 0 from count to end.
    while (count < n)
        arr[count++] = 0;




//////////////////////////////////// Longest Palindrome
 public String longestPalindrome(String s) {
  if (s.isEmpty()) {
    return null;
  }
 
  if (s.length() == 1) {
    return s;
  }
 
  String longest = s.substring(0, 1);
  for (int i = 0; i < s.length(); i++) {
    // get longest palindrome with center of i
    String tmp = helper(s, i, i);
    if (tmp.length() > longest.length()) {
      longest = tmp;
    }
 
    // get longest palindrome with center of i, i+1
    tmp = helper(s, i, i + 1);
    if (tmp.length() > longest.length()) {
      longest = tmp;
    }
  }
  return longest;
}
// Given a center, either one letter or two letter, 
// Find longest palindrome
public String helper(String s, int begin, int end) {
  while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
    begin--;
    end++;
  }
  return s.substring(begin + 1, end);
}


////////////////////////////// Find shortest added string to make a palindrome (adding at end)
def shortestPal(s):
  for i in range(len(s)):
    reverse = s[i::-1]
    print reverse
    pali = s+reverse

    if pal(pali):
      return pali
  else:
    print "oops"


  //////// adding at front
  def shortestPal(s):
  for i in range(len(s)):
    reverse = s[i:0:-1]
    print reverse
    pali = reverse+s


    if pal(pali):
      return pali
  else:
    print "oops"

//////////////////////////////////// Permutation 
    public static void permutation(String str) { 
    permutation("", str); 
}

private static void permutation(String prefix, String str) {
    int n = str.length();
    if (n == 0) System.out.println(prefix);
    else {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));


