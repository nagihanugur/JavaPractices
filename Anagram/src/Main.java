import java.util.Arrays;
import java.util.HashMap;

public class Main {


    private static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    // Ana fonksiyon: İki stringin anagram olup olmadığını kontrol eder
    public static boolean areAnagrams(String str1, String str2) {
        // İki stringin uzunluğu farklı ise, anagram olmaları mümkün değil
        if (str1.length() != str2.length()) {
            return false;
        }

        // Stringleri sıralayarak karakterleri alfabetik sıraya diziyoruz
        String sortedStr1 = sortString(str1);
        String sortedStr2 = sortString(str2);

        // Sıralanmış stringlerin eşit olup olmadığını kontrol ediyoruz
        return sortedStr1.equals(sortedStr2);
    }


    public static void main(String[] args) {

        System.out.println("Hello world!");

        String str1 = "listen";
        String str2 = "silent";

        if (areAnagramsHash(str1,str2)){
            System.out.println(str1+" ve "+str2+" anagram");
        }


        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " ve " + str2 + " anagramdır.");
        } else {
            System.out.println(str1 + " ve " + str2 + " anagram değildir.");
        }


    }



    private static boolean areAnagramsHash(String str1, String str2) {

        // uzunluklar eşit değilse direkt anagram değildir
        if( str1.length() != str2.length()){
            return false;
        }

        // key value değeri tutan hashmap oluştur
        // key : character value: integer characterin frekans değeri
        // nagihan -> n,2 gibi şeklinde güncelleme olacak
        HashMap<Character, Integer> characterFrequencyHashMap = new HashMap<>();

        // stringi char dizisine çevir ve döngüyle karakterleri tek tek dön frekanslarını bul güncelle
        for (char c : str1.toCharArray()) {

            //characteFruquencyHashMap mapinin getOrDefault methodu
            // gönderilen karakterin frekansını döndürür, o karakter ilk kez varsa default 0 döner
            // orn: n a g  i h a - sıradaki n getOrDefault(n,0) -> 1 döner
            // ilk kez n okunduğunda 0 döndü ikinci n geldiğinde 1 döner
            // characterFrequencyHashMap.put diyerek güncelleme yaparız
            // characterFrequencyHashMap.put(n, getOrDefault(n,0) +1 ) deriz
            // +1 deriz çünkü ilk karakter girdğinde default 0 dı 0 a ekleme yaparız frekans değeri 1 olur


            characterFrequencyHashMap.put(c, characterFrequencyHashMap.getOrDefault(c,0) + 1);

        }

        // ikinci stringi diziye çevir ve for ile karakterleri dön frekansları kontrol et
        for (char c: str2.toCharArray()) {

            // oluşturduğumuz hashmap üzerinde gelen frekansları kontrol et
            // frekans değeri 1 den büyükse yani 0 dan farklı ise o karakter var demektir
            int frequency = characterFrequencyHashMap.getOrDefault(c,0);
            // frekans değeri 0 ise ilk kez ekleniyor demektr ve iki kelime aynı değildir
            //farklı bir karakter girişi olmuştur
            if(frequency == 0){
                return false;
            }
            // o karakterin frekans değerini güncelleriz
            // bizim hashmapte nagihan vardı
            // nahigan stringi için n geldiğinde bu karakter için map-> n:2 idi
            // yeni n ile frekanstan bu değer 3 döner frekans değerini güncelleriz 1 azaltarak
            // n için 3-1 : 2 koyarız döngü devam ettiği için
            // önceki dizi için hashmap key:value değeri devam etmeli ki karşılaştırma için
            characterFrequencyHashMap.put(c, frequency - 1);

        }

        // fro döngüsü tamamlandığında aynı frekansta çıkan 2 kelime oluşur
        // ve frekansla aynı ise anagamdır true döner
        return true;
    }
}