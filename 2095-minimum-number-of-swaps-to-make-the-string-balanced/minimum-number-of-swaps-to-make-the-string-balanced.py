class Solution:
    def minSwaps(self, s: str) -> int:
        stack = []
        for char in s:
            if(char == '['):
                stack.append('[')
            else:
                if(len(stack)==0 or stack[-1]!='[' ):
                    stack.append(']')
                else:
                    stack.pop()
        ans=0
        a=stack
        print(a)
        if(len(a)%2!=0):
            ans=-1
        elif(len(a)==0):
            return 0
        else:
            i=0
            j=len(a)-1
            ans=0
            while(i<j):
                if(a[i]=="]" and a[j]=="["):
                    ans+=1
                i+=1
                j-=1
        return (ans+1)//2
        