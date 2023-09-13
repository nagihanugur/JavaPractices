import java.io.File;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {



    private static final String FILE_PATH ="myhost.txt";
    private static Map<String, String> myHostMap = new HashMap<>();

    public static void main(String[] args) {



        readMyHostFile();

        updateOrAddHostMap("77.124.52.63", "google.com");
        updateOrAddHostMap("123.45.67.89", "facebook.com");
        updateOrAddHostMap("120.45.67.89", "facebook.com");
        updateOrAddHostMap("123.45.67.89", "facebook.com");



        writeMyHostFile();


    }

    private static void readMyHostFile(){

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))){
            String line;

            while ((line = bufferedReader.readLine()) != null){

                String[] parts = line.split("\\s+");

                if (parts.length == 2){
                    String ipAddress = parts[0];
                    String hostName = parts[1];

                    if (!myHostMap.containsValue(ipAddress)){
                        myHostMap.put(hostName, ipAddress);
                    }

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateOrAddHostMap(String newIpAddress,String hostName){
        String currentIpAddress = myHostMap.get(hostName);
        if( currentIpAddress != null && myHostMap.containsKey(hostName)){
            myHostMap.put(hostName, newIpAddress);

        }else{
            myHostMap.put(hostName, newIpAddress);
        }

    }

    private static void writeMyHostFile(){


        Set<String> entries = new HashSet<>();
        Set<String> ips = new HashSet<>();
        Set<String> hosts = new HashSet<>();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))){


            for (Map.Entry<String, String> entry : myHostMap.entrySet()) {

                String hostName = entry.getKey();
                String ipAddress = entry.getValue();
                String line = ipAddress + " " + hostName;


               if (entries.add(line) && ips.add(ipAddress) && hosts.add(hostName)){
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}