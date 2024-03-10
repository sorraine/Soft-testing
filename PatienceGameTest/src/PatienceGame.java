
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.Scanner;

// Class representing the Patience game
public class PatienceGame {
    // Deck of cards represented as a deque
    private Deque<Integer> deck;
    // Variable to store the highest score achieved
    private int highestScore;
    // Array to store the history of scores
    private int[] history;

    // Constructor to initialize the game
    public PatienceGame() {
        highestScore = 0;
        history = new int[0];
    }

    // Method to start the game
    public void startGame() {
        // Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Main game loop
        while (true) {
            // Initialize the deck of cards
            initializeDeck();
            // Play the game
            playGame(scanner);
            // Update the history of scores
            updateHistory();
            // Ask the player if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }
        // Close the scanner to release resources
        scanner.close();
    }

    // Method to initialize the deck of cards
    private void initializeDeck() {
        deck = new ArrayDeque<>();
        for (int i = 1; i <= 52; i++) {
            deck.offer(i);
        }
        // Shuffle the deck
        shuffleDeck();
    }

    // Method to shuffle the deck of cards
    private void shuffleDeck() {
        // Convert deck to array for shuffling
        Integer[] array = deck.toArray(new Integer[0]);
        // Random object to shuffle the deck
        Random random = new Random();
       
        
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        // Clear the deck and add shuffled cards back
        deck.clear();
        for (Integer card : array) {
            deck.offer(card);
        }
    }

    // Method to play the game
    private void playGame(Scanner scanner) {
        int score = 0;
        // Main game loop
        while (!deck.isEmpty()) {
            // Generate a random number of cards to recall (1-3)
            int numCardsToRecall = new Random().nextInt(3) + 1;
            int[] cards = new int[numCardsToRecall];
            // Draw cards from the deck
            for (int i = 0; i < numCardsToRecall; i++) {
                if (!deck.isEmpty()) {
                    cards[i] = deck.poll();
                }
            }
            // Display the drawn cards
            System.out.println("Remember these cards: " + arrayToString(cards));
            try {
                // Wait for 60 seconds for the player to memorize the cards
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int[] recalledCards = new int[numCardsToRecall];
            // Prompt the player to recall the cards
            System.out.print("Recall the cards (enter space-separated card numbers): ");
            String input = scanner.nextLine();
            String[] inputs = input.split("\\s+");
            // Check if the number of inputs matches the expected number of cards
            if (inputs.length != numCardsToRecall) {
                throw new IllegalArgumentException("Invalid number of cards recalled.");
            }
            // Parse each input string to integers and store them in the array
            for (int i = 0; i < numCardsToRecall; i++) {
                recalledCards[i] = Integer.parseInt(inputs[i]);
            }
            // Check if the recalled cards match the drawn cards
            if (arrayEquals(cards, recalledCards)) {
                score += numCardsToRecall;
            } else {
                break;
            }
        }
        // Display the final score
        System.out.println("Game over. Your score: " + score);
        // Update the highest score if the current score is higher
        if (score > highestScore) {
            highestScore = score;
        }
    }

    // Method to update the history of scores
    private void updateHistory() {
        // Extend the history array by one element
        int[] newHistory = new int[history.length + 1];
        // Copy the previous history to the new array
        System.arraycopy(history, 0, newHistory, 0, history.length);
        // Add the current highest score to the history
        newHistory[history.length] = highestScore;
        // Update the history array
        history = newHistory;
    }

    // Method to convert an array to string
    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    // Method to check if two arrays are equal
    private boolean arrayEquals(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    // Method to get the highest score
    public int getHighestScore() {
        return highestScore;
    }

    // Method to get the history of scores
    public int[] getHistory() {
        return history;
    }
}
