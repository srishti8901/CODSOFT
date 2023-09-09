import java.util.*;

public class NumberGuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

    public static void main(String[] args) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        methodChange.menu(scoreBoard);
    }

    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        Scanner sc= new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("1)Launch the Game");
        System.out.println("2) Ranking Board");
        System.out.println("3)Terminate ");
        System.out.println("--------------------");

        try {
            System.out.print("What's your next step? ");
            int menuOption = sc.nextInt();

            switch (menuOption) {
                case 1:
                    System.out.print("\n"+"How wide do you want the game's boundaries to be?");
                    int numberRange = sc.nextInt();

                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"We're glad you played!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("This input isn't valid. Please give it another shot.");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }

    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;

        return randomNumber;
    }

    public void guessNumber(int randomNumber) {
        Scanner sc = new Scanner(System.in);

        int userGuess;
        int guess = 0;

        do {
            System.out.print("Take a guess:");
            userGuess = sc.nextInt();
            guess++;

            if (userGuess > randomNumber) {
                System.out.println("Enter a low number");
            } else if (userGuess < randomNumber) {
                System.out.println("Enter a higher number");
            }

        } while (randomNumber != userGuess);

        System.out.println(" ");

        if (guess == 1) {
            System.out.println("You answered right in " + guess + " try!");
        } else {
            System.out.println("You answered right in " + guess + " tries!");
        }

        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }

    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Ranking Board");
        System.out.println("--------------------");

        System.out.println("Your fastest games today: " +"\n");
        Collections.sort(scoreBoard);

        for (Integer scores : scoreBoard) {
            System.out.println("Finished the game in " + scores + " tries");
        }

        System.out.println(" ");
        menu(scoreBoard);
    }
}
