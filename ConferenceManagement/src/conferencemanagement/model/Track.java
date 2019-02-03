package conferencemanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Track {
    public Track() {
        super();
    }
    private List<Session> sessionList;

    public void setSessionList(List sessionList) {
        this.sessionList = sessionList;
    }

    public List getSessionList() {
        return sessionList;
    }
    public void addSession(Session session) {
        if(sessionList == null) {
            sessionList = new ArrayList<Session>();    
        }
        sessionList.add(session);
    }
    public String toString() {
        String trackDisplay = null;
        StringBuilder trackDisplayBuilder = new StringBuilder();
        
        for(Session session : (List<Session>)this.getSessionList()) {
            trackDisplayBuilder.append(session.getSessionTypeDisplay() + ":\n");
            trackDisplayBuilder.append(session.toString());
        }
        trackDisplay = trackDisplayBuilder.toString();
        return trackDisplay;
    }
}
