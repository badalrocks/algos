package com.sachin;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static void main(String args[]) throws Exception
    {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT
         */
        System.out.println("start");
        final Map<String, LogData> timeInHoursMinsAndLogDataMap = new LinkedHashMap();
        final Scanner input = new Scanner(System.in);
        int totalRecords = 0;
        final List<String> keysToRemove = new ArrayList<>(2);
        Set<String> processed = new HashSet<>();

        while (input.hasNext())
        {
            Long time = Long.parseLong(input.next());
            Double processingTime = Double.parseDouble(input.next());

            boolean process = true;
            final Date date = new Date(time * 1000);
            final String key = String.valueOf(date.getHours()) + ":" + String.valueOf(date.getMinutes());
            if (processed.contains(key))
                continue;
            if (timeInHoursMinsAndLogDataMap.size() > 0)
            {
                keysToRemove.clear();
                for (Map.Entry<String, LogData> entry : timeInHoursMinsAndLogDataMap.entrySet())
                {
                    final int diffSeconds = getDiffBetweenCurrentAndMapSeconds(key, entry.getKey(), date.getSeconds(),
                            entry.getValue().maxSeconds);
                    if (diffSeconds > 60)
                    {
                        System.out.println(entry.getValue().getResult());
                        keysToRemove.add(entry.getKey());
                        processed.add(entry.getKey());
                    }
                    else if (diffSeconds < -60)
                    {
                        process = false;
                        break;
                    }
                }
            }

            if (!process)
                continue;

            removeKeyFromMap(timeInHoursMinsAndLogDataMap, keysToRemove);

            LogData logData = timeInHoursMinsAndLogDataMap.get(key);
            if (logData == null)
            {
                logData = new LogData();
                logData.setTimeStamp(time);
            }
            logData.updateBuckets(processingTime);
            logData.updateMaxSeconds(date.getSeconds());
            timeInHoursMinsAndLogDataMap.put(key, logData);

        }

        for (Map.Entry<String, LogData> entry : timeInHoursMinsAndLogDataMap.entrySet())
        {
            System.out.println(entry.getValue().getResult());
        }
        
        System.out.println("end");
    }

    private static void removeKeyFromMap(final Map<String, LogData> timeInHoursMinsAndLogDataMap,
            final List<String> keysToRemove)
    {
        for (String keyToRemove : keysToRemove)
        {
            timeInHoursMinsAndLogDataMap.remove(keyToRemove);
        }
        keysToRemove.clear();
    }

    private static int getDiffBetweenCurrentAndMapSeconds(final String currentKey, final String keyFromMap,
            final int currentSeconds, final int secondsFromMap)
    {
        final String[] currentKeyArr = currentKey.split(":");
        final String[] keyFromMapArr = keyFromMap.split(":");
        final int totalCurrentSeconds = Integer.parseInt(currentKeyArr[0]) * 60 * 60
                + Integer.parseInt(currentKeyArr[1]) * 60 + currentSeconds;
        final int totalSecondsFromMap = Integer.parseInt(keyFromMapArr[0]) * 60 * 60
                + Integer.parseInt(keyFromMapArr[1]) * 60 + secondsFromMap;

        return totalCurrentSeconds - totalSecondsFromMap;
    }

    private static String find90ThPercentile(final int[] buckets, final Set<Integer> bucketsProcessed)
    {
        final int percentileRecord = (int) Math.round(0.9 * bucketsProcessed.size());
        int count = 0;
        int bucketCount = 0;
        int bucketIndex = 0;
        // while(count < percentileRecord && bucketCount <
        // bucketsProcessed.size()) {
        // if(buckets[bucketCount] != 0) {
        // bucketIndex = bucketCount;
        // count++;
        // }
        // bucketCount++;
        // }

        SortedSet<Integer> sortedBucketsProcessed = new TreeSet<>(bucketsProcessed);
        Iterator<Integer> it = sortedBucketsProcessed.iterator();
        while (count < percentileRecord)
        {
            bucketIndex = it.next();
            count++;
        }

        return String.valueOf(buckets[bucketIndex]);
    }

    static class LogData
    {
        private long         timeStamp;
        private int[]        buckets          = new int[150];
        private int          maxSeconds       = 0;
        private int          totalRecords     = 0;
        private Set<Integer> bucketsProcessed = new HashSet<>();

        void setTimeStamp(final long timeStamp)
        {
            this.timeStamp = timeStamp;
        }

        void updateBuckets(final double processingTime)
        {
            final int bucket = (int) Math.round(processingTime);
            if (bucket >= 150)
                return;

            buckets[bucket] = bucket;
            bucketsProcessed.add(bucket);
            totalRecords++;
        }

        String getResult()
        {
            Date dateWithTimeStamp = new Date(timeStamp * 1000);
            Date date = new Date(dateWithTimeStamp.getYear(), dateWithTimeStamp.getMonth(), dateWithTimeStamp.getDate(),
                    dateWithTimeStamp.getHours(), dateWithTimeStamp.getMinutes(), 0);
            String isoDate = sdf.format(date);
            String result = find90ThPercentile(buckets, bucketsProcessed);
            return (isoDate + " " + result);
        }

        void updateMaxSeconds(final int seconds)
        {
            maxSeconds = Math.max(maxSeconds, seconds);
        }
    }
}