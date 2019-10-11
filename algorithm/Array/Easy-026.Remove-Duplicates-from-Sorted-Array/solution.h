#include <vector>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int count = 0;

        if (nums.size() == 0) return 0;

        for (int j = 0; j < nums.size(); ++j) {
            int i = 0;
            for (i = 0; i < count; ++i) {
                if (nums[j] == nums[i]) {
                    break;
                }
            }
            if (i >= count) {
                nums[count++] = nums[j];
            }
        }
        return count;
    }
};
