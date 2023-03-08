package builders;

import SkillDesigner.IOLoader;

import java.util.*;

public class SentenceBuilder {
    public String getWelcomePhaseMessage(){
        return"";
    }
    public String getSkillsearchPhaseMessage(Boolean errorMessage){
        String response ="";
        List<String> skills =  Arrays.asList(
                "I am sorry, I didn't understand. Could you please repeat your message?",
                "Please reformulate, I didn't understand",
                "I have no idea",
                "Could you please give another input, I couln't find a skill matching your input");
        //cars.get(500000);
        Integer messageIndex=getRandomNumer(1,skills.size());
        String responsePart1=skills.get(messageIndex);

            if(errorMessage){
                response = "";
            }
            return response;
        }

        // helper methods
        public static String getSkillInputInstructionMessage(){
            String message = "Which skill do you want to choose, please choose one of the following: ";
            message = message +IOLoader.byBufferedReaderSkilllistWithoutSkilltype();
            return message;
        }
        private static Integer getRandomNumer(Integer  min, Integer max){
            Random random = new Random();
            return random.nextInt(max - min + 1) + min;
        }
}
