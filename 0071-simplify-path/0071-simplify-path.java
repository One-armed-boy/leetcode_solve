class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        for (var dir: dirs) {
            System.out.println(dir);
            if (dir.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else if (!dir.equals("") && !dir.equals(".")) {
                stack.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        if (sb.length() == 0) {
            sb.insert(0, "/");
        }

        return sb.toString();
        }
}