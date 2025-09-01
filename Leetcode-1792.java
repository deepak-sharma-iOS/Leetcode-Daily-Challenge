class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) { // O(n)
            int pass = c[0];
            int total = c[1];
            double gain = gainA(pass, total);

            pq.offer(new double[]{gain, pass, total});
        } 

        for (int s = 0; s < extraStudents; s++) { // O(m)
            double[] top = pq.poll();

            int pass = (int) top[1] + 1;
            int total = (int) top[2] + 1;
            double gain = gainA(pass, total);

            pq.offer(new double[]{gain, pass, total});
        }

        double result = 0.0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            result += top[1] / top[2];
        }

        return result / classes.length;
    }

    private double gainA(int pass, int total) {
        return (double) (pass + 1) / (total + 1) - (double) pass / total;
    }
}
