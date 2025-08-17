// Euler 054: Poker hands
// Given a 1000-hand poker dataset, how many hands does Player 1 win?
// https://projecteuler.net/problem=54
public final class Euler054 {
    public static void main(String[] args) {
        try {
            java.nio.file.Path path = null;
            if (args != null && args.length > 0) {
                path = java.nio.file.Path.of(args[0]);
            } else {
                java.nio.file.Path p1 = java.nio.file.Path.of("poker.txt");
                java.nio.file.Path p2 = java.nio.file.Path.of("0054_poker.txt");
                if (java.nio.file.Files.exists(p1)) path = p1; else if (java.nio.file.Files.exists(p2)) path = p2;
            }
            if (path == null || !java.nio.file.Files.exists(path)) { System.out.println("DATA_FILE_NOT_FOUND"); return; }
            int wins = 0;
            try (java.io.BufferedReader br = java.nio.file.Files.newBufferedReader(path)) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;
                    String[] tok = line.split("\\s+");
                    if (tok.length < 10) continue;
                    int[] h1 = parseHand(tok, 0);
                    int[] h2 = parseHand(tok, 5);
                    long r1 = rankHand(h1);
                    long r2 = rankHand(h2);
                    if (Long.compare(r1, r2) > 0) wins++;
                }
            }
            System.out.println(wins);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Parse 5 cards starting at offset into ranks and suits arrays
    private static int[] parseHand(String[] tok, int off) {
        int[] ranks = new int[5];
        int[] suits = new int[5];
        for (int i = 0; i < 5; i++) {
            String c = tok[off + i];
            ranks[i] = parseRank(c.charAt(0));
            suits[i] = parseSuit(c.charAt(1));
        }
        // pack into 10 ints: ranks[0..4], suits[0..4]
        int[] hand = new int[10];
        System.arraycopy(ranks, 0, hand, 0, 5);
        System.arraycopy(suits, 0, hand, 5, 5);
        return hand;
    }

    private static int parseRank(char r) {
        switch (r) {
            case '2': return 2; case '3': return 3; case '4': return 4; case '5': return 5; case '6': return 6;
            case '7': return 7; case '8': return 8; case '9': return 9; case 'T': return 10; case 'J': return 11;
            case 'Q': return 12; case 'K': return 13; case 'A': return 14;
        }
        return 0;
    }
    private static int parseSuit(char s) { return (s=='C')?0:(s=='D')?1:(s=='H')?2:3; }

    // Return a 64-bit comparable rank: high bits category, then tie-breaker components descending
    private static long rankHand(int[] hand) {
        int[] r = new int[5];
        int[] s = new int[5];
        System.arraycopy(hand, 0, r, 0, 5);
        System.arraycopy(hand, 5, s, 0, 5);
        java.util.Arrays.sort(r);
        // counts by rank
        int[] cnt = new int[15];
        for (int v : r) cnt[v]++;
        boolean flush = (s[0]==s[1] && s[1]==s[2] && s[2]==s[3] && s[3]==s[4]);
        boolean straight = isStraight(r);
        int highStraight = straightHigh(r);

        // Build list of (count, rank) pairs to sort desc by count then rank
        java.util.ArrayList<int[]> pairs = new java.util.ArrayList<>();
        for (int val = 14; val >= 2; val--) if (cnt[val] > 0) pairs.add(new int[]{cnt[val], val});
        pairs.sort((a,b) -> a[0]!=b[0]? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1]));

        int category;
        int[] tiebreak;
        if (straight && flush) {
            category = 8; // straight flush
            tiebreak = new int[]{highStraight};
        } else if (pairs.get(0)[0] == 4) {
            category = 7; // four of a kind
            int four = pairs.get(0)[1];
            int kicker = pairs.get(1)[1];
            tiebreak = new int[]{four, kicker};
        } else if (pairs.get(0)[0] == 3 && pairs.size() > 1 && pairs.get(1)[0] == 2) {
            category = 6; // full house
            tiebreak = new int[]{pairs.get(0)[1], pairs.get(1)[1]};
        } else if (flush) {
            category = 5; // flush
            tiebreak = sortedRanksDesc(r);
        } else if (straight) {
            category = 4; // straight
            tiebreak = new int[]{highStraight};
        } else if (pairs.get(0)[0] == 3) {
            category = 3; // three of a kind
            int three = pairs.get(0)[1];
            int[] kick = kickersExcluding(r, three, -1);
            tiebreak = new int[]{three, kick[0], kick[1]};
        } else if (pairs.get(0)[0] == 2 && pairs.size() > 1 && pairs.get(1)[0] == 2) {
            category = 2; // two pairs
            int highPair = Math.max(pairs.get(0)[1], pairs.get(1)[1]);
            int lowPair = Math.min(pairs.get(0)[1], pairs.get(1)[1]);
            int[] kick = kickersExcluding(r, highPair, lowPair);
            tiebreak = new int[]{highPair, lowPair, kick[0]};
        } else if (pairs.get(0)[0] == 2) {
            category = 1; // one pair
            int pair = pairs.get(0)[1];
            int[] kick = kickersExcluding(r, pair, -1);
            tiebreak = new int[]{pair, kick[0], kick[1], kick[2]};
        } else {
            category = 0; // high card
            tiebreak = sortedRanksDesc(r);
        }
        long key = ((long)category) << 56;
        int shift = 56;
        for (int v : tiebreak) {
            shift -= 4;
            key |= ((long)(v & 15)) << shift;
        }
        return key;
    }

    private static boolean isStraight(int[] r) {
        // handle A2345 straight with Ace low
        // r sorted ascending
        if (r[0]==2 && r[1]==3 && r[2]==4 && r[3]==5 && r[4]==14) return true;
        for (int i=1;i<5;i++) if (r[i] != r[0] + i) return false; return true;
    }
    private static int straightHigh(int[] r) {
        if (r[0]==2 && r[1]==3 && r[2]==4 && r[3]==5 && r[4]==14) return 5; // 5-high straight
        return r[4];
    }
    private static int[] sortedRanksDesc(int[] r) {
        int[] d = r.clone();
        // adjust for A2345 so that A counts as 1 in ranking
        if (d[0]==2 && d[1]==3 && d[2]==4 && d[3]==5 && d[4]==14) d[4] = 1;
        java.util.Arrays.sort(d);
        int[] out = new int[5];
        for (int i=0;i<5;i++) out[i] = d[4-i];
        return out;
    }
    private static int[] kickersExcluding(int[] r, int ex1, int ex2) {
        int[] tmp = new int[5]; int k=0; for (int v : r) if (v!=ex1 && v!=ex2) tmp[k++]=v;
        int[] d = new int[k]; System.arraycopy(tmp, 0, d, 0, k); java.util.Arrays.sort(d);
        int[] out = new int[k]; for (int i=0;i<k;i++) out[i]=d[k-1-i]; return out;
    }
}
