//word ladder 2
class Solution {
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord == null || endWord == null || wordList == null) {//edge cases
            return res;
        }
        Map<String, Integer> ladder = new HashMap<>();//store the minimal steps to reach this string
        Map<String, List<String>> neighbors = new HashMap<>();//construct the graph
        Queue<String> queue = new LinkedList<>();//used to do BFS
        for (String s : wordList) { // initialize
            ladder.put(s, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        queue.add(beginWord);
        int min = Integer.MAX_VALUE;// minimal steps to reach the endWord
        while (!queue.isEmpty()) {
            String str = queue.poll();
            char[] arr = str.toCharArray();
            int step = ladder.get(str) + 1;// the minimal step to reach nextWord
            if (step > min) { // if already found endword
                break;
            }
            for (int i = 0; i < arr.length; i++) {
                char old = arr[i];
                for (int j = 'a'; j <= 'z'; j++) {//use character iteration to find all possible paths
                    arr[i] = (char)j;
                    String nextWord = new String(arr);
                    if (ladder.containsKey(nextWord)) {
                        if (step > ladder.get(nextWord)) { // not the shortest path to the nextword string
                            continue;
                        } else if (step <= ladder.get(nextWord)) {
                            if (step < ladder.get(nextWord)) { // it's the first time we find nextword, add it into the queue,
                                //otherwise gets TLE
                                queue.add(nextWord);
                                ladder.put(nextWord, step);
                            } 
                            List<String> neighbor = neighbors.getOrDefault(str, new ArrayList<String>());// build adjancency list
                            neighbor.add(nextWord);
                            neighbors.put(str, neighbor);
                            if (nextWord.equals(endWord)) {// updata the shortest stept to endword
                                min = step;
                            }
                        }  
                    }
                }
                arr[i] = old;
            }
        }
        List<String> path = new ArrayList<>();
        helper(beginWord, endWord, path, res, neighbors);//use DFS to find all pathes.
        return res;
    }
    
    private void helper(String cur, String end, List<String> path, List<List<String>> res,Map<String,List<String>> neighbors) {
        if (cur.equals(end)) {
            path.add(cur);
            res.add(new ArrayList<String>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(cur);
        List<String> neighbor = neighbors.get(cur);
        if (neighbor != null) {
            for (String next : neighbor) {
                helper(next, end, path, res, neighbors);
            }
        } 
        path.remove(path.size() - 1);
    }
}

//word ladder 1
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        Set<String> list = new HashSet<String>(wordList);// all words in the dictionary
        Set<String> visited = new HashSet<String>();//used in BFS to avoid endless loop
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (endSet.size() > beginSet.size()) {//switch
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> tmp = new HashSet<>();
            for (String str : beginSet) {
                char[] arr = str.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (int j = 'a'; j <= 'z'; j++) {
                        arr[i] = (char)j;
                        String nextWord = new String(arr);
                        if (endSet.contains(nextWord)) {
                            return len + 1;
                        }
                        if (list.contains(nextWord) && !visited.contains(nextWord)) {
                            tmp.add(nextWord);
                            visited.add(nextWord);
                        }
                        
                    }
                    arr[i] = old;
                }
            }
            len++;
            beginSet = tmp;
        }
        return 0;
    }
}



//use only BFS
class Solution {
    
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord == null || endWord == null || wordList == null) {//edge cases
            return res;
        }
        Map<String, Integer> ladder = new HashMap<>();//store the minimal steps to reach this string
        Map<String, String> prev = new HashMap<>();
        Queue<String> queue = new LinkedList<>();//used to do BFS
        for (String s : wordList) { // initialize
            ladder.put(s, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            char[] arr = str.toCharArray();
            int step = ladder.get(str) + 1;// the minimal step to reach nextWord
            for (int i = 0; i < arr.length; i++) {
                char old = arr[i];
                for (int j = 'a'; j <= 'z'; j++) {//use character iteration to find all possible paths
                    arr[i] = (char)j;
                    String nextWord = new String(arr);
                    if (ladder.containsKey(nextWord)) {
                        if (step > ladder.get(nextWord)) { // not the shortest path to the nextword string
                            continue;
                        } else if (step <= ladder.get(nextWord)) {
                            if (step < ladder.get(nextWord)) { // it's the first time we find nextword, add it into the queue,
                                //otherwise gets TLE
                                queue.add(nextWord);
                                ladder.put(nextWord, step);
                            } 
                            prev.put(nextWord, str);
                            if (nextWord.equals(endWord)) {
                                List<String> path = new ArrayList<>();
                                String cur = nextWord;
                                while(prev.containsKey(cur)) {
                                    path.add(0, cur);
                                    cur = prev.get(cur);
                                }
                                path.add(0, cur);
                                return path;
                            }
                        }  
                    }
                }
                arr[i] = old;
            }
        }
     
        return res;
    }
    
    
}