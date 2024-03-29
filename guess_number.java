import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class guess_number {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);
        // int number = (int) (Math.random() * 100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        // System.out.println(number); print correct number
        while (right < 5) {
            System.out.print("Please enter your prediction. : ");
            selected = input.nextInt();

            if (selected < 0 || selected > 99) {
                System.out.println("Please enter a value between 0 and 100.");
                if (isWrong) {
                    right++;
                    System.out
                            .println("You have made too many incorrect entries. Remaining attempts. : " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("If you make another incorrect entry, your chance will be deducted.");
                }
                continue;
            }

            if (selected == number) {
                System.out.println(
                        "Congratulations, you made the correct prediction! The guessed number was : " + number);
                isWin = true;
                break;
            } else {
                System.out.println("I apologize for the incorrect number entry. !");
                if (selected > number) {
                    System.out.println(selected + " The number is greater than the hidden number.");
                } else {
                    System.out.println(selected + " The number is less than the hidden number");
                }

                wrong[right++] = selected;
                System.out.println("Remaining attempts : " + (5 - right));
            }
        }

        if (!isWin) {
            System.out.println("Lose ! ");
            if (!isWrong) {
                System.out.println("Your Predictions : " + Arrays.toString(wrong));
            }
        }

    }
}
