import java.util.*;

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

        // Split the message into words
        String[] words = users_input.split(" ");

        int i = 0;
        while (i < rounds){
            if (containsPronouns(users_input)==false){
            String next_input = input.nextLine();
            transcript.add("You: " + next_input);

            String response = getCannedResponse(random);
            System.out.println(response);
            transcript.add("Bot: " + response);
            }
            else{
            String next_input = input.nextLine();
            transcript.add("You: " + next_input);

            // Mirror the words based on a pre-defined dictionary
            String[] mirroredWords = new String[words.length];
            for (int j = 0; j < words.length; j++) {
            String mirroredWord = mirrorWord(words[j]);
            mirroredWords[j] = mirroredWord;
            System.out.println(mirroredWords[j]);
            }
            
            String response = String.join(" ", mirroredWords);
            System.out.println(response);
            transcript.add("Bot: " + response);
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
        
        public static String getCannedResponse(Random random) {
                // This method returns a random canned response from a set of predefined phrases.
                String[] responses = {
                    "I hear you!",
                    "Tell me more.",
                    "That's interesting.",
                    "I'm not sure I understand. Can you explain?",
                    "What do you think about that?",
                    "Hmm, I see.",
                    "Please go on.",
                    "That's a good point.",
                    "I appreciate your input.",
                    "I'm sorry, I don't know the answer.",
                };
                return responses[random.nextInt(responses.length)];
        }

        public static boolean containsPronouns(String input) {
            // This method returns true if the input contains pronouns.
            return input.contains("\\b" + "I" + "\\b")
                || input.contains("\\b" + "me" + "\\b")
                || input.contains("\\b" + "am" + "\\b")
                || input.contains("\\b" + "you" + "\\b")
                || input.contains("\\b" + "my" + "\\b")
                || input.contains("\\b" + "your" + "\\b");
        }


        private static String mirrorWord(String word) {
            switch (word) {
                case "I":
                    return "you";
                case "you":
                    return "I";
                case "my":
                    return "your";
                case "your":
                    return "my";
                case "am":
                    return "are";
                case "are":
                    return "am";
                default:
                    return word;
            }
        }

        

    
  }