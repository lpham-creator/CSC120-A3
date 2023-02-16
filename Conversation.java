/* 
   Filename: Conversation.java
Description: Academic project A3 for the class CSC 120: Object Oriented Programming, prof. R. Jordan Crouser. This file contains the class Conversation for a Chatbot, which can respond to user for a determined number of rounds and print out the transcript at the end.
     Author: Linh Pham (@lpham-creator)
       Date: 15 Feb 2023

*/
import java.util.*;

/** class Conversation
 * The class constructor, which takes in the number of rounds and takes turn answering to users, then prints out transcript of the conversation at the end
 */
class Conversation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.print("How many rounds of conversation would you like to have? ");
        int rounds = input.nextInt();

        List<String> transcript = new ArrayList<>();

        String opening = "Hi there! What's on your mind?";
        System.out.println(opening);
        transcript.add("Bot: " + opening);

        String users_input = input.nextLine();
        transcript.add("You: " + users_input);

        int i = 0;
        while (i < rounds){
            String next_input = input.nextLine();
            String[] words = next_input.split(" ");
            transcript.add("You: " + next_input);

            if (containsPronouns(next_input)==false){
            String response = getCannedResponse(random);
            System.out.println(response);
            transcript.add("Bot: " + response);
       
            }
            else {
            String nex_input = input.nextLine();
            transcript.add("You: " + nex_input);

            for (int j = 0; j < words.length; j++) {
                String word = words[j];
    
                if (word.equalsIgnoreCase("I")) {
                    words[j] = "you";
                    String mirroredSentence = String.join(" ", words);
                    System.out.println(mirroredSentence + "?");
                    transcript.add("Bot: " + mirroredSentence + "?");
                } else if (word.equalsIgnoreCase("you")) {
                    words[j] = "I";
                    String mirroredSentence = String.join(" ", words);
                    System.out.println(mirroredSentence + "?");
                    transcript.add("Bot: " + mirroredSentence + "?");
                } else if (word.equalsIgnoreCase("me")) {
                    words[j] = "you";
                    String mirroredSentence = String.join(" ", words);
                    System.out.println(mirroredSentence + "?");
                    transcript.add("Bot: " + mirroredSentence + "?");
                } else if (word.equalsIgnoreCase("your")) {
                    words[j] = "my";
                    String mirroredSentence = String.join(" ", words);
                    System.out.println(mirroredSentence + "?");
                    transcript.add("Bot: " + mirroredSentence + "?");
                }
                
            }
        }
        i++;
    }
        System.out.println("Goodbye!");
        System.out.println("Here's the transcript of our conversation:");
        for (String line : transcript) {
            if (line.isEmpty()==false) {
                System.out.println(line);

        }
        
    }
    }
        /** method getCannedResponse
        * @param random
        * This method stores all the canned response in a string
        */
        public static String getCannedResponse(Random random) {
                // This method returns a random canned response from a set of predefined phrases.
                String[] responses = {
                    "I hear you!",
                    "Tell me more.",
                    "That's interesting."
                };
                return responses[random.nextInt(responses.length)];
        }

        /** method containsPronouns
        * @param string
        * This method stores all the canned response in a string
        */
        public static boolean containsPronouns(String input) {
            // This method returns true if the input contains pronouns.
            return input.contains("I")
                || input.contains("me")
                || input.contains("am")
                || input.contains("you")
                || input.contains("my")
                || input.contains("your");
        }

    
  }