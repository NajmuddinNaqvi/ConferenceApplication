package conferencemanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Conference {
    public Conference() {
        super();
    }
    private List<Track> trackList;

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public List<Track> getTrackList() {
        return trackList;
    }
    public void addTrack(Track track) {
        if(trackList == null) {
            trackList = new ArrayList<Track>();    
        }
        trackList.add(track);
    }
    public String toString() {
        String conferenceDisplay = null;
        int trackCount = 0;
        StringBuilder conferenceDisplayBuilder = new StringBuilder();
        
        for(Track track : this.getTrackList()) {
            conferenceDisplayBuilder.append("Track " + ++trackCount + ":" + "\n");
            conferenceDisplayBuilder.append(track.toString());
        }
        conferenceDisplay = conferenceDisplayBuilder.toString();
        return conferenceDisplay;
    }
}

