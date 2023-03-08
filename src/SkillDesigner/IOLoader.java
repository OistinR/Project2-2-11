package SkillDesigner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOLoader {
        private static final String localRootFolder="C:\\digitalAssistant";
        //command to find
        private static final String skillFolder = "skill";
        private static final String skillListFile = localRootFolder+"\\"+"skills.txt";
        private static final String skillsFolder = localRootFolder+"\\"+"skills"+"\\";
        //    private static final String skillListFile = localRootFolder+"\\"+skillFolder+"\\"+"skills.txt";
        private static final String skillKeywords = localRootFolder+"\\"+"skillKeywords.txt";
        private static final String skillTemplateFile = "skillTemplate.txt";
        private static final String logFolder = localRootFolder+"\\"+"logs";

        public static List<String> getSkillList(){
            List<String> skills = byBufferedReaderList(skillListFile);
            //TODO identify skill names
            return skills;
        }
        private static String getSkillFolderByName(String skillName){
            return skillsFolder +"\\"+skillName +"\\";
        }

        /* Helper methods */
        /* source: https://www.baeldung.com/java-read-file-into-map*/
        private static Map<String, String> byBufferedReader(String filePath, Boolean duplicateKeys) {
            HashMap<String, String> map = new HashMap<>();
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                while ((line = reader.readLine()) != null) {
                    String[] keyValuePair = line.split(":", 2);
                    if (keyValuePair.length > 1) {
                        String key = keyValuePair[0];
                        String value = keyValuePair[1];
                        if (duplicateKeys) {
                            map.put(key, value);
                        } else  {
                            map.putIfAbsent(key, value);
                        }
                    } else {
                        System.out.println("No Key:Value found in line, ignoring: " + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return map;
        }
        /* source: https://www.baeldung.com/java-read-file-into-map*/
        private static List<String> byBufferedReaderList(String filePath) {
            List<String> map = new ArrayList<String>();
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                while ((line = reader.readLine()) != null) {
                    map.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return map;
        }
    public static HashMap<Integer,String[]> getInputParamMatchValue(String[] inputParams, Skill skill) {
        HashMap<Integer,String[]> outputParams = getMatchValue (getSkillFolderByName(skill.skillName)+"lookup.txt",inputParams );
        return outputParams;
    }

        private static HashMap<Integer,String[]> getMatchValue( String filePath,String[] inputParams) {
            String line;
            String csvSkills="";
            Integer paramCount = inputParams.length;
            HashMap<Integer,String[]> matchValues = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                int lineNumer =0;
                while ((line = reader.readLine()) != null) {
                    lineNumer = lineNumer+1;
                    //separate inpunt params and match value
                    String[] keyValuePair = line.split(":");
                    String keys = keyValuePair[0];
                    String[] keyValues = line.split(",");
                    //String[] elements = {"a", "a", "a", "a"};
                    // build matchcount array

                    Boolean matchRowFound = true;
                    for (int i = 0; i < keyValues.length; i++) {
                        if(!inputParams[i].equals("")){

                        }
                        else if (!inputParams[i].equals("*")){

                        }
                        if(!inputParams[i].equals(keyValues[i])){
                            matchRowFound= false;
                        }
                    }

                    if(matchRowFound){
                        matchValues.put(lineNumer,keyValuePair[1].split(","));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return matchValues;
        }
    public static String byBufferedReaderSkilllistWithoutSkilltype() {
        return IOLoader.byBufferedReaderSkilllistWithoutSkilltype(skillListFile);
    }
    private static String byBufferedReaderSkilllistWithoutSkilltype(String filePath) {
        String line;
        String csvSkills="";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                String[] keyValuePair = line.split(",");
                csvSkills = csvSkills +"'"+(keyValuePair[0])+"', ";
            }
            String toReplace =",";
            int start = csvSkills.lastIndexOf(toReplace);
            String replacement ="";
            StringBuilder builder = new StringBuilder();
            builder.append(csvSkills.substring(0, start));
            builder.append(toReplace); //replacement string
            builder.append(csvSkills.substring(start + toReplace.length()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvSkills;
    }
}
