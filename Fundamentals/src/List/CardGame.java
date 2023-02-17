package List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //{20 30 40 50}
        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //{10 20 30 40}

        //1. take the first card
        //2. remove the card
        //3. check who wins:
        // card 1 > card 2 -> finally put on the first person's hand -> card 1 -> card 2
        //card 2 > card 1 -> finally put on the second person's hand -> card 2 -> card 1
        //card 1 == map 2 -> we don't add them anywhere

        //the game continues when both have cards
        //the game stops when someone runs out of cards

        while (firstPlayerCards.size() != 0 && secondPlayerCards.size() != 0) {
            int firstPlayerCard = firstPlayerCards.get(0);
            int secondPlayerCard = secondPlayerCards.get(0);
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerCards.add(secondPlayerCard);
                secondPlayerCards.add(firstPlayerCard);
            }
        }

        //1.if the first one runs out of cards
        if (firstPlayerCards.size() == 0) {
            //the second wins -> sum of the cards of the second
            System.out.printf("Second player wins! Sum: %d", getCardsSum(secondPlayerCards));
        }
        //2.if the second one runs out of cards
        else if (secondPlayerCards.size() == 0) {
            //първия печели
            System.out.printf("First player wins! Sum: %d", getCardsSum(firstPlayerCards));
        }
    }

    private static int getCardsSum(List<Integer> listCards) {
        int sum = 0;
        for (int card : listCards) {
            sum += card;
        }

        return sum;
    }
}

