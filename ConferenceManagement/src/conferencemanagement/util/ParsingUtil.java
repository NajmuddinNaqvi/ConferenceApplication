package conferencemanagement.util;

import conferencemanagement.model.Constants;
import conferencemanagement.model.Talk;
import java.util.regex.*;

public class ParsingUtil {
    public ParsingUtil() {
        super();
    }
    private static Pattern pattern = null;
    private static Matcher matcher = null;
    public static Talk parseAndCreateTalk(String inputLine, String duration) throws IllegalArgumentException {
        Talk talk = null;
        if(duration.contains("min")) {
            talk = new Talk(getTalkName(inputLine), duration.substring(0,duration.indexOf(Constants.MIN_TALK)));
            return talk;
        }
        else if(duration.contains("lightning")) {
            talk = new Talk(getTalkName(inputLine), Constants.DURATION_LIGHTNING);
            return talk;
        }
        else throw new IllegalArgumentException();
    }
    public static String getTalkName(String inputLine) {
        String talkName = null;
        pattern = Pattern.compile(Constants.TALK_TIME_MINUTE_PATTERN);
        matcher = pattern.matcher(inputLine);
        while(matcher.find()) {
            talkName = inputLine.substring(0, matcher.start()-1).trim();
        }
        if(talkName == null) {
            pattern = Pattern.compile(Constants.TALK_TIME_LIGHTNING_PATTERN);
            matcher = pattern.matcher(inputLine);
            while(matcher.find()) {
                talkName = inputLine.substring(0, matcher.start()).trim();    
            }
        }
        return talkName;
    }
}
