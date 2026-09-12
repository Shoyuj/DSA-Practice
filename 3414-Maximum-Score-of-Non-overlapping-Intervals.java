class Solution {
    class Node{
        int count;
        List<Integer> list;
        long total;
        int start;
        int end;
        public Node(int count, List<Integer> list, long total, int start, int end){
            this.count = count;
            this.list = list;
            Collections.sort(this.list);
            this.total = total;
            this.start = start;
            this.end = end;
        }
        public boolean check(Node n){
            // return true agar cur node is greater, else flase
            if(this.total > n.total)
                return true;
            else if (this.total < n.total)
                return false;
            
            // same hai, compare lexico graphically
            for(int i = 0;i < Math.min(this.list.size(), n.list.size());i++){
                if(this.list.get(i) < n.list.get(i))
                    return true;
                else if (this.list.get(i) > n.list.get(i))
                    return false;
            }
            return false;
        }
    }
    Node max;
    private List<Node> merge(List<Node> nodes, List<Node> merged){
        Collections.sort(merged, (Node a, Node b)->{
            if(a.end != b.end)
                return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });
        List<Node> ans = new ArrayList<>();
        Node localMax = null;
        int j = 0;
        Node n;
        for(int i = 0;i < nodes.size();i++){
            // add all items in merged which end before i'th node starts to the queue
            while(j < merged.size() && merged.get(j).end < nodes.get(i).start){
                if(localMax == null || !localMax.check(merged.get(j))){
                    localMax = merged.get(j);
                }
                j++;
            }
            if(localMax == null){
                continue;
            }
            Node top = localMax;
            List<Integer> list = new ArrayList<Integer>();
            list.addAll(top.list);
            list.addAll(nodes.get(i).list);
            n = new Node(top.count+1, list, nodes.get(i).total + top.total,top.start, nodes.get(i).end);
            // queue.add(n);
            ans.add(n);
            // ans.add(nodes.get(i));
            if(!max.check(n)){
                max = new Node(n.count, n.list, n.total, n.start, n.end);
            }
        }
        return ans;
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        List<Node> nodes = new ArrayList<>();
        max = null;
        List<Node> merged = new ArrayList<>();
        for(int i =0;i < intervals.size();i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            Node n = new Node(1, temp, intervals.get(i).get(2)*1L, intervals.get(i).get(0), intervals.get(i).get(1));
            nodes.add(n);
            merged.add(n);
            if(max == null){
                max = n;
            } else if(!max.check(n)){
                max = n;
            }
        }
        // by now we already have the max value if we were to select ek node bas
        Collections.sort(nodes, (Node a, Node b)->{
            if(a.start == b.start)
                return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });
        
        // now we attempt for 2 items
        merged = merge(nodes, merged);
        // // ab 3 items

        merged = merge(nodes, merged);
        // // now 4

        merge(nodes, merged);
        // abhi max ke list ko array mai convert karo
        int ans[] = new int[max.list.size()];
        for(int i = 0;i < ans.length;i++)
            ans[i] = max.list.get(i);
        return ans;
    }
}