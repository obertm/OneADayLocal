// Euler 019: Counting Sundays
public final class Euler019 {
    private static boolean isLeap(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    private static int daysInMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            case 4: case 6: case 9: case 11: return 30;
            case 2: return isLeap(year) ? 29 : 28;
            default: throw new IllegalArgumentException("month=" + month);
        }
    }

    public static int countSundaysOnFirst(int startYear, int endYear) {
        // 0=Sunday, 1=Monday, ... 6=Saturday
        int dow = 1; // 1900-01-01 is Monday
        int count = 0;
        for (int year = 1900; year <= endYear; year++) {
            for (int month = 1; month <= 12; month++) {
                if (year >= startYear && year <= endYear && dow == 0) count++;
                dow = (dow + daysInMonth(year, month)) % 7;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int start = 1901, end = 2000;
        if (args != null && args.length > 0) { try { start = Integer.parseInt(args[0]); } catch (Exception ignored) {} }
        if (args != null && args.length > 1) { try { end = Integer.parseInt(args[1]); } catch (Exception ignored) {} }
        System.out.println(countSundaysOnFirst(start, end));
    }
}
