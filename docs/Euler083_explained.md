# Euler083 — Path sum: four ways

Find the minimal path sum from the top-left to the bottom-right of a matrix, moving up, down, left, and right.

## Approach

- Model as a graph: each cell is a node with weighted edges to neighbors.
- Run Dijkstra from (0,0) using a min-heap; relax neighbors with cost + cellWeight.
- Stop when reaching target; return final distance.

## Edge Cases
- Early exit: Ensure termination when target extracted; continuing wastes time.
- Negative weights: Dijkstra requires non-negative; assume matrix non-negative; otherwise need Bellman-Ford.
- Heap duplicates: Multiple entries per node appear; skip outdated ones by comparing stored distance.
- Integer overflow: Use long accumulator if cell values large to avoid wrap-around.
- File parsing: Malformed lines cause exceptions; add validation.

## Complexity
- O(V log V + E) ≈ O(n·m log(n·m)).

## Practical examples and business impact
- Pathfinding: navigation meshes with uniform 4-way adjacency.
- Network latency: minimal cumulative cost across a grid of routers.
- Robotics: weighted occupancy grids for cost-optimal traversal.

## Key Takeaways
- Treat grid as graph; Dijkstra solves arbitrary positive weights efficiently.

## Java implementation (Euler083.java)
- Loads `p083_matrix.txt` if present, else uses the 5×5 sample matrix.
- Flattens the n×n grid into N = n² nodes; uses `dist[N]` with `Long.MAX_VALUE/4` init and a min-heap priority queue of pairs `[node, distance]`.
- Starts at node 0 with distance `a[0][0]`; for each pop, relax up to four neighbors by adding neighbor cell weight.
- Early exit: breaks when target node (N−1) is extracted with final distance.
- Prints `dist[N−1]`.
- Complexity: O(N log N + E) with E ≈ 4N; very fast for N=6400.
