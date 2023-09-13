import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("******File ile DOSYA OLUŞTURMA *****");

        File file = new File("kod.txt");

        if(!file.exists()){
            try{

                file.createNewFile();
                System.out.println("Dosya oluşturuldu..");


            } catch (IOException e) {
                System.out.println("Dosya oluşturulurken hata oluştu.."+e);
            }
        }else{
            System.out.println("Dosya zaten var..");
            System.out.println("Dosya adı: "+file.getName());
            System.out.println("Dosya yolu: "+file.getPath());

        }

        System.out.println("******FileWriter ile Yazma *****");

        String val = "kodlama vakti";
        String val2 = "\nİkinci satır";
        String val3 = "\nÜçüncü satır";
        FileWriter fileWriter = new FileWriter(file, false);
        //ara tampon işlem hızlandırır
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(val);
        bufferedWriter.write(val2);
        bufferedWriter.write(val3);
        bufferedWriter.flush();
        bufferedWriter.close();

        System.out.println("******FileReader ile dosyadan OKUMA*****");

        FileReader fileReader = new FileReader(file);
        //satır satır okuması için
        String line;
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null){

            System.out.println(line);

        }
        bufferedReader.close();


        System.out.println("******PrintWriter  ile DOSYAYA YAZMA*****");

        PrintWriter output = new PrintWriter("output.txt");

        int age =24;

        output.printf("i am %d years old", age);
        output.close();


    }
}