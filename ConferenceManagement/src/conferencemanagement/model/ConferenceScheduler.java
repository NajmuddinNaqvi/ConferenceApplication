package conferencemanagement.model;

import conferencemanagement.util.ParsingUtil;

import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;
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
        String talkName = null;
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            try {
                inputLine = sc.nextLine();
//                System.out.println(inputLine);
                duration = inputLine.substring(inputLine.lastIndexOf(" ")+1, inputLine.length());
                talkName = ParsingUtil.getTalkName(inputLine);
                talkList.add(ParsingUtil.parseAndCreateTalk(inputLine, duration));
            }
            catch(IllegalArgumentException e) {
            System.out.println("Wrong input format. Please try your luck at Tedx: " + e.getMessage());
            }
        }
//        for(Talk iter : talkList) {
//            System.out.println(iter.toString());
//        }
        Conference conference = new Conference();
        while(talkList.size() != 0) {
            Session morningSession = new Session(Constants.SESSION_TYPE_MORNING);
            addTalksToSession(morningSession, talkList);
            Session afternoonSession = new Session(Constants.SESSION_TYPE_AFTERNOON);
            addTalksToSession(afternoonSession, talkList);
            
            Track track = new Track();
            track.addSession(morningSession);
            track.addSession(afternoonSession);
            
            conference.addTrack(track);
        }
        System.out.println(conference.toString());

    }
    private static void addTalksToSession(Session session, List<Talk> talkList) {
        Iterator<Talk> iterator = talkList.iterator();
        
        while(iterator.hasNext()) {
            Talk talk = iterator.next();
            if(session.canHaveMoreTalks(talk.getTalkDuration())) {
                session.addTalk(talk);
                iterator.remove();
            }
        }
    }
}
