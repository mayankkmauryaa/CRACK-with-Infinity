# [2073. Time Needed to Buy Tickets](https://leetcode.com/problems/time-needed-to-buy-tickets/description/)

There are <code>n</code> people in a line queuing to buy tickets, where the <code>0^th</code> person is at the **front** of the line and the <code>(n - 1)^th</code> person is at the **back** of the line.

You are given a **0-indexed** integer array <code>tickets</code> of length <code>n</code> where the number of tickets that the <code>i^th</code> person would like to buy is <code>tickets[i]</code>.

Each person takes **exactly 1 second** to buy a ticket. A person can only buy **1 ticket at a time** and has to go back to **the end** of the line (which happens **instantaneously** ) in order to buy more tickets. If a person does not have any tickets left to buy, the person will **leave ** the line.

Return the **time taken** for the person **initially** at position **k** \*\* \*\* (0-indexed) to finish buying tickets.

**Example 1:**

<div class="example-block">
Input: tickets = [2,3,2], k = 2

Output: 6

Explanation:

- The queue starts as [2,3,2], where the kth person is underlined.
- After the person at the front has bought a ticket, the queue becomes [3,2,1] at 1 second.
- Continuing this process, the queue becomes [2,1,2] at 2 seconds.
- Continuing this process, the queue becomes [1,2,1] at 3 seconds.
- Continuing this process, the queue becomes [2,1] at 4 seconds. Note: the person at the front left the queue.
- Continuing this process, the queue becomes [1,1] at 5 seconds.
- Continuing this process, the queue becomes [1] at 6 seconds. The kth person has bought all their tickets, so return 6.

**Example 2:**

<div class="example-block">
Input: tickets = [5,1,1,1], k = 0

Output: 8

Explanation:

- The queue starts as [5,1,1,1], where the kth person is underlined.
- After the person at the front has bought a ticket, the queue becomes [1,1,1,4] at 1 second.
- Continuing this process for 3 seconds, the queue becomes [4] at 4 seconds.
- Continuing this process for 4 seconds, the queue becomes [] at 8 seconds. The kth person has bought all their tickets, so return 8.

**Constraints:**

- <code>n == tickets.length</code>
- <code>1 <= n <= 100</code>
- <code>1 <= tickets[i] <= 100</code>
- <code>0 <= k < n</code>
