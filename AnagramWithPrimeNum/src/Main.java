import java.util.HashMap;

public class Main {
    private static final int[] PRIME_NUM = {
            2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101
    };


    public static void main(String[] args) {
        System.out.println("Hello world!");

        String str1 = "NAGIHAN";
        String str2 = "NAHIGAN";
        // ingilizcede büyük İ yok I var kontrolü sağla

        if (findAnagramsWithPrimeNum(str1, str2)){
            System.out.println("anagram");
        }else{
            System.out.println("anagram değil");
        }


    }




    private static boolean findAnagramsWithPrimeNum(String str1, String str2){


        if (str1.length() != str2.length()){
            return false;
        }


        HashMap<Character, Integer> primeMap = new HashMap<>();

        char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        System.out.println(characters.length+"-"+PRIME_NUM.length);


        // map içerisine key:val olcak şekilde A:2, b:3, EŞLEŞMELERİNİ GİRERİZ
        for (int i = 0; i < characters.length; i++ ){
            primeMap.put(characters[i], PRIME_NUM[i]);
        }
        System.out.println(primeMap.entrySet());

        int product1 = 1;
        int product2 = 1;
        int product = 1;
        for (char c: str1.toUpperCase().toCharArray()) {

            // karaktere karşılık gelen asal sayı değerlerini çarpımlarını
            //product içinde saklarız



            product1 *= primeMap.get(c);
            product *= primeMap.getOrDefault(c, 1);
            System.out.println(product+""+c);




        }
        System.out.println(product);
        for (char c: str2.toUpperCase().toCharArray()) {
            // diğer karakter içinde aynı şeyi yaparız
            // karaktere karşılık gelen asal sayı değerlerini çarpımlarını
            //product içinde saklarız
            product2 *= primeMap.get(c);

        }
        System.out.println(product1+"-"+product2);

        return product1 == product2;

    }
}