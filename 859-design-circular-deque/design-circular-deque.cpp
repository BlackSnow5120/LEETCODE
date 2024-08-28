class MyCircularDeque {
public:
    vector<int> vec;
    int start = -1;
    int end = -1;
    int size=0;
    int max_s=0;
    MyCircularDeque(int k) {
        max_s=k;
    }
    
    bool insertFront(int value) {
        if(size == max_s)
        {
            return false;
        }
        if(start==-1)
        {
            vec.push_back(value);
            start++;
            end++;
        }
        else
        {
            vec.insert(vec.begin() + start,value);
            end++;
        }
        size++;
        return true;
    }
    
    bool insertLast(int value) {
        if(size == max_s)
        {
            return false;
        }
        if(start==-1)
        {
            vec.push_back(value);
            start++;
            end++;
        }
        else
        {
        vec.push_back(value);
            end++;
        }
        size++;

        return true;
    }
    
    bool deleteFront() {
        if(size==0){return false;}
        start++;
        size--;
        return true;
    }
    
    bool deleteLast() {
        if(size==0){return false;}
        vec.pop_back();
        end--;
        size--;
        return true;

    }
    
    int getFront() {
        if(size==0){return -1;}

        return vec[start];
    }
    
    int getRear() {
        if(size==0){return -1;}
        return vec[vec.size()-1];
    }
    
    bool isEmpty() {
        return size==0;
    }
    
    bool isFull() {
        return size==max_s;
    }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */