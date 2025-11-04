package coding;

public class FindMaximumVowels {

    public static void main(String[] args) {

        String str = "The quick brown fox jumps right over the little lazy dog.";
        String vowels = "AEIOUaeiou";
        StringBuilder result = new StringBuilder();
        String s[] = str.split(" ");
        int maxVowelCount=0;
        for(String word : s){
            int count = 0;
            for(char ch : word.toCharArray()){
                if(vowels.indexOf(ch)>=0){
                   count++;
                }
            }
            if(count>maxVowelCount){
                maxVowelCount = count;
                result = new StringBuilder(word);
            }
            else if(count==maxVowelCount){
                 result.append(",").append(word);
            }
        }
        System.out.println(result.toString());

    }
}
