import java.io.IOException;
import java.net.URI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;



class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;
    List<String> stringList =  new ArrayList<String>();


    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Shixuan's Page: %d", num);
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("=");
              
                    System.out.println("StringList");
                    stringList.add(parameters[1]);
                    System.out.println(parameters[1]);

                    return stringList.stream()
                            .collect(Collectors.joining("\n"));
                
                
            }
            else if (url.getPath().contains("/search")){
                String[] search_parameters = url.getQuery().split("=");
                String keyword = search_parameters[1];
                List<String> result =  new ArrayList<String>();
                for (String element : stringList){
                    if (element.contains(keyword)){
                          System.out.println(element);
                          result.add(element);
                    }


            }
            String[] strArray1 = new String[result.size()];
		strArray1 = result.toArray(strArray1);
		System.out.println(Arrays.toString(strArray1));

                    return Arrays.toString(strArray1);}
            return "404 Not Found!";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
