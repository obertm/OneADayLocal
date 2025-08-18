# Euler067 — Maximum path sum II

Like Euler018 with a much larger triangle from a file; compute the maximum total from top to bottom.

## Approach

- Read rows into a list; apply bottom-up DP: row[i]=row[i]+max(child[i],child[i+1]) from the row below.
- Final answer is at the top.

## Complexity
- O(N) over all entries; memory O(width) if rolling.

## Real-world analogues and impact
- Scalable DP for large DAGs and decision trees stored in files.
  - Impact: Linear-time optimal aggregation over large inputs.

## Takeaways
- Same DP as Euler018; just read from file and process bottom-up.
