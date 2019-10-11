#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> tm;
        for(int i = 0; i < nums.size(); ++i) {
            auto found = tm.find(nums[i]);
            if (found != tm.end()) {
                return {found->second, i};
            }
            tm.emplace(target - nums[i], i);
        }
        return {-1, -1};
    }
};
