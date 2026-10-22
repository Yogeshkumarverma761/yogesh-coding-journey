class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {

        // max heap to store the smaller half of the window
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // min heap to store the larger half of the window
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        int n = nums.length;
        double[] result = new double[n - k + 1];

        // stores elements that should be removed later (lazy deletion)
        Map<Integer, Integer> delayedRemoval = new HashMap<>();

        // build the first window
        for (int i = 0; i < k; i++) {

            maxHeap.offer(nums[i]);

            // move the largest element from left half to right half
            minHeap.offer(maxHeap.poll());

            // rebalance the heaps
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        // store median of first window
        int windowIndex = 0;

        result[windowIndex] =
                (k % 2 == 0)
                        ? ((double) maxHeap.peek() + minHeap.peek()) / 2
                        : (double) maxHeap.peek();

        // slide the remaining windows
        for (int right = k; right < n; right++) {

            int incomingElement = nums[right];
            int outgoingElement = nums[windowIndex];

            // mark outgoing element for lazy deletion
            delayedRemoval.put(
                    outgoingElement,
                    delayedRemoval.getOrDefault(outgoingElement, 0) + 1
            );

            // tracks how insertion and removal affect heap balance
            // +1 -> maxHeap gained one valid element
            // -1 -> minHeap gained one valid element
            //  0 -> heaps remain balanced
            int heapBalance = 0;

            // insert the incoming element
            if (incomingElement <= maxHeap.peek()) {
                maxHeap.offer(incomingElement);
                heapBalance++;
            } else {
                minHeap.offer(incomingElement);
                heapBalance--;
            }

            // determine which heap loses the outgoing element
            if (outgoingElement <= maxHeap.peek()) {
                heapBalance--;
            } else {
                heapBalance++;
            }

            // rebalance the heaps if required
            if (heapBalance > 0) {
                minHeap.offer(maxHeap.poll());
            }

            if (heapBalance < 0) {
                maxHeap.offer(minHeap.poll());
            }

            // remove stale elements from top of maxHeap
            while (!maxHeap.isEmpty()
                    && delayedRemoval.getOrDefault(maxHeap.peek(), 0) > 0) {

                int element = maxHeap.poll();

                delayedRemoval.put(
                        element,
                        delayedRemoval.get(element) - 1
                );
            }

            // remove stale elements from top of minHeap
            while (!minHeap.isEmpty()
                    && delayedRemoval.getOrDefault(minHeap.peek(), 0) > 0) {

                int element = minHeap.poll();

                delayedRemoval.put(
                        element,
                        delayedRemoval.get(element) - 1
                );
            }

            // store median of current window
            windowIndex++;

            result[windowIndex] =
                    (k % 2 == 0)
                            ? ((double) maxHeap.peek() + minHeap.peek()) / 2
                            : (double) maxHeap.peek();
        }

        return result;
    }
}