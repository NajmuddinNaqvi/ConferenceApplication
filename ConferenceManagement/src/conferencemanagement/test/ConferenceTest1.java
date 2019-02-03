package conferencemanagement.test;

import conferencemanagement.model.Conference;

import org.junit.Test;
import static org.junit.Assert.*;
import conferencemanagement.model.*;

import conferencemanagement.util.DateUtil;

public class ConferenceTest1 {
    public ConferenceTest1() {
        super();
    }
    @Test
    public void test1() {
        Conference conf = null;
        conf = new Conference();
        assertNotNull(conf);
    }
}
