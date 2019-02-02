package conferencemanagement.model;

import java.util.List;

public class Session {
    public Session() {
        super();
    }
    private boolean moreTalks = true;
    private String sessionType = null;

    public void setMoreTalks(boolean moreTalks) {
        this.moreTalks = moreTalks;
    }

    public boolean isMoreTalks() {
        return moreTalks;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }
    private int remainingTime = 0;
    
    public Session(String sessionType) {
        this.sessionType = sessionType;
        this.moreTalks = true;
        setRemainingTimeBasedOnSessionType(this.sessionType);
    }

    public void setTalkList(List<Talk> talkList) {
        this.talkList = talkList;
    }

    public List<Talk> getTalkList() {
        return talkList;
    }
    private List<Talk> talkList;
    
    public boolean canHaveMoreTalks(int duration) {
        boolean moreTalks = (remainingTime > duration) ? true : false;
        return moreTalks;
    }

    private void setRemainingTimeBasedOnSessionType(String sessionType) {
        if(Constants.SESSION_TYPE_MORNING.equals(sessionType)) {
            this.remainingTime = Integer.parseInt(Constants.REMAINING_TIME_MORNING_SESSION);
        }
        else {
            this.remainingTime = Integer.parseInt(Constants.REMAINING_TIME_AFTERNOON_SESSION);
        }
    }
}
