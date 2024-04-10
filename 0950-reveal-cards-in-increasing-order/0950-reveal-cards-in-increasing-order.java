class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        List<IndexOrder> indexOrderList = new ArrayList<>();
        int order = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            indexOrderList.add(new IndexOrder(index, order));
            order++;

            if (queue.isEmpty()) {
                break;
            }
            queue.add(queue.poll());
        }

        Arrays.sort(deck);
        int[] answer = new int[deck.length];

        Collections.sort(indexOrderList, Comparator.comparingInt(IndexOrder::getOrder));

        for (int i = 0; i < indexOrderList.size(); i++) {
            answer[indexOrderList.get(i).index] = deck[i];
        }
        return answer;
    }
    
    private static class IndexOrder {
        private int index;
        private int order;

        public IndexOrder(int index, int order) {
            this.index = index;
            this.order = order;
        }

        public int getOrder() {
            return order;
        }
    }
}