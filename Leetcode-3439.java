class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int blockSize = (int) Math.floor(Math.sqrt(n));
        int numBlocks = (n + blockSize - 1) / blockSize;

        int[] perBlockMax = new int[numBlocks];
        for (int i = 0; i < n; i++) {
            int b = i / blockSize; // 5 / 3 = 1
            perBlockMax[b] = Math.max(perBlockMax[b], baskets[i]); 
        }

        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            int fruit = fruits[i];
            int blockIndex = -1;

            for (int b = 0; b < numBlocks; b++) {
                if (perBlockMax[b] >= fruit) {
                    blockIndex = b;
                    break;
                }
            }

            if (blockIndex == -1) {
               unplaced += 1;
               continue; 
            }

            boolean isPlaced = false;
            int start = blockIndex * blockSize;
            int end = Math.min(n, (blockIndex + 1) * blockSize);

            for (int j = start; j < end; j++) {
                if (baskets[j] >= fruit) {
                    baskets[j] = 0;
                    isPlaced = true;
                    break;
                } 
            }

            int max = Integer.MIN_VALUE;
            for (int j = start; j < end; j++) {
                max = Math.max(max, baskets[j]);
                perBlockMax[blockIndex] = max;
            } 

            if (!isPlaced) {
                unplaced += 1;
            }
        }


        return unplaced;
    }
}
