# Euler083 — Path sum: four ways

Find the minimal path sum from the top-left to the bottom-right of a matrix, moving up, down, left, and right.

## Approach

- Model as a graph: each cell is a node with weighted edges to neighbors.
- Run Dijkstra from (0,0) using a min-heap; relax neighbors with cost + cellWeight.
- Stop when reaching target; return final distance.

## Complexity
- O(V log V + E) ≈ O(n·m log(n·m)).

## Real-world impact
- Shortest path on grids (navigation, network costs) with arbitrary 4-direction moves.

## Java implementation (Euler083.java)
- Loads `p083_matrix.txt` if present, else uses the 5×5 sample matrix.
- Flattens the n×n grid into N = n² nodes; uses `dist[N]` with `Long.MAX_VALUE/4` init and a min-heap priority queue of pairs `[node, distance]`.
- Starts at node 0 with distance `a[0][0]`; for each pop, relax up to four neighbors by adding neighbor cell weight.
- Early exit: breaks when target node (N−1) is extracted with final distance.
- Prints `dist[N−1]`.
- Complexity: O(N log N + E) with E ≈ 4N; very fast for N=6400.
