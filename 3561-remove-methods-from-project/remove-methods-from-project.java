class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<ArrayList<Integer>> adjArray = new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<n;i++){
            adjArray.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n];
        for(int[] i : invocations){
            adjArray.get(i[0]).add(i[1]);
            indegree[i[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        boolean[] isSus = new boolean[n];
        while(!q.isEmpty()){
            int curr = q.peek();
            q.poll();
            isSus[curr]=true;
            for(int i : adjArray.get(curr)){
                if(!isSus[i]){
                    q.offer(i);
                }
            }
        }
        boolean canRemove = true;
        for(int[] i : invocations){
            if(isSus[i[1]] && !isSus[i[0]]){
                canRemove = false;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(canRemove==false || isSus[i]==false){
                ans.add(i);
            }
        }
        return ans;
    }
}