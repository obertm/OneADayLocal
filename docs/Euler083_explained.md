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
