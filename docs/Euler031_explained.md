# Euler031 — Coin sums

## Problem statement

Count the number of ways to make a target amount using unlimited coins of given denominations (UK coins in the problem).

## Step-by-step reasoning

1) 1D DP for combinations
- Let `ways[s]` be the number of ways to make sum s. Initialize `ways[0] = 1`.
- For each coin c (outer loop), for s from c to target: `ways[s] += ways[s - c]`.
- Coin-outer ensures each combination is counted once (order-independent).

2) Complexity
- O(target × #coins) time, O(target) space.

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

## Key takeaways

- Use coin-outer loops to avoid permutation overcounting; 1D DP is sufficient and fast.

## Java implementation (Euler031.java)

- Entry: default target 200 (i.e., £2); overridable via CLI.
- DP: `long[] ways = new long[target + 1]; ways[0] = 1;`
- Coins: iterate `{1,2,5,10,20,50,100,200}` and perform the inner accumulation loop.
- Output: print `ways[target]`.
