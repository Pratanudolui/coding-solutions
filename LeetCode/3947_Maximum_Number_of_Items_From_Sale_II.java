class Solution {
    record Item(int price, int factor) implements Comparable<Item> {
        public int compareTo(Item other) {
            return Integer.compare(price, other.price);
        }
    }

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int cheapest = Arrays.stream(items).mapToInt(item -> item[1]).min().getAsInt();
        int[] have = new int[n + 1], deals = new int[n + 1];  // have[f]: items with factor f
        for (int[] item : items) have[item[0]]++;
        Arrays.fill(deals, -1);  // copies that come with a free one; from -1: the item itself is not a deal
        for (int factor = 1; factor <= n; factor++)
            for (int multiple = factor; multiple <= n; multiple += factor)
                deals[factor] += have[multiple];

        List<Item> worth = Arrays.stream(items).filter(item -> item[1] < 2 * cheapest)
                .map(item -> new Item(item[1], item[0])).sorted().toList();  // cheapest first
        int copies = 0;
        for (Item item : worth) {
            int pairs = Math.min(deals[item.factor], budget / item.price);  // buy one, get one free
            copies += 2 * pairs;
            budget -= pairs * item.price;
        }
        return copies + budget / cheapest;  // the rest goes to the cheapest item
    }
}
