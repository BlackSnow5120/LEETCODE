class Solution {
public:
    bool isLongPressedName(string name, string typed) {
        int a = 0;
        int b = 0;
        char prev = name[0];
        int size1 = name.size();
        int size2 = typed.size();
        int flag = 0;
        while (a < size1 && b < size2) {
            if (!(typed[b] == prev || typed[b] == name[a]))
                flag = 1;
            if (name[a] == typed[b]) {
                prev = name[a];
                a++;
            }
            b++;
        }
        char check = typed[b - 1];
        while (b < size2) {
            if (check != typed[b++])
                flag = 1;
        }
        return a == size1 && flag == 0;
    }
};