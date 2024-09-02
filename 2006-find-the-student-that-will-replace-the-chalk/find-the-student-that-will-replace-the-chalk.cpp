class Solution {
public:
    int chalkReplacer(vector<int>& chalk, int k) {
        int i=0;
        int n=chalk.size();
        long sum=0;
        for(int j=0;j<n;j++){
            sum+=chalk[j];
        }
        k=k%sum;
        while(k>=0){
            k-=chalk[i];        
            i++;
            if(i==chalk.size()) i=0;
        } 
        if(i==0) return chalk.size()-1;
        return i-1;

    }
};