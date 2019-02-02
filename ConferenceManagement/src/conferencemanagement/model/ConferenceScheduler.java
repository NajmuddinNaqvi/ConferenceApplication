package conferencemanagement.model;

import conferencemanagement.util.ParsingUtil;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConferenceScheduler {
    public ConferenceScheduler() {
        super();
    }
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\conference_track_management\\input.txt");
        List<Talk> talkList = new ArrayList<Talk>();
        Talk talk = null;
        String duration = null;
        String inputLine = null;
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            try {
                inputLine = sc.nextLine();
                System.out.println(inputLine);
                duration = inputLine.substring(inputLine.lastIndexOf(" "), inputLine.length());
                System.out.println(duration);
                if(duration.contains("min") || duration.contains("lightning")) {
                    System.out.println("Valid talk. Talk length: " + duration.substring(0,duration.indexOf("min")));
                }
                talkList.add(ParsingUtil.parseAndCreateTalk(inputLine, duration));
            }
            catch(IllegalArgumentException e) {
            System.out.println("Wrong input format. Please try your luck at Tedx: " + e.getMessage());
            }
        }
        for(Talk iter : talkList) {
            System.out.println(iter.toString());
        }
    }
}
