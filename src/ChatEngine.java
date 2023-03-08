import SkillDesigner.Skill;
import SkillDesigner.SkillFinder;
import builders.SentenceBuilder;

public class ChatEngine {
    String chatState;
    //private static final String  startState= "start";
    private Skill skill;
    private static final String  skillFindingState= "skillFinding";
    private String  response= "";
    public ChatEngine(){
        //this.chatState= startState;
    }
    public String getResponse(String userMessage){
        String response = "";
        //Skill finding phase
        //no message entered, start of thread
        if(this.skill== null && (userMessage == null || userMessage.length() == 0) ){
            response = SentenceBuilder.getSkillInputInstructionMessage();
        }
        else if(this.skill== null ){
            System.out.println("in chat engine second skill = NULl");
            //Skill skillFound = SkillFinder.find("my course timetable");
            Skill skillFound = SkillFinder.find(userMessage);
            if(skillFound != null){
                this.skill= skillFound;
                response = "Skill '"+ this.skill.skillName+"' found based on message and exact skill match finder: "+userMessage ;
            }
            else{
                System.out.println("in chat engine no skill found");
                response = "";
            }
            if(this.skill== null ) {
                System.out.println("in chat engine second skill null test");
                response = "";
            }
        }
        else {
            System.out.println("in chat engine skill not null");
            // find a keywordfinder
            if(this.skill.validateMessage(userMessage)){
                response = "valid";
            }
            else {
                response ="Input is not invalid, please enter the question in the following format: "+this.skill.getQuestionFormatMessage();
            }
        }
        return response;
    }
}
