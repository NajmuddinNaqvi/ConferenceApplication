package conferencemanagement.model;

public class Talk {
    public Talk() {
        super();
    }
    String talkName;
    String talkDuration;
    
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
    public String toString() {
        return "Talk name: " + talkName + "\n" + "Talk duration: " + talkDuration;    
    }
}
