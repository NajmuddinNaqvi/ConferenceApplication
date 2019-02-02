package conferencemanagement.model;

import java.util.List;

public class Track {
    public Track() {
        super();
    }

    public void setSessionList(List sessionList) {
        this.sessionList = sessionList;
    }

    public List getSessionList() {
        return sessionList;
    }
    private List<Session> sessionList;
}
