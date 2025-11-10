package coding;

public class FindMaximumNumberOfVowel5 {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps right over the little lazy dog.";
        String vowels = "AEIOUaeiou";
        StringBuilder result = new StringBuilder();
        String[] s = str.split(" ");
        int maxVowelCount = 0;

        for(String word : s) {
            int count = 0;
            for(char ch : word.toCharArray()) {
                if(vowels.indexOf(ch) != -1) { // Fixed condition
                    count++;
                }
            }
            
            if(count > maxVowelCount) {
                maxVowelCount = count;
                result = new StringBuilder(word);
            } else if(count == maxVowelCount) {

                if(!result.isEmpty()) {
                    result.append(",").append(word);
                }
                //result
            }
        }
        
        System.out.println("Word(s) with maximum vowels: " + result.toString());
        System.out.println("Maximum vowel count: " + maxVowelCount);
    }
}