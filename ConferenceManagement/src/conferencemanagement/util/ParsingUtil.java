package conferencemanagement.util;

import conferencemanagement.model.Constants;
import conferencemanagement.model.Talk;

public class ParsingUtil {
    public ParsingUtil() {
        super();
    }
    public static Talk parseAndCreateTalk(String inputLine, String duration) throws IllegalArgumentException {
        Talk talk = null;
        if(duration.contains("min")) {
            System.out.println("Valid talk. Talk length: " + duration.substring(0,duration.indexOf(Constants.MIN_TALK)));
            talk = new Talk(inputLine, duration.substring(0,duration.indexOf(Constants.MIN_TALK)));
            return talk;
        }
        else if(duration.contains("lightning")) {
            System.out.println("Valid talk. Talk length: " + duration.substring(0,duration.indexOf(Constants.LIGHTNING_TALK)));
            talk = new Talk(inputLine, duration.substring(0,duration.indexOf(Constants.LIGHTNING_TALK)));
            return talk;
        }
        else throw new IllegalArgumentException();
    }
}
