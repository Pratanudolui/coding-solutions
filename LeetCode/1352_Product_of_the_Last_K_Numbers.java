class ProductOfNumbers {
    List<Integer> prefix = new ArrayList<>();
    int lastZero = 0;

    public ProductOfNumbers() {
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix.add(1);
            lastZero = prefix.size() - 1;
        } else {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = prefix.size() - 1;
        if (lastZero >= n - k + 1) return 0;
        return prefix.get(n) / prefix.get(n - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
