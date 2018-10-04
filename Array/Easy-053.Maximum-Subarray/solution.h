#include <vector>
using namespace std;

class Solution {
public:
#define MAX(x, y) (x > y ? x : y)

    int maxSubArray(vector<int>& nums) {
        int res = INT_MIN, t1 = 0, t2 = 0, curMax = 0, curT = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (curMax > 0) {
                curMax += nums[i];
            } else {
                curMax = nums[i];
                curT = i;
            }
            if (res < curMax) {
                res = curMax;
                t1 = curT;
                t2 = i;
            }
        }
//        cout << "from " << t1 << " to " << t2 << endl;
        return res;
    }
};
