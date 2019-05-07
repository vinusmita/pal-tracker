package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository {

    private Map<String, TimeEntry> timeEntryMap;

    public InMemoryTimeEntryRepository() {
        this.timeEntryMap = new HashMap<String, TimeEntry>();
    }

    public TimeEntry create(TimeEntry timeEntry) {
        if (timeEntry.getId() == 0L) {
            timeEntry.setId(timeEntryMap.size() + 1);
        }

        this.timeEntryMap.put(Long.toString(timeEntry.getId()), timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return timeEntryMap.get(Long.toString(id));
    }

    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryMap.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntryMap.replace(Long.toString(id), timeEntry);
        return timeEntryMap.get(Long.toString(id));
    }

    public void delete(long id) {
        timeEntryMap.remove(Long.toString(id));
    }
}
