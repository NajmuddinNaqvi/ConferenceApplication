package conferencemanagement.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import conferencemanagement.util.*;

public class Session {
    public Session() {
        super();
    }
    private boolean moreTalks = true;
    private String sessionType = null;
    private int remainingTime = 0;
    private List<Talk> talkList = null;
    private Calendar sessionCalendar = null;

    public void setSessionCalendar(Calendar sessionCalendar) {
        this.sessionCalendar = sessionCalendar;
    }

    public Calendar getSessionCalendar() {
        return sessionCalendar;
    }

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
    
    public Session(String sessionType) {
        this.sessionType = sessionType;
        this.moreTalks = true;
        this.sessionCalendar = DateUtil.getCalendarForSession(sessionType);
        setRemainingTimeBasedOnSessionType(this.sessionType);
    }

    public void setTalkList(List<Talk> talkList) {
        this.talkList = talkList;
    }

    public List<Talk> getTalkList() {
        return talkList;
    }
    
    public boolean canHaveMoreTalks(String duration) {
        boolean moreTalks = (remainingTime >= Integer.parseInt(duration)) ? true : false;
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
    public void addTalk(Talk talk) {
        if(talkList == null) {
            talkList = new ArrayList<Talk>();
        }   
        talkList.add(talk);
        talk.setTalkTime(DateUtil.getTime(this.sessionCalendar.getTime()));
        this.addTimeToSessionCalendar(Integer.parseInt(talk.getTalkDuration()));
        this.setRemainingTime(this.remainingTime-Integer.parseInt(talk.getTalkDuration()));
    }
    private void addTimeToSessionCalendar(int minutes) {
        this.sessionCalendar.add(Calendar.MINUTE, minutes);    
    }
    public String getSessionTypeDisplay() {
        if(this.sessionType.equals(Constants.SESSION_TYPE_MORNING))
            return "Morning Session";
        else return "Afternoon Session";
    }
    public String toString() {
        String sessionDisplayString = null;
        StringBuilder sessionDisplayBuilder = new StringBuilder();
        if(this.talkList != null && this.talkList.size() != 0) {
            for(Talk talk : this.talkList) {
                sessionDisplayBuilder.append(talk.toString());
            }   
        }
        
        sessionDisplayString = sessionDisplayBuilder.toString();
        return sessionDisplayString;
    }
}
