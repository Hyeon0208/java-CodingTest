class 하샤드수 {
    public boolean solution(int x) {
        int sum = 0;
        int n = x;
        
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }
        
        return x % sum == 0 ? true : false;
    }
}
