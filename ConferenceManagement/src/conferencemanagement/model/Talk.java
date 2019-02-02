package conferencemanagement.model;

import conferencemanagement.util.DateUtil;

import java.util.Date;

public class Talk {
    public Talk() {
        super();
    }
    String talkName;
    String talkDuration;
    Date talkScheduledTime;

    public void setTalkScheduledTime(Date talkScheduledTime) {
        this.talkScheduledTime = talkScheduledTime;
    }

    public Date getTalkScheduledTime() {
        return talkScheduledTime;
    }

    public Talk(String talkName, String talkDuration) {
        this.talkName = talkName;
        this.talkDuration = talkDuration;
    }
    public Talk(String talkName, String talkDuration, Date talkScheduledTime) {
        this.talkName = talkName;
        this.talkDuration = talkDuration;
        this.talkScheduledTime = talkScheduledTime;
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
    public String toString() {
        return "Talk scheduled time: " + DateUtil.getTime(talkScheduledTime) + "Talk name: " + talkName + "\n" + "Talk duration: " + talkDuration;    
    }
}
