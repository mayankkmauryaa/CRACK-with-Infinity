Sample 3 : Hard
You are given a tree with n nodes rooted at node 1. You are also
given an array color representing the colour of each node in the
tree.
A set of nodes is beautiful if it satisfies the following conditions:
• All nodes in the set have different colors.
• For any pair of nodes (u, v), either u is the ancestor of v or v is
the ancestor of u within the tree.
You're given q queries where each query provides an
integer s representing a node in the tree.
The answer to each query is the maximum size of a beautiful
set that can be formed by selecting nodes from the subtree
rooted at node s.
Find the sum of answers to all queries. Since answer can be
large, return it modulo 109
+7.
Notes:
• The parent of node 1 is 0.
Input Format
• The first line contains an integer, N, denoting the number of
operations.
• The next line contains an integer, X.
• The next line contains an integer,Y.
• The next line contains an integer, Z.
• Each line i of the N subsequent lines (where 1 ≤ i ≤ N)
contains an integer describing A[i].
• Each line i of the N subsequent lines (where 1 ≤ i ≤ N)
contains an integer describing B[i].
Constraints
• 1 <= 𝑁 <= 10#
• 1 <= 𝑿 <= 10#
• 1 <= 𝒀 <= 10#
• 1 <= 𝒁 <= 10#
• 1 <= 𝑨[𝒊] <= 10$
• 1 <= 𝑩[𝒊] <= 10"
Sample Input-1:
5
0
1
2
1
3
4
3
4
3
5
3
4
3
3
Sample output-1:
5
Sample Explanation - 1:
Here, n = 5
p = [0, 1, 2, 1, 3]
color = [4, 3, 4, 3, 5]
q = 3
queries = [4, 3, 3]
for query 1:
s = 4, means we need to select beautiful set of maximum size
in the subtree of node 4.
we can select nodes {4} to form beautiful set of maximum size.
so, answer for this query is 1.
for query 2:
s = 3, means we need to select beautiful set of maximum size in
the subtree of 3.
we can select nodes {3, 5} to form beautiful set of maximum
size.
so, answer for this query is 2.
for query 3:
s = 3, means we need to select beautiful set of maximum size in
the subtree of 3.
we can select nodes {3, 5} to form beautiful set of maximum
size.
so, answer for this query is 2.
Hence, answer is 1 + 2 + 2 = 5.
Sample input-2:
5
0
1
1
2
2
1
5
4
5
2
3
5
4
3
Sample output-2:
3
Sample Explanation - 2:
Here, n = 5
p = [0, 1, 1, 2, 2]
color = [1, 5, 4, 5, 2]
q = 3
queries = [5, 4, 3]
for query 1:
s = 5, means we need to select beautiful set of maximum
size in the subtree of node 5.
we can select nodes {5} to form beautiful set of maximum
size.
so, answer for this query is 1.
for query 2:
s = 4, means we need to select beautiful set of maximum
size in the subtree of node 4.
we can select nodes {4} to form beautiful set of maximum
size.
so, answer for this query is 1.
for query 3:
s = 3, means we need to select beautiful set of maximum
size in the subtree of node 3.
we can select nodes {3} to form beautiful set of maximum
size.
so, answer for this query is 1.
Hence, answer is 1 + 1 + 1 = 3.
Sample Input-3:
5
0
1
1
1
3
5
5
5
1
5
4
2
4
5
1
Sample output-3:
5
Sample Explanation - 3:
Here, n = 5
p = [0, 1, 1, 1, 3]
color = [5, 5, 5, 1, 5]
q = 4
queries = [2, 4, 5, 1]
for query 1:
s = 2, means we need to select beautiful set of maximum size
in the subtree of node 2.
we can select nodes {2} to form beautiful set of maximum size.
so, answer for this query is 1.
for query 2:
s = 4, means we need to select beautiful set of maximum size in
the subtree of 4.
we can select nodes {4} to form beautiful set of maximum size.
so, answer for this query is 1.
for query 3:
s = 5, means we need to select beautiful set of maximum size in
the subtree of 5.
we can select nodes {5} to form beautiful set of maximum size.
so, answer for this query is 1.
for query 4:
s = 1, means we need to select beautiful set of maximum size
in the subtree of 1.
we can select nodes {1, 4} to form beautiful set of maximum size.
so, answer for this query is 2.
Hence, answer is 1 + 1 + 1 + 2 = 5.
For more information, contact askus@infosys.com
© 2024 Infosys Limited, Bengaluru, India. All Rights Reserved. Infosys believes the information in this document is accurate as of its publication date; such information is subject to change without notice. Infosys
acknowledges the proprietary rights of other companies to the trademarks, product names and such other intellectual property rights mentioned in this document. Except as expressly permitted, neither this
documentation nor any part of it may be reproduced, stored in a retrieval system, or transmitted in any form or by any means, electronic, mechanical, printing, photocopying, recording or otherwise, without the
prior permission of Infosys Limited and/ or any named intellectual property rights holders under this document.
Infosys.com | NYSE: INFY Stay Connected
