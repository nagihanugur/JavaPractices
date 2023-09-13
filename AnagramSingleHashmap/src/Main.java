import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {


        if (areAnagrams("balıkçı","bıçakçı")){
            System.out.println("anagram");
        }else{
            System.out.println("Anagram değil");
        }
    }

    public static Boolean areAnagrams(String str1, String str2){

        if (str1.length() != str2.length()){
            return false;
        }

        HashMap<Character, Integer> frequenceMap = new HashMap<>();

        for (char c : str1.toCharArray()) {

            frequenceMap.put(c, frequenceMap.getOrDefault(c,0)+1);
        }

        for (char c : str2.toCharArray()) {

            int frequence = frequenceMap.getOrDefault(c,0);
            if (frequence == 0){
                return false;
            }

            frequenceMap.put(c, frequence-1);

        }

        for (Map.Entry<Character, Integer> entry : frequenceMap.entrySet()) {

            System.out.println(entry.getKey()+"-"+entry.getValue());
            if (entry.getValue() == -1){

                return false;
            }

        }
        return true;
    }


}