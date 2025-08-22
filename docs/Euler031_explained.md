# Euler031 — Coin sums

## Problem statement

Count the number of ways to make a target amount using unlimited coins of given denominations (UK coins in the problem).

## Approach

Use a 1D dynamic programming array where `ways[s]` counts combinations to form sum `s`. Iterate coins as the outer loop so each unordered combination is added exactly once, then accumulate forward for each coin. This avoids permutation overcounting and keeps space linear in the target amount.

## Step-by-step reasoning

1) 1D DP for combinations
- Let `ways[s]` be the number of ways to make sum s. Initialize `ways[0] = 1`.
- For each coin c (outer loop), for s from c to target: `ways[s] += ways[s - c]`.
- Coin-outer ensures each combination is counted once (order-independent).

2) Complexity (see dedicated section below)

## Edge Cases

- Target = 0: Exactly one way (choose nothing); initialization with ways[0]=1 handles it.
- No coins / empty set: ways[target]=0 unless target=0.
- Duplicate denominations: Should be deduped or allowed; duplicates inflate counts incorrectly if not removed.
- Large target values: Use long for ways to avoid overflow; counts can exceed 32-bit for big targets.
- Negative or zero denomination: Reject; zero causes infinite loops, negative invalid.
- Order sensitivity: Ensure coin loop outer to avoid counting permutations.
- Memory: ways array of size target+1; for huge targets consider compression or modulo counts.

## Reusable template (for unbounded coin-change combinations)

- Initialize ways[0] = 1.
- For each coin c: for s=c..target: ways[s] += ways[s − c].
- Return ways[target].

## Practical examples and business impact

- Stochastic demand packing: simulate how many distinct pack/bundle compositions can fulfill an order value under uncertain demand (scenario enumeration for service levels).
- Inventory and logistics: enumerate container/carton combinations to hit a target weight/volume with unlimited counts per SKU; stress-test packing policies.
- Telecom/network capacity planning: compose bandwidth in denomination-like units (e.g., 10/40/100 Gbps ports) to reach target capacity; explore redundancy scenarios.
- Cloud cost modeling: combine VM/SKU sizes (denominations of vCPU/RAM) to reach a budget or capacity target; evaluate elasticity policies.
- Retail promotions: count ways a shopper can reach a threshold (e.g., “spend $50”) using unlimited offers; simulate redemption patterns.
- Manufacturing kitting: ways to assemble kits from standard sub-packs to achieve required component counts; analyze wastage versus flexibility.
- Cash management simulations: model how many change-making combinations a kiosk can produce for target payouts given unlimited coin types; plan float levels.
- Energy portfolios: combine generation blocks (e.g., 5/10/50 MW tranches) to hit dispatch targets; analyze combinatorial curtailment options.
- Transportation: ways to load seats/cargo using blocks (e.g., seat groups) to hit capacity targets; test boarding or loading policies.
- Financial settlement: decompose a payout into instrument lots (bonds/equities in board lots) to match target notional; evaluate settlement friction.

## Complexity

Time: O(target × #coins). Space: O(target) for the DP array.

## Key Takeaways

- Use coin-outer loops to avoid permutation overcounting; 1D DP is sufficient and fast.

## Java implementation (Euler031.java)

- Entry: default target 200 (i.e., £2); overridable via CLI.
- DP: `long[] ways = new long[target + 1]; ways[0] = 1;`
- Coins: iterate `{1,2,5,10,20,50,100,200}` and perform the inner accumulation loop.
- Output: print `ways[target]`.
