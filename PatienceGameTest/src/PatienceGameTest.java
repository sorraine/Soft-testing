import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class PatienceGameTest {
    private PatienceGame game;

    @BeforeEach
    void setUp() {
        game = new PatienceGame();
    }

    @Nested
    class UserInputTests {
        @Test
        void testRecallCardsValidInput() {
           // Test recalling valid number of cards
           
            int validInput = 3; // Example valid input
            // Exercise: Call recallCards with valid input
            game.recallCards(validInput);
            // Verify: Ensure correct cards are recalled
            assertTrue(game.getCardsRecalled() == validInput);
        }

        }

        @Test
        void testRecallCardsInvalidInput() {
            //
            // Test throwing exception for invalid input
             //  Exercise: Call recallCards with invalid input   
             //  Verify: Ensure IllegalArgumentException is thrown 
           
           
        }
        

        @Test
        void testRecallCardsInvalidInput_InvalidFormat() {
            // Test throwing exception for invalid input format
            // Setup: Mock user input with invalid format
            // Exercise: Call recallCards with invalid input
            // Verify: Ensure IllegalArgumentException is thrown
            // Clean-up: None needed
        }

        @Test
        void testRecallCardsInvalidInput_TooManyCards() {
            // Test throwing exception for too many cards requested
            // Setup: Mock user input requesting more cards than available
            // Exercise: Call recallCards with invalid input
            // Verify: Ensure IllegalArgumentException is thrown
            // Clean-up: None needed
        }

        @Test
        void testRecallCardsInvalidInput_NegativeNumber() {
            // Test throwing exception for negative number of cards requested
            // Setup: Mock user input with negative number of cards
            // Exercise: Call recallCards with invalid input
            // Verify: Ensure IllegalArgumentException is thrown
            // Clean-up: None needed
        }


    }

    @Nested
    class FunctionalityTests {
        @Test
        void testShuffleDeck() {
            // Test shuffling deck
            // Setup: Initialize deck before shuffling
            // Exercise: Call shuffleDeck method
            // Verify: Ensure deck is shuffled
           
        }

        @Test
        void testDrawCards() {
            // Test drawing cards from the deck
            // Setup: Initialize deck with known cards
            // Exercise: Call drawCards method
            // Verify: Ensure correct number of cards are drawn
            int numCardsToDraw = 5;
            game.drawCards(numCardsToDraw);
            assertEquals(numCardsToDraw, game.getDrawnCards().size());


        }

        @Test
        void testRecallCardsCorrectly() {
            // Test recalling cards correctly
            // Setup: Initialize deck with known cards
            // Exercise: Call recallCards method with correct input
            // Verify: Ensure correct cards are recalled and score is incremented
       
        }

        @Test
        void testRecallCardsIncorrectly() {
            // Test recalling cards incorrectly
            // Setup: Initialize deck with known cards
            // Exercise: Call recallCards method with incorrect input
            // Verify: Ensure game ends and score is not incremented
         
        }

        @Test
        void testEndGameEmptyDeck() {
            // Test ending the game when the deck is empty
            // Setup: Initialize empty deck
            // Exercise: Call playGame method
            // Verify: Ensure game ends when the deck is empty
         
        }
       
    }

    @Nested
    class ExceptionTests {
        @Test
        void testRecallCardsException() {
            // Test throwing exception for invalid input
            // Setup: Mock user input with invalid number of cards
            // Exercise: Call recallCards with invalid input
            // Verify: Ensure IllegalArgumentException is thrown
         
        }
        

        @Test
        void testEmptyDeckException() {
            // Test throwing exception when deck is empty
            // Setup: Initialize empty deck
            // Exercise: Call drawCards method
            // Verify: Ensure NoSuchElementException is thrown
           
        }

        @Test
        void testNegativeScoreException() {
            // Test throwing exception for negative score
            // Setup: Initialize deck and play the game
            // Exercise: Attempt to set negative score
            // Verify: Ensure IllegalArgumentException is thrown
            
        }
    }
