public int reverseBits(int n) {
    int c = 0;
    for (int i = 0; i < 32; i++) {
        c = (c << 1) + (n & 1);
        n >>>= 1;
    }
    return c;
}
