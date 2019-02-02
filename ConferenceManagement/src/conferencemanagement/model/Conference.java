package conferencemanagement.model;

import java.util.List;

public class Conference {
    public Conference() {
        super();
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public List<Track> getTrackList() {
        return trackList;
    }
    private List<Track> trackList;
}

