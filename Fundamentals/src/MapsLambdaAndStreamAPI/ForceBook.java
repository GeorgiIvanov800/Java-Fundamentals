package MapsLambdaAndStreamAPI;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine(); //a valid command or Lumpawaroo

        //entry: group (side) -> list of users
        Map<String, List<String>> map = new LinkedHashMap<>();

        while (!command.equals("Lumpawaroo")) {
            //valid command
            if (command.contains(" | ")) {
                //command = "{force_side} | {force_user}".split(" | ") -> ["{force_side}", "{force_user}"]
                String group = command.split("\\s+\\|\\s+")[0];
                String user = command.split("\\s+\\|\\s+")[1];
                //1. if group exists
                if (!map.containsKey(group)) {
                    //group -> empty list
                    map.put(group, new ArrayList<>());
                }
                //2.have such a group -> add to the user group if it is not in ANY GROUP
                boolean isExistUser = false; //user is in a group
                for (List<String> listUsers : map.values()) {
                    if (listUsers.contains(user)) {
                        //user is in a group
                        isExistUser = true;
                        break;
                    }
                }

                if (!isExistUser) {
                    //user not in a group
                    map.get(group).add(user);
                }
            } else if (command.contains(" -> ")) {
                //command = "{force_user} -> {force_side}".split(" -> ") -> ["{force_user}", "{force_side}"]
                String user = command.split("\\s+->\\s+")[0];
                String group = command.split("\\s+->\\s+")[1]; //group where it goes

                //1.if the given user is in a given group -> we remove it from the current group
                //record: group (key) -> list of users (value)
                map.entrySet().forEach(entry -> entry.getValue().remove(user));

                //2. check  such a group  exist where it goes to
                if (map.containsKey(group)) {
                    map.get(group).add(user);
                } else {
                    //there is no such group he wants to go to ->  create
                    map.put(group, new ArrayList<>());
                    map.get(group).add(user);
                }

                System.out.printf("%s joins the %s side!%n", user, group);
            }
            command = scanner.nextLine();
        }


        //entry: group -> list of users
        //1.filter records -> no. people > 0
        map.entrySet()  //all records
                .stream().filter(entry -> entry.getValue().size() > 0) //leave records that meet the condition of having people in the group
                //a list of records that match the condition
                .forEach(entry -> {
                            //entry: groupName(key) -> list of users (value)
                            //"Side: {forceSide}, Members: {forceUsers.Count}
                            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                            entry.getValue().forEach(user -> System.out.println("! " + user));
                        }
                );
    }
}
