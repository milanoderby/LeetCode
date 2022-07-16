class Solution {
    public String simplifyPath(String path) {
        List<String> pathList = Arrays.stream(path.split("/"))
            .collect(Collectors.toList());

        Stack<String> pathStack = new Stack<>();
        for (String fileName : pathList) {
            switch (fileName) {
                case "":
                    break;
                case ".":
                    break;
                case "..":
                    if (!pathStack.isEmpty()) {
                        pathStack.pop();
                    }
                    break;
                default:
                    pathStack.push(fileName);
                    break;
            }
        }

        String answer = pathStack.stream()
            .collect(Collectors.joining("/"));
        return "/" + answer;
    }
}