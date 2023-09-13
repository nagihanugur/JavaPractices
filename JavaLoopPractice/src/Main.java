public class Main {
    public static void main(String[] args) {


        starLoop();

    }

    public static void starLoop(){

        for (int i = 0; i <= 10; i+=2) {

            if(i == 0){
                System.out.println("*");
            }else {
                System.out.println("*".repeat(i));
            }

        }

    }
}