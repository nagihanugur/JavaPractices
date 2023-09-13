import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


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


        }
    }
}