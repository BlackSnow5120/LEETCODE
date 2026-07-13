class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        int firstNum = 0;
        int powerOfLow = 0;
        long pow = 1;

        while (low / pow > 0) {
            pow *= 10;
            powerOfLow++;
        }
        long digit = 1;
        for (int i = 0; i < powerOfLow; i++) {
            firstNum += digit;
            firstNum *= 10;
            digit++;
        }
        System.out.println(firstNum);
        firstNum /= 10;
        long num = (long)firstNum;
        int powerOfnum = powerOfLow;
        while (num <= high) {
            if(num>=low) list.add((int)num);
            digit = num % 10;
            if (digit == 9) {
                pow *= 10;
                powerOfnum++;
                digit = 1;
                num = 0;
                for (int i = 0; i < powerOfnum; i++) {
                    num += digit;
                    num *= 10;
                    digit++;
                }
                num /= 10;

            } else {
                num *= 10;
                digit++;
                num += digit;
                num %= pow;

            }

        }
        return list;

    }
}