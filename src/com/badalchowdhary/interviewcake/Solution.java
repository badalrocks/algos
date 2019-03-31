package com.badalchowdhary.interviewcake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Solution {

    public static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        // merge meetings ranges
        List<Meeting> sortedMeetings = new ArrayList<>();
        for (Meeting m : meetings)
        {
            sortedMeetings.add(m);
        }
        
        Collections.sort(sortedMeetings, new Comparator<Meeting>(){
            @Override
            public int compare(Meeting m1, Meeting m2)
            {
                return m1.getStartTime() - m2.getStartTime();
            }
        });
        
        List<Meeting> mergedMeetings = new ArrayList<>();
        Meeting prevMeeting = sortedMeetings.get(0);
        
        for (int i=1; i<sortedMeetings.size(); i++)
        {
            Meeting currentMeeting = sortedMeetings.get(i);
            
            if (currentMeeting.getStartTime() > prevMeeting.getEndTime())
            {
                mergedMeetings.add(prevMeeting);
                prevMeeting = currentMeeting;
            }
            else
            {
                prevMeeting.setStartTime(Math.min(prevMeeting.getStartTime(), 
                                                    currentMeeting.getStartTime()));
                prevMeeting.setEndTime(Math.max(prevMeeting.getEndTime(), 
                                                    currentMeeting.getEndTime()));                                                    
            }
        }
        
        // add last meeting
        mergedMeetings.add(prevMeeting);

        return mergedMeetings;
    }

    public static void main(String[] args) {
        Meeting[] meetings = {
            new Meeting(0, 1),
            new Meeting(3, 5),
            new Meeting(4, 8),
            new Meeting(10, 12),
            new Meeting(9, 10)
        };

        List<Meeting> result = mergeRanges(Arrays.asList(meetings));
        for (Meeting meeting: result) {
            System.out.printf("(%d, %d) ", meeting.getStartTime(),
                                meeting.getEndTime());
        }
        System.out.println();
    }
}