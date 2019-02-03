package conferencemanagement.model;

import conferencemanagement.util.DateUtil;

import java.util.Date;

public class Talk {
    public Talk() {
        super();
    }
    String talkName;
    String talkDuration;
    String talkTime;

    public void setTalkTime(String talkTime) {
        this.talkTime = talkTime;
    }

    public String getTalkTime() {
        return talkTime;
    }

    public Talk(String talkName, String talkDuration) {
        this.talkName = talkName;
        this.talkDuration = talkDuration;
    }

    public void setTalkName(String talkName) {
        this.talkName = talkName;
    }

    public String getTalkName() {
        return talkName;
    }

    public void setTalkDuration(String talkDuration) {
        this.talkDuration = talkDuration;
    }

    public String getTalkDuration() {
        return talkDuration;
    }
//    public String toString() {
//        return "Talk scheduled time: " + DateUtil.getTime(talkScheduledTime) + "Talk name: " + talkName + "\n" + "Talk duration: " + talkDuration;    
//    }
    public String toString() {
        return this.getTalkTime() + ": " + talkName + "\n";    
    }
}
