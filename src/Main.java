import builders.SentenceBuilder;
public class Main {
    public static void main(String[] args) {
        ChatEngine chat = new ChatEngine();
        System.out.println("--- before first getResponse call ---");
        String messageValid2 = chat.getResponse("");
        //which course is on friday
        System.out.println("in main before second getReply: "+messageValid2);

        System.out.println("--- before second getResponse call ---");
        String message = "my course timetable";
        String messageValid= chat.getResponse(message);//"which course is on friday"
        System.out.println("messageValid: "+messageValid);

        System.out.println("--- before third getResponse call ---");
        String message2 = "which course is on friday";
        String messageValid3= chat.getResponse(message2);//"which course is on friday"
        System.out.println("messageValid3: "+messageValid3);

        System.out.println("--- before fourth getResponse call ---");
        String messageValid4= chat.getResponse("which course");//"which course is on friday";
        System.out.println("messageValid4: "+messageValid4);

        //System.out.println("Main instruction message: "+SentenceBuilder.getSkillInputInstructionMessage());
        //timetable skill
       // Which lectures are there on <DAY> at <TIME>
    }
}