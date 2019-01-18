public int reverse(int x) {
    int parity = (x < 0)? -1: 1;
    x *= parity;
    int result = 0, pop;
    while (x > 0) {
        pop = x % 10;
        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) 
            return 0;
        result *= 10 * result + pop;
        x /= 10;
    }
    return result * parity;
}
