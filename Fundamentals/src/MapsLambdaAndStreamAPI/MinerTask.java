package MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resourcesQuantity = new LinkedHashMap<>();
        //resource -> sum of quantity
        String resource = scanner.nextLine(); //resource or "stop"
        while(!resource.equals("stop")) {
            //resource
            int quantity = Integer.parseInt(scanner.nextLine());
            //check for such a resource
            //do not have such a resource
            if(!resourcesQuantity.containsKey(resource)) {
                resourcesQuantity.put(resource, quantity);
            }
            //do have such a resource
            else {
                int currentQuantity = resourcesQuantity.get(resource);
                resourcesQuantity.put(resource, currentQuantity + quantity);
            }
            resource = scanner.nextLine();
        }

        //resourcesQuantity.forEach((key, value) -> System.out.println(key + " -> " + value));
        resourcesQuantity.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
