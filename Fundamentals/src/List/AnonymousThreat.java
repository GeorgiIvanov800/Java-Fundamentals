package List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> texts = Arrays.stream(scanner.nextLine() //"Ivo Johny Tony Bony Mony"
                        .split(" ")) //["Ivo", "Johny", "Tony", "Bony", "Mony"]
                .collect(Collectors.toList()); //{"Ivo", "Johny", "Tony", "Bony", "Mony"}

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            //1. merge {startIndex} {endIndex}
            //2. divide {index} {partitions}
            if (command.contains("merge")) {
                //command = "merge 1 3".split(" ") -> ["merge", "1", "3"]
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int endIndex = Integer.parseInt(command.split(" ")[2]);
                //{"Ivo", "Johny", "Tony", "Bony", "Mony"}
                //check for start index
                if (startIndex < 0) {
                    startIndex = 0;
                }
                //check for end index
                if (endIndex > texts.size() - 1) {
                    endIndex = texts.size() - 1;
                }

                //validate index -> [0,  - 1]
                boolean isValidIndexes =  startIndex <= texts.size() - 1 && endIndex >= 0 && startIndex < endIndex;

                if (isValidIndexes) {
                    //{"Ivo", "Johny", "Tony", "Bony", "Mony"}
                    //merge 1 3
                    String resultMerge = "";
                    for (int index = startIndex; index <= endIndex; index++) {
                        String currentText = texts.get(index);
                        resultMerge += currentText;
                    }
                    //resultMerge = "JohnyTonyBony"
                    //remove
                    for (int index = startIndex; index <= endIndex; index++) {
                        texts.remove(startIndex);
                    }
                    //{"Ivo", "Mony"}
                    texts.add(startIndex,resultMerge);
                    //{"Ivo", "JohnyTonyBony", "Mony"}
                }
            } else if (command.contains("divide")) {
                //command = "divide 0 3".split(" ") -> ["divide", "2", "3"]
                int index = Integer.parseInt(command.split(" ")[1]);
                int parts = Integer.parseInt(command.split(" ")[2]); //number of parts
                //{abcdef, ghi, jkl}
                String elementForDivide = texts.get(index); //"abcdef"
                texts.remove(index);
                //{ghi, jkl}

                //how many elements will each part have
                int partSize = elementForDivide.length() / parts; //2 items in each part

                int beginIndexOfText = 0;
                for (int part = 1; part < parts; part++) {
                    texts.add(index, elementForDivide.substring(beginIndexOfText, beginIndexOfText + partSize));
                    //{ab, cd, ghi, jkl}
                    index++; // 2
                    beginIndexOfText += partSize; // 4
                }
                //we add the remaining symbols to the last part
                texts.add(index, elementForDivide.substring(beginIndexOfText)); //if it is not set an end index -> takes to the last one
            }
            command = scanner.nextLine();
        }


        System.out.println(String.join(" ", texts));

       /* for (String text : texts) {
            System.out.print(text + " ");
        }*/
    }
}
