public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> res = new ArrayList<>();
    int i = 0;
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
        res.add(intervals.get(i++));
    }
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
        newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
        i++;
    }
    res.add(newInterval);
    while (i < intervals.size())
        res.add(intervals.get(i++));
    return res;
}
