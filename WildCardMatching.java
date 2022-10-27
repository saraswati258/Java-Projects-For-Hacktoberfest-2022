package DP;

public class WildCardMatching {

	public static void main(String[] args) {
		String src = "abcdef";
		String pat = "a?*********";
		System.out.println(WildCardMatchingRecursin(src, pat));
		System.out.println(WildCardMatchingRecursin(src, pat, 0, 0));
		System.out.println(WildCardMatchingTD(src, pat, 0, 0, new int[src.length()][pat.length()]));
		System.out.println(WildCardMatchingBU(src, pat));
	}

	public static boolean WildCardMatchingRecursin(String src, String pat) {
		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}
		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}
		if (src.length() == 0 && pat.length() != 0) {
			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		boolean ans;
		char chs = src.charAt(0);
		char chp = pat.charAt(0);
		String ros = src.substring(1);
		String rop = pat.substring(1);
		if (chs == chp || chp == '?') {
			ans = WildCardMatchingRecursin(ros, rop);
		} else if (chp == '*') {
			boolean blank = WildCardMatchingRecursin(src, rop);
			boolean multiple = WildCardMatchingRecursin(ros, pat);
			ans = blank || multiple;
		} else {
			ans = false;
		}
		return ans;
	}

	public static boolean WildCardMatchingRecursin(String src, String pat, int svidx, int pvidx) {
		if (src.length() == svidx && pat.length() == pvidx) {
			return true;
		}
		if (src.length() != svidx && pat.length() == pvidx) {
			return false;
		}
		if (src.length() == svidx && pat.length() != pvidx) {
			for (int i = pvidx; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		boolean ans;
		char chs = src.charAt(svidx);
		char chp = pat.charAt(pvidx);
		if (chs == chp || chp == '?') {
			ans = WildCardMatchingRecursin(src, pat, svidx + 1, pvidx + 1);
		} else if (chp == '*') {
			boolean blank = WildCardMatchingRecursin(src, pat, svidx, pvidx + 1);
			boolean multiple = WildCardMatchingRecursin(src, pat, svidx + 1, pvidx);
			ans = blank || multiple;
		} else {
			ans = false;
		}
		return ans;
	}

	// TD
	public static boolean WildCardMatchingTD(String src, String pat, int svidx, int pvidx, int[][] strg) {
		if (src.length() == svidx && pat.length() == pvidx) {
			return true;
		}
		if (src.length() != svidx && pat.length() == pvidx) {
			return false;
		}
		if (src.length() == svidx && pat.length() != pvidx) {
			for (int i = pvidx; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		if (strg[svidx][pvidx] != 0) {
			return strg[svidx][pvidx] == 1 ? true : false;
		}
		boolean ans;
		char chs = src.charAt(svidx);
		char chp = pat.charAt(pvidx);
		if (chs == chp || chp == '?') {
			ans = WildCardMatchingTD(src, pat, svidx + 1, pvidx + 1, strg);
		} else if (chp == '*') {
			boolean blank = WildCardMatchingTD(src, pat, svidx, pvidx + 1, strg);
			boolean multiple = WildCardMatchingTD(src, pat, svidx + 1, pvidx, strg);
			ans = blank || multiple;
		} else {
			ans = false;
		}
		strg[svidx][pvidx] = ans == true ? 1 : 2;
		return ans;
	}

	// BU
	public static boolean WildCardMatchingBU(String src, String pat) {
		boolean[][] strg = new boolean[src.length() + 1][pat.length() + 1];
		strg[src.length()][pat.length()] = true;

		for (int row = src.length(); row >= 0; row--) {
			for (int col = pat.length() - 1; col >= 0; col--) {
				if (row == src.length()) {
					if (pat.charAt(col) == '*') {
						strg[row][col] = strg[row][col + 1];
					} else {
						strg[row][col] = false;
					}
				} else {
					boolean ans;
					char chs = src.charAt(row);
					char chp = pat.charAt(col);
					if (chs == chp || chp == '?') {
						ans = strg[row + 1][col + 1];
					} else if (chp == '*') {
						boolean blank = strg[row + 1][col];
						boolean multiple = strg[row][col + 1];
						ans = blank || multiple;
					} else {
						ans = false;
					}
					strg[row][col] = ans;
				}
			}
		}
		return strg[0][0];
	}

}
