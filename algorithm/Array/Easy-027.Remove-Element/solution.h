#include <vector>
using namespace std;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int count = nums.size() - 1;
        int val_tmp;
        for (int i = 0; i <= count; ++i) {
            if (nums[i] == val) {
                val_tmp = nums[i];
                nums[i] = nums[count];
                nums[count] = val_tmp;
                i--;
                count--;
            }
        }
        return count + 1;
    }
};
