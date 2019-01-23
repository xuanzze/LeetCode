public boolean isMatch(String s, String p) {
    int sid = 0, pid = 0, match = 0, starid = -1;
    while (sid < s.length()) {
        if (pid < p.length() && (p.charAt(pid) == '?' || s.charAt(sid) == p.charAt(pid))) {	
            sid++;
            pid++;
        } else if (pid < p.length() && p.charAt(pid) == '*') {
            match = sid;
            starid = pid;
            pid++;
        } else if (starid != -1) 
            pid = starid + 1;
            sid = ++match;
        } else
            return false;
    }
    while (pid < p.length() && p.charAt(pid) == '*')
        pid++;
    return pid == p.length();
}
