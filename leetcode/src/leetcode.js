/* eslint-disable */

export default {
  /**
   * 877. Stone Game
   *
   * @param {number[]} piles
   * @return {boolean}
   */
  stoneGame: function (piles) {
    const N = piles.length;
    // Make a (N+2) by (N+2) array, initialized with 0s.
    const dp = Array(N + 2).fill(0).map(() => Array(N + 2).fill(0));

    // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]]
    for (let size = 1; size <= N; ++size)
      for (let i = 0, j = size - 1; j < N; ++i, ++j) {
        let parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
        if (parity == 1)
          dp[i + 1][j + 1] = Math.max(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i + 1][j]);
        else
          dp[i + 1][j + 1] = Math.min(-piles[i] + dp[i + 2][j + 1], -piles[j] + dp[i + 1][j]);
      }

    return dp[1][N] > 0;
  },

  /**
   * 746. Min Cost Climbing Stairs
   *
   * @param {number[]} cost
   * @return {number}
   */
  minCostClimbingStairs: function (cost) {
    let minCostClimbingStairs = function (cost) {
      // d[i]는 i까지 가는데 최소 합
      let d = new Array(cost.length);

      d[0] = 0;
      d[1] = 0;


      for (let i = 2; i <= cost.length; i++) {
        d[i] = Math.max(d[i - 1] + cost[i], d[i - 2] + cost[i])
      }

      return d[n]

    };
  },

  /**
   * 70. Climbing Stairs
   *
   * @param {number} n
   * @return {number}
   */
  climbStairs: function (n) {
    let d = [];
    d[0] = 0;
    d[1] = 1;
    d[2] = 2;

    if (n <= 2) {
      return d[n];
    }

    for (let i = 3; i <= n; i++) {
      d[i] = d[i - 1] + d[i - 2]
    }

    return d[n];
  },

  /**
   * 53. Maximum Subarray
   *
   * @param {number[]} nums
   * @return {number}
   */
  maximumSubArray: function (nums) {

    let d = []
    d[0] = 0;
    d[1] = nums[0];

    let sub = []
    sub[0] = 0;
    sub[1] = nums[0];

    if (nums.length <= 1) {
      d[nums.length];
    }

    for (let i = 1; i < nums.length; i++) {
      sub[i + 1] = Math.max(nums[i], nums[i] + sub[i])
      d[i + 1] = Math.max(d[i], sub[i + 1])
    }

    return d[nums.length]
  },

  /**
   * 198. House Robber
   *
   * @param {number[]} nums
   * @return {number}
   */
  houseRobber: function (nums) {
    if (nums.length === 1) {
      return nums[0]
    }

    if (nums.length === 2) {
      return Math.max(nums[0], nums[1]);
    }
    let d = [];
    d[0] = 0;
    d[1] = nums[0];
    d[2] = Math.max(nums[0], nums[1]);

    for (let i = 2; i < nums.length; i++) {
      d[i + 1] = Math.max(d[i], d[i - 1] + nums[i]);

    }

    return d[nums.length];
  },

  /**
   * 303. Range Sum Query - Immutable
   *
   * @param nums
   * @constructor
   */
  rangeSumQuery: function (nums) {
    NumArray = function (nums) {

      this.d = [];
      this.d[0] = nums[0];

      for (let i = 1; i < nums.length; i++) {
        this.d[i] = this.d[i - 1] + nums[i];
      }
    };

    /**
     * @param {number} i
     * @param {number} j
     * @return {number}
     */
    NumArray.prototype.sumRange = function (i, j) {
      if (i <= 0) {
        return this.d[j];
      }
      return this.d[j] - this.d[i - 1];
    };
  },

  /**
   * 338. Counting Bits
   *
   * @param {number} num
   * @return {number[]}
   */
  countBits: function (num) {

    let result = [];

    result[0] = 0;
    let beforeTwoMultiple = 0;
    let nextTwoMultiple = 1;

    for (let i = 1; i <= num; i++) {
      if (i == nextTwoMultiple) {
        result[i] = 1;
        beforeTwoMultiple = nextTwoMultiple;
        nextTwoMultiple = nextTwoMultiple * 2;
        continue;
      }

      result[i] = 1 + result[i - beforeTwoMultiple]

    }

    return result
  },

  /**
   * 931. Minimum Falling Path Sum
   *
   * @param {number[][]} A
   * @return {number}
   */
  minFallingPathSum: function (A) {

    let d = []

    d.push(A[0]);
    for (let i = 1; i < A.length; i++) {
      d.push(new Array(A.length))
    }

    for (let i = 1; i < A.length; i++) {
      for (let j = 0; j < A.length; j++) {
        if (j - 1 < 0) {
          d[i][j] = Math.min(d[i - 1][j] + A[i][j], d[i - 1][j + 1] + A[i][j])
        } else if (j + 1 >= A.length) {
          d[i][j] = Math.min(d[i - 1][j - 1] + A[i][j], d[i - 1][j] + A[i][j])
        } else {
          d[i][j] = Math.min(d[i - 1][j - 1] + A[i][j], d[i - 1][j] + A[i][j], d[i - 1][j + 1] + A[i][j])
        }
      }
    }

    let min = d[A.length - 1].reduce(function (previous, current) {
      return previous > current ? current : previous;
    });

    return min
  },

  /**
   * 714. Best Time to Buy and Sell Stock with Transaction Fee
   *
   * @param {number[]} prices
   * @param {number} fee
   * @return {number}
   * hint: 사고나면 팔고난건 신경쓰지 않아도 된다.
   */
  maxProfit: function (prices, fee) {
    const d = [];
    const profit = Array.from(Array(prices.length), () => new Array(prices.length))

    for (let i = 0; i < prices.length; i++) {
      let maxDiffValue = 0;
      for (let j = i; j < prices.length; j++) {
        if (i === j) {
          profit[i][j] = 0 - fee;
        }

        if (prices[j] - prices[i] - fee > maxDiffValue) {
          maxDiffValue = prices[j] - prices[i] - fee;
        }
        profit[i][j] = prices[j] - prices[i] - fee;
      }

    }

    console.log(profit);
    for (let i = 0; i < profit.length; i++) {
      let maxDiffValue = 0;
      let maxIndex = i;
      for (let j = i + 1; j < profit[i].length; j++) {
        // console.log('---')
        maxDiffValue = profit[i][j];
        console.log(i, j, maxIndex)
        console.log(profit[i][maxIndex] + profit[maxIndex + 1][j])
        console.log(profit[i][j])


        console.log(maxDiffValue)
      }
      d[i] = maxDiffValue;
    }
    console.log(Math.max(...d));
    return Math.max(...d);
  },

  /**
   * 343. Integer Break
   *
   * @param {number} n
   * @return {number}
   */
  integerBreak: function (n) {
    let d = [];

    d[1] = 1
    d[2] = 1;
    d[3] = 2;
    d[4] = 4;

    for (i = 5; i <= n; i++) {
      d[i] = findMax(i, d);
    }

    return d[n];

    function findMax(num, d) {
      let max = 0;

      for (let i = 1; i <= (num / 2); i++) {
        max = Math.max(max, Math.max(d[i], i) * Math.max(d[num - i], num - i));
      }

      return max;
    }
  },

  /**
   * 677. Map Sum Pairs
   *
   */
  mapSumPairs: function () {
    let MapSum = function () {
      this.map = {}
    };

    /**
     * @param {string} key
     * @param {number} val
     * @return {void}
     */
    MapSum.prototype.insert = function (key, val) {
      this.map[key] = val;
    };

    /**
     * @param {string} prefix
     * @return {number}
     */
    MapSum.prototype.sum = function (prefix) {
      let sum = 0;
      Object.keys(this.map).forEach(item => {
        if (item.startsWith(prefix)) {
          sum += this.map[item]
        }
      });

      return sum;
    };
  },

  /**
   * Definition for a binary tree node.
   * function TreeNode(val) {
   *     this.val = val;
   *     this.left = this.right = null;
   * }
   */
  /**
   * 98. Validate Binary Search Tree
   *
   * @param {TreeNode} ro
   * ot
   * @return {boolean}
   */
  isValidBST: function (root) {
    console.log(root)
    let result;

    if (!root.left) {
      if (root.left.val < root.val)
        result = isValidBST(root.left);
      else
        result = false;
    } else if (!root.right) {
      if (root.val < root.right.val)
        result = isValidBST(root.right);
      else
        result = false;
    } else {
      result = true
    }
  },

  /**
   * 2019.04.10
   * 78. Subsets
   *
   * @param {number[]} nums
   * @return {number[][]}
   */
  subsets: function (nums) {
    let result = [];

    result.push([]);

    for (let i = 0; i < nums.length; i++) {
      let addLength = result.length;
      for (let j = 0; j < addLength; j++) {
        result.push([...result[j], nums[i]])
      }
    }

    return result;
  },

  /**
   * 2019.04.17 ~ 2019.05.08
   * 309. Best Time to Buy and Sell Stock with Cooldown
   *
   * @param {number[]} prices
   * @return {number}
   */
  maxProfit: function (prices) {

    if (prices.length <= 1) {
      return 0;
    }

    let d = [];
    let profit = [[]]

    for (let i = 1; i < prices.length; i++) {
      let maxTemp = prices[i] - prices[i - 1];
      for (let j = i + 1; j < prices.length; j++) {
        if (maxTemp < prices[j] - prices[i - 1]) {
          maxTemp = prices[j] - prices[i - 1];
        }
      }
    }
  },

  /**
   * 114. Flatten Binary Tree to Linked List
   *
   * Definition for a binary tree node.
   * function TreeNode(val) {
   *     this.val = val;
   *     this.left = this.right = null;
   * }
   */
  /**
   * @param {TreeNode} root
   * @return {void} Do not return anything, modify root in-place instead.
   */
  flatten: function (root) {
    process(root, root.left, root.right);

    function process(parent, left, right) {

    }
  },

  /**
   * 73. Set Matrix Zeroes
   *
   * @param {number[][]} matrix
   * @return {void} Do not return anything, modify matrix in-place instead.
   */
  setZeroes: function (matrix) {
    let changRow = new Set();
    let changCol = new Set();

    for (let i = 0; i < matrix.length; i++) {
      for (let j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          changRow.add(i)
          changCol.add(j)
        }
      }
    }

    for (let i = 0; i < matrix.length; i++) {
      for (let j = 0; j < matrix[i].length; j++) {
        if (changRow.has(i) || changCol.has(j)) {
          matrix[i][j] = 0
        }
      }
    }

    return matrix;
  },

  /**
   * 131. Palindrome Partitioning
   *
   * @param {string} s
   * @return {string[][]}
   */
  partition: function (s) {

    let result = []
    sArray = s.split('')
    result.push(sArray)

    palindromDp = Array.from(Array(sArray.length), () => new Array(sArray.length))

    for (let i = 0; i < sArray.length; i++) {
      for (let j = 0; j < sArray.length; j++) {
        palindromDp[i][j] = checkPalindrome(sArray.slice(i, j + 1));
      }
    }


    for (let i = 0; i < sArray.length; i++) {
      for (let j = i + 1; j < sArray.length; j++) {
        console.log("i:", i, "j:", j)
        if (palindromDp[i][j]) {
          result.push([...sArray.slice(0, i), sArray.slice(i, j + 1).join(''), ...sArray.slice(j + 1)])

          for (let k = j + 1; k < sArray.length; k++) {
            if (palindromDp[j + 1][k]) {
              result.push([...sArray.slice(0, i), sArray.slice(i, j + 1).join(''), ...sArray.slice(j + 1)])
            }
          }
        }
        console.log(result)
      }
    }

    return result;

    function checkPalindrome(sArray) {

      if (sArray.length == 1) {
        return true;
      }

      if (sArray.length == 2 && sArray[0] == sArray[1]) {
        return true;
      }

      let checkPalindrome = true;
      for (i = 0; i < sArray.length / 2.0; i++) {
        if (sArray[i] != sArray[sArray.length - 1 - i]) {
          checkPalindrome = false;
          break;
        }
      }

      return checkPalindrome;
    }
  },

  /**
   * 721. Accounts Merge
   *
   * @param {string[][]} accounts
   * @return {string[][]}
   */
  accountsMerge: function (accounts) {

    for (let i = 0; i < accounts.length; i++) {
      if (accounts[i] == null) {
        continue;
      }

      let prevEmailList = accounts[i].slice(1);
      let prevName = accounts[i][0];

      for (let j = i + 1; j < accounts.length; j++) {
        if (accounts[j] == null) {
          continue;
        }

        let isSame = false;
        let currEmailList = accounts[j].slice(1);

        if (prevName == accounts[j][0]) {
          for (let k = 0; k < currEmailList.length; k++) {
            if (prevEmailList.indexOf(currEmailList[k]) != -1) {
              isSame = true;
              break;
            }
          }

          if (isSame) {

            accounts[i] = [accounts[i][0], ...Array.from(new Set(accounts[i].slice(1).concat(accounts[j].slice(1))))]
            accounts[i].sort()

            accounts[j] = undefined;
          }
        }
      }
    }

    accounts = accounts.filter(a => a)
    accounts.forEach(account => {
      if (Array.isArray(account)) account.sort()
    })
    accounts = accounts.map(account => Array.from(new Set(account)))

    return accounts
  },

  /**
   * 39. Combination Sum
   *
   * @param {number[]} candidates
   * @param {number} target
   * @return {number[][]}
   */
  combinationSum: function (candidates, target) {
    let combinationSumSet = []
    let combinationSum = []

    for (i = 0; i < candidates.length; i++) {
      combination(candidates[i], candidates.slice(i), target, [], [])
    }

    return combinationSumSet;

    function combination(candidate, candidates, target, combinationSum, combinationSumSet) {


      console.log('set:' + combinationSumSet, 'sum:' + combinationSum, 'target:' + target)


      if (target == 0) {
        combinationSumSet.push(combinationSum)
        return;
      }

      target = target - candidate;

      if (target > 0) {

        startPoint = candidates.indexOf(candidate)
        combinationSum.push(candidate);


        combination(candidate, candidates.indexOf(candidate), target, combinationSum, combinationSumSet)


      }
    }
  },

  /**
   * 334. Increasing Triplet Subsequence
   *
   * @param {number[]} nums
   * @return {boolean}
   */
  increasingTriplet: function (nums) {
    let a, b;

    if (nums[0] < nums[1]) {
      a = nums[0]
      b = nums[1]
    }

    if (nums[0] >= nums[1]) {
      a = nums[1]
    }

    for (let i = 2; i < nums.length; i++) {
      if (b != null) {
        if (nums[i] > b) {
          return true
        } else if (a < nums[i] && nums[i] < b) {
          b = nums[i]
        } else if (nums[i] < a) {
          a = nums[i]
        }
      } else {
        if (nums[i] > a) {
          b = nums[i]
        } else if (nums[i] < a) {
          a = nums[i]
        }
      }
    }

    return false
  },

  /**
   * 442. Find All Duplicates in an Array
   *
   * @param nums
   * @returns {Array.<*>}
   */
  findDuplicates: function (nums) {
    let result = nums.reduce((acc, item, index) => {
      acc[item] = acc[item] ? acc[item] + 1 : 1
      return acc
    }, {})


    return Object.keys(result).filter(item => result[item] >= 2)

  },

  /**
   * 713. Subarray Product Less Than K
   *
   * @param {number[]} nums
   * @param {number} k
   * @return {number}
   */
  numSubarrayProductLessThanK: function (nums, k) {

    let count = 0;

    const d = []
    for (let i = 0; i < nums.length; i++) {
      let multipleResult = 1

      for (let j = i; j < nums.length; j++) {
        if (i !== 0 && d[i]) {
          j = d[i - 1]
          count = count + d[i - 1]
          continue;
        }

        if (i === j) {
          if (nums[j] >= k) {
            j = nums.length
            d[i] = j
          } else {
            count++
            multipleResult = multipleResult * nums[j]
          }
          continue;
          ;
        } else {

          if (multipleResult * nums[j] < k) {
            count++
            multipleResult = multipleResult * nums[j]
          } else {
            d[i] = j
            j = nums.length;
            continue;
          }
        }
      }
    }

    return count;
  },

  /**
   * 494. Target Sum
   *
   * @param {number[]} nums
   * @param {number} S
   * @return {number}
   */
  findTargetSumWays: function (nums, S) {
    let count = 0;
    if (nums.length < 1) {
      return;
    }

    find(nums, S, S)

    return count;

    function find(nums, changedS, S) {
      if (nums.length > 0) {

        let newSPlus = changedS - nums[0]
        let newSMinus = changedS + nums[0]

        if (nums.length === 1) {
          if (newSPlus === 0 && newSMinus === 0) {
            count = count + 2;
          } else if (newSMinus === 0 || newSPlus === 0) {
            count = count + 1;
          }
        }

        let newNums = nums.slice(1)

        find(newNums, newSPlus, S)
        find(newNums, newSMinus, S)

      } else {
        return;
      }
    }
  },


  /**
   *
   * 109. Convert Sorted List to Binary Search Tree
   * Definition for singly-linked list.
   * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
   */
  /**
   * Definition for a binary tree node.
   * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
   */
  /**
   * @param {ListNode} head
   * @return {TreeNode}
   */
  sortedListToBST: function (head) {
    let listArr = []
    listNodetoList(head, listArr)

    let result = []

    console.log(listArr)
    return makeBalanceBST(listArr, 0, listArr.length)

    function listNodetoList(listNode, arr) {
      if (listNode == null) {
        return;

      }

      arr.push(listNode.val)

      if (listNode.next == null) {
        return arr;
      }

      listNodetoList(listNode.next, arr)
    }

    function makeBalanceBST(listArr, start, end) {

      if (start >= end) {
        return null;
      }

      let mid = Math.floor((start + end) / 2);

      let treeNode = new TreeNode(listArr[mid])

      // left
      treeNode.left = makeBalanceBST(listArr, start, mid)
      // right
      treeNode.right = makeBalanceBST(listArr, mid + 1, end)

      return treeNode;
    }
  },


  /**
   * 173. Binary Search Tree Iterator
   *
   * @constructor
   */
  BinarySearchTreeBSTIterator: function () {
    /**
     * Definition for a binary tree node.
     * function TreeNode(val) {
     *     this.val = val;
     *     this.left = this.right = null;
     * }
     */
    /**
     * @param {TreeNode} root
     */
    let BSTIterator = function (root) {

    };

    /**
     * @return the next smallest number
     * @return {number}
     */
    BSTIterator.prototype.next = function () {
      console.log(root)
    };

    /**
     * @return whether we have a next smallest number
     * @return {boolean}
     */
    BSTIterator.prototype.hasNext = function () {

    };

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * var obj = new BSTIterator(root)
     * var param_1 = obj.next()
     * var param_2 = obj.hasNext()
     */
  },

  /**
   * 310. Minimum Height Trees
   * @param {number} n
   * @param {number[][]} edges
   * @return {number[]}
   */
  findMinHeightTrees: function (n, edges) {

  },

  /**
   * 2019.10.16
   * 337. House Robber III
   * Definition for a binary tree node.
   * function TreeNode(val) {
   *     this.val = val;
   *     this.left = this.right = null;
   * }
   */
  /**
   * @param {TreeNode} root
   * @return {number}
   */
  rob: function (root) {
    let a = root
    console.log(a.val)
  },

  /**
   * 2019.10.23
   * 706. Design HashMap
   *
   */
  DesignHashMap: function () {
    /**
     * Initialize your data structure here.
     */
    let MyHashMap = function () {
      this.hashmap = {}
    };

    /**
     * value will always be non-negative.
     * @param {number} key
     * @param {number} value
     * @return {void}
     */
    MyHashMap.prototype.put = function (key, value) {
      this.hashmap[key] = value
    };

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     * @param {number} key
     * @return {number}
     */
    MyHashMap.prototype.get = function (key) {
      return this.hashmap[key] !== undefined ? this.hashmap[key] : -1
    };

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     * @param {number} key
     * @return {void}
     */
    MyHashMap.prototype.remove = function (key) {
      delete this.hashmap[key]
    };

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * var obj = new MyHashMap()
     * obj.put(key,value)
     * var param_2 = obj.get(key)
     * obj.remove(key)
     */
  },

  /**
   * 2019.11.06
   * 322. Coin Change
   *
   * @param {number[]} coins
   * @param {number} amount
   * @return {number}
   */
  coinChange: function (coins, amount) {

  },
  /**
   *
   * 2019.11.13
   * 48. rotate matrix
   * @param {number[][]} matrix
   * @return {void} Do not return anything, modify matrix in-place instead.
   */
  rotate: function (matrix) {
    if (matrix.length == 1) {
      return matrix;
    }

    let n = matrix.length;

    if (let i = 0;
    i < n;
    i++
  )
    if (let j = 0;
    j < n;
    j++
  )
    {
      if (matrix[i][j] == null) {
        continue;
      }

      let getedValue = moveAndGet(matrix, i, j, n)


    }
  },

  /**
   *
   * 2019.11.20
   * 187. Repeated DNA Sequences
   * @param {string} s
   * @return {string[]}
   */
  findRepeatedDnaSequences: function (s) {
    let result = [];

    // return solution1(s, result)
    return solution2(s, result)

    function solution1(s, result) {
      for (let i = 0; i < s.length - 10; i++) {
        let tenletter = s.slice(i, i + 10);

        if (s.slice(i + 1).includes(tenletter) && !result.includes(tenletter)) {
          result.push(tenletter)
        }
      }

      return result
    }

    function solution2(s, result) {
      let countMap = {}

      for (let i = 0; i < s.length - 10 + 1; i++) {
        let tenletter = s.slice(i, i + 10);

        if (countMap[tenletter] && countMap[tenletter] >= 1) {
          countMap[tenletter] += 1
        } else {
          countMap[tenletter] = 1
        }

        if (countMap[tenletter] === 2) {
          result.push(tenletter)
        }
      }

      return result
    }
  },

  /**
   * 2020.01.08
   * 695. Max Area of Island
   * @param {number[][]} grid
   * @return {number}
   */
  maxAreaOfIsland: function (grid) {

    function find(grid, row, col, visited) {
      if (row < 0 || row >= visited.length || col < 0 || col >= visited[0].length) {
        return 0;
      }

      if (grid[row][col] == 0 || visited[row][col]) {
        return 0;
      }

      visited[row][col] = true;
      let area = 1;

      area += find(grid, row - 1, col, visited)
      area += find(grid, row + 1, col, visited)
      area += find(grid, row, col - 1, visited)
      area += find(grid, row, col + 1, visited)

      return area;

    }

    let maxAreaResult = 0;
    let visited = Array.from(Array(grid.length), () => new Array(grid[0].length));

    for (let i = 0; i < grid.length; i++) {
      for (let j = 0; j < grid[0].length; j++) {
        if (grid[i][j] === 1) {
          maxAreaResult = Math.max(maxAreaResult, find(grid, i, j, visited))
        }
      }
    }

    return maxAreaResult
  },
  /**
   * 2020.01.15
   * 565. Array Nesting
   * @param {number[]} nums
   * @return {number}
   */
  arrayNesting: function (nums) {

    function findLength(value, nums, visited) {

      if (visited[value]) {
        return 1;
      }

      visited[value] = true
      let length = 1;
      length += findLength(nums[value], nums, visited)

      return length;
    }

    let maxLength = 0;

    let visited = [];
    for (let i = 0; i < nums.length; i++) {
      visited[i] = true
      maxLength = Math.max(maxLength, findLength(nums[i], nums, visited))
    }

    return maxLength;

    // let sSet = new Set()
    // for (let i = 0; i < nums.length; i++) {
    //     while(!sSet.contains(nums[i])) {
    //         sSet.add(nums[i])
    //     }
    // }
  },
  /**
   * 2020.01.22
   * 402. Remove K Digits
   * @param {string} num
   * @param {number} k
   * @return {string}
   */
  removeKdigits: function (num, k) {
    function removeAndFindMinNum(num, k) {
      if (k == 0) {
        return num.toString();
      }

      let min = num;
      for (let i = 0; i < num.length; i++) {

        let temp;
        if (i == 0) {
          temp = num.slice(1)
        } else if (i == num.length - 1) {
          temp = num.slice(0, num.length - 1)
        } else {
          temp = num.slice(0, i) + num.slice(i + 1)
        }

        min = Math.min(parseInt(min), parseInt(temp))
      }

      min = removeAndFindMinNum(min.toString(), k - 1)

      return min
    }

    if (num.length <= k) {
      return "0"
    }

    return removeAndFindMinNum(num, k)
  },
  /**
   * 2020.01.29
   * 210. Course Schedule II
   * @param {number} numCourses
   * @param {number[][]} prerequisites
   * @return {number[]}
   */
  findOrder: function (numCourses, prerequisites) {

    function find(map, i, visited, result) {
      if (result.length == Object.keys(map).length) {
        return result;
      }

      visited[i] = true;
      result.push(i)

      for (let k = 0; k < Object.keys(map).length; k++) {
        if (i != k && !visited[k] && (map[k].length == 0 || (map[k].length > 0 && map[k].every(index => visited[index])))) {

          return find(map, k, visited, result)
        }
      }

      return result;
    }

    let map = {}

    for (let i = 0; i < numCourses; i++) {
      map[i] = []
    }

    for (let i = 0; i < prerequisites.length; i++) {
      let end = prerequisites[i][0];
      let start = prerequisites[i][1];

      map[end].push(start)
    }

    for (let i = 0; i < numCourses; i++) {
      let visited = new Array(numCourses).fill(false)
      let result = [];

      if (map[i].length == 0) {
        console.log(i)
        result = find(map, i, visited, result)
      }


      if (result.length === numCourses) {
        return result
      }

    }

    return [];
  },

  /**
   * 2020.02.05
   * 92. Reverse Linked List II
   * @param {ListNode} head
   * @param {number} m
   * @param {number} n
   * @return {ListNode}
   */
  reverseBetween: function (head, m, n) {
    function swap(head, m, n) {
      let node = head
      while ((m--) - 1 >= 0) {
        node = node.next
        console.log(m)
      }
      console.log(node)
      return;

    }


    while (m < n) {
      swap(head, m, n)
      n++
      m--
    }
    return
  },

  /**
   * 2020.02.12
   * 347. Top K Frequent Elements
   * @param {number[]} nums
   * @param {number} k
   * @return {number[]}
   */
  topKFrequent: function (nums, k) {
    let countMap = nums.reduce((acc, value) => {
      acc[value] = acc[value] + 1 || 1;
      return acc;
    }, {})

    let arr = Object.entries(countMap)

    arr.sort((a, b) => {
      return a[1] < b[1] ? 1 : -1;
    })

    return arr.slice(0, k).map((item, index) => item[0])
  },
  /**
   * 2020.02.19
   * 692. Top K Frequent Words
   * @param {string[]} words
   * @param {number} k
   * @return {string[]}
   */
  topKFrequent: function (nums, k) {
    let countMap = words.reduce((acc, word) => {
      acc[word] = acc[word] + 1 || 1;
      return acc;
    }, {})

    let arr = Object.entries(countMap)

    arr.sort((a, b) => {
      if (a[1] < b[1]) {
        return 1
      } else if (a[1] === b[1] && a[0] > b[0]) {
        return 1
      } else {
        return -1
      }
    })

    return arr.slice(0, k).map((item, index) => item[0])
  }
}
