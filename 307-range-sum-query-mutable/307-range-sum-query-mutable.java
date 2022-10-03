class NumArray {
        private int[] segmentTree;
        private int[] nums;
        public NumArray(int[] nums) {
            this.nums = Arrays.copyOf(nums, nums.length);

            int heightOfSegmentTree = (int) Math.ceil(Math.log(nums.length) / Math.log(2)) + 1;
            int sizeOfSegmentTree = (int) Math.pow(2, heightOfSegmentTree);
            segmentTree = new int[sizeOfSegmentTree];

            int rootNode = 1;
            initSegmentTree(rootNode, nums, 0, nums.length - 1);
        }

        private void initSegmentTree(int node, int[] nums, int left, int right) {
            if (left == right) {
                segmentTree[node] = nums[left];
                return;
            }

            int leftChildNode = 2 * node;
            int rightChildNode = 2 * node + 1;

            int mid = (left + right) / 2;
            initSegmentTree(leftChildNode, nums, left, mid);
            initSegmentTree(rightChildNode, nums, mid + 1, right);

            segmentTree[node] = segmentTree[leftChildNode] + segmentTree[rightChildNode];
        }

        public void update(int index, int val) {
            int rootNode = 1;
            updateSegmentTree(rootNode, 0, nums.length - 1, index, val);
        }

        private void updateSegmentTree(int node, int left, int right, int index, int newValue) {
            if (left > index || index > right) {
                return;
            }

            if (left == right) {
                segmentTree[node] = newValue;
                return;
            }

            int leftChildNode = 2 * node;
            int rightChildNode = 2 * node + 1;

            int mid = (left + right) / 2;
            updateSegmentTree(leftChildNode, left, mid, index, newValue);
            updateSegmentTree(rightChildNode, mid + 1, right, index, newValue);

            segmentTree[node] = segmentTree[leftChildNode] + segmentTree[rightChildNode];
        }

        public int sumRange(int left, int right) {
            int rootNode = 1;
            return getSum(rootNode, 0, nums.length - 1, left, right);
        }

        private int getSum(int node, int left, int right, int start, int end) {
            if (end < left || right < start) {
                return 0;
            }

            if (start <= left && right <= end) {
                return segmentTree[node];
            }

            int leftChildNode = 2 * node;
            int rightChildNode = 2 * node + 1;

            int mid = (left + right) / 2;

            int sumOfLeftChild = getSum(leftChildNode, left, mid, start, end);
            int sumOfRightChild = getSum(rightChildNode, mid + 1, right, start, end);
            return sumOfLeftChild + sumOfRightChild;
        }
    }
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */