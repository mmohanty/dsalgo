package org.manas.dsalgo.interviewbit.array;

import java.util.Arrays;
import java.util.List;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Try to solve it in linear time/space.
 *
 * Example :
 *
 * Input : [1, 10, 5]
 * Output : 5
 * Return 0 if the array contains less than 2 elements.
 *
 * 1. You may assume that all the elements in the array are non-negative integers and fit in the 32-bit
 * signed integer range.
 * 2. You may also assume that the difference will not overflow.
 */
public class MaximumConsecutiveGap {

    public static void main(String[] args) {
        int a[] = {83564666, 2976674, 46591497, 24720696, 16376995, 63209921, 25486800, 49369261, 20465079, 64068560, 7453256, 14180682, 65396173, 45808477, 10172062, 28790225, 82942061, 88180229, 62446590, 77573854, 79342753, 2472968, 74250054, 17223599, 47790265, 24757250, 40512339, 24505824, 30067250, 82972321, 32482714, 76111054, 74399050, 65518880, 94248755, 76948016, 76621901, 46454881, 40376566, 13867770, 76060951, 71404732, 21608002, 26893621, 27370182, 35088766, 64827587, 67610608, 90182899, 66469061, 67277958, 92926221, 58156218, 44648845, 37817595, 46518269, 44972058, 27607545, 99404748, 39262620, 98825772, 89950732, 69937719, 78068362, 78924300, 91679939, 52530444, 71773429, 57678430, 75699274, 5835797, 74160501, 51193131, 47950620, 4572042, 85251576, 49493188, 77502342, 3244395, 51211050, 44229120, 2135351, 47258209, 77312779, 37416880, 59038338, 96069936, 20766025, 35497532, 67316276, 38312269, 38357645, 41600875, 58590177, 99257528, 99136750, 4796996, 84369137, 54237155, 64368327, 94789440, 40718847, 12226041, 80504660, 8177227, 85151842, 36165763, 72764013, 36326808, 80969323, 22947547, 76322099, 7536094, 18346503, 65759149, 45879388, 53114170, 92521723, 15492250, 42479923, 20668783, 64053151, 68778592, 3669297, 73903133, 28973293, 73195487, 64588362, 62227726, 17909010, 70683505, 86982984, 64191987, 71505285, 45949516, 28244755, 33863602, 18256044, 25110337, 23997763, 81020611, 10135495, 925679, 98158797, 73400633, 27282156, 45863518, 49288993, 52471826, 30553639, 76174500, 28828417, 41628693, 80019078, 64260962, 5577578, 50920883, 16864714, 54950300, 9267396, 56454292, 40872286, 33819401, 75369837, 6552946, 26963596, 22368984, 43723768, 39227673, 98188566, 1054037, 28292455, 18763814, 72776850, 47192134, 58393410, 14487674, 4852891, 44100801, 9755253, 37231060, 42836447, 38104756, 77865902, 67635663, 43494238, 76484257, 80555820, 8632145, 3925993, 81317956, 12645616, 23438120, 48241610, 20578077, 75133501, 46214776, 35621790, 15258257, 20145132, 32680983, 94521866, 43456056, 19341117, 29693292, 38935734, 62721977, 31340268, 91841822, 22303667, 96935307, 29160182, 61869130, 33436979, 32438444, 87945655, 43629909, 88918708, 85650550, 4201421, 11958347, 74203607, 37964292, 56174257, 20894491, 33858970, 45292153, 22249182, 77695201, 34240048, 36320401, 64890030, 81514017, 58983774, 88785054, 93832841, 12338671, 46297822, 26489779, 85959340};
        List<Integer> list = ArrayUtil.toList(a);
        MaximumConsecutiveGap maximumConsecutiveGap = new MaximumConsecutiveGap();
        int result = maximumConsecutiveGap.maximumGap(list);
        System.out.println(result);
    }
    public int maximumGap(final List<Integer> A) {
        // Find maximum and minimum in arr[]
        int maxVal = A.get(0);
        int minVal = A.get(0);
        int n = A.size();
        for (int i = 1; i < n; i++) {
            maxVal = Math.max(maxVal, A.get(i));
            minVal = Math.min(minVal, A.get(i));
        }

        // Arrays to store maximum and minimum values
        // in n-1 buckets of differences.
        int maxBucket[] = new int[n];
        int minBucket[] = new int[n];
        Arrays.fill(maxBucket, 0, n - 1, Integer.MIN_VALUE);
        Arrays.fill(minBucket, 0, n - 1, Integer.MAX_VALUE);

        // Expected gap for every bucket.
        float delta
                = (float)(maxVal - minVal) / (float)(n - 1);

        // Traversing through array elements and
        // filling in appropriate bucket if bucket
        // is empty. Else updating bucket values.
        for (int i = 0; i < n; i++) {
            if (A.get(i) == maxVal || A.get(i) == minVal) {
                continue;
            }

            // Finding index of bucket.
            int index = (int)(Math.round((A.get(i) - minVal)
                    / delta));

            // Filling/Updating maximum value of bucket
            if (maxBucket[index] == Integer.MIN_VALUE) {
                maxBucket[index] = A.get(i);
            }
            else {
                maxBucket[index]
                        = Math.max(maxBucket[index], A.get(i));
            }

            // Filling/Updating minimum value of bucket
            if (minBucket[index] == Integer.MAX_VALUE) {
                minBucket[index] = A.get(i);
            }
            else {
                minBucket[index]
                        = Math.min(minBucket[index], A.get(i));
            }
        }

        // Finding maximum difference between maximum value
        // of previous bucket minus minimum of current
        // bucket.
        int prev_val = minVal;
        int max_gap = 0;
        for (int i = 0; i < n - 1; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) {
                continue;
            }
            max_gap = Math.max(max_gap,
                    minBucket[i] - prev_val);
            prev_val = maxBucket[i];
        }
        max_gap = Math.max(max_gap, maxVal - prev_val);

        return max_gap;

    }
}
