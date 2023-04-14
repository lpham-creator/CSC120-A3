import java.util.Scanner;
import java.util.Random;
import java.util.*;

/**
 * A simple command-line conversation program that simulates a dialogue with a user.
 */
public class Conversation {

    /**
     * An ArrayList of canned responses to use during the conversation.
     */
    public static ArrayList<String> responses = new ArrayList<>(List.of("Hi there! What's on your mind?",
            "I hear you!",
            "Tell me more.",
            "That's interesting.",
            "I'm not sure I understand. Can you explain?",
            "What do you think about that?",
            "Hmm, I see.",
            "Please go on.",
            "That's a good point.",
            "I appreciate your input.",
            "I'm sorry, I don't know the answer."
    ));

    /**
     * The main method that runs the conversation program.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("How many rounds of conversation would you like to have? ");
        int rounds = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] transcript = new String[rounds];
        String prevInput = null;
        int round = 0;
        while (round < rounds) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();
            if (prevInput != null && containsPronouns(input)) {
                String response = mirror(prevInput);
                transcript[round] = "> " + input + "\n" + "< " + response;
                System.out.println("< " + response);
            } else {
                String response = getCannedResponse(random);
                transcript[round] = "> " + input + "\n" + "< " + response;
                System.out.println("< " + response);
            }
            prevInput = input;
            round++;
        }

        System.out.println("Goodbye!");
        System.out.println("Here's the transcript of our conversation:");
        for (int i = 0; i < transcript.length; i++) {
            System.out.println(transcript[i]);
        }
    }

    /**
     * Returns true if the input contains any pronouns.
     * @param input The input string to check.
     * @return true if the input contains any pronouns, false otherwise.
     */
    public static boolean containsPronouns(String input) {
        return input.contains("i")
                || input.contains("me")
                || input.contains("am")
                || input.contains("you")
                || input.contains("my")
                || input.contains("your");
    }

    /**
     * Returns a mirrored version of the input string.
     * @param input The input string to mirror.
     * @return A mirrored version of the input string.
     */
    public static String mirror(String input) {
        String mirrored = input;
    if (input.contains("i")) {
        mirrored = mirrored.replaceAll("\\bi\\b", "you");
    }
    if (input.contains("me")) {
        mirrored = mirrored.replaceAll("\\bme\\b", "you");
    }
    if (input.contains("am")) {
        mirrored = mirrored.replaceAll("\\bam\\b", "are");
    }
    if (input.contains("you")) {
        mirrored = mirrored.replaceAll("\\byou\\b", "I");
    }
    if (input.contains("my")) {
        mirrored = mirrored.replaceAll("\\bmy\\b", "your");
    }
    if (input.contains("your")) {
        mirrored = mirrored.replaceAll("\\byour\\b", "my");
    }
    return mirrored;
    }

    /**
     * Returns a random canned response from the list of responses.
     * @param random A Random object to use for selecting the response.
     * @return A random canned response.
     */
    public static String getCannedResponse(Random random) {
        return responses.get(random.nextInt(responses.size()));
    }

}


