public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    for (String token : path.split("/")) {
        if (token.equals("..")) {
            if (! stack.isEmpty())
                stack.pop();
        } else if (!token.isEmpty() && !token.equals("."))
            stack.push(token);
    }
    StringBuilder sb = new StringBuilder();
    while (! stack.isEmpty())
        sb.append("/").append(stack.pollLast());

    return sb.length() == 0? "/": sb.toString();
}
