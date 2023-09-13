import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("ogrenciBilgi.txt");

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

        // DOSYAYA YAZMA BUFFEREDWRITER


        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Nagihan Uğur,Bilgisayar Mühendisliği\n");
        bufferedWriter.write("Selenay Uğur,Bilgisayar Mühendisliği\n");
        bufferedWriter.write("Yağmur Uğur,Aşçı\n");
        bufferedWriter.write("Yiğit Uğur,Bilgisayar Mühendisliği");
        bufferedWriter.flush();
        bufferedWriter.close();

        // DOSYA OKUMA BUFFEREDREADER

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Scanner scanner = new Scanner(bufferedReader);

        while (scanner.hasNextLine()){

            String ogrenci_bilgisi = scanner.nextLine();

            String[] array = ogrenci_bilgisi.split(",");

            if (array[1].equals("Bilgisayar Mühendisliği")){

                System.out.println("Öğrenci Bilgisi: "+ogrenci_bilgisi);
            }
        }

        int N = 2;
        if(N >= 2 && N <=10){

            for (int i = 1; i < 10; i++) {

                int sonuc = N * i ;

                System.out.println(N+ " x "+i + " = "+sonuc);


            }
        }




    }
}