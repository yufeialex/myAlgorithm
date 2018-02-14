package chapter_4_recursionanddp;

public class GodenCoin {
    /**
     * F(n,w) = 0 (n<=1, w<p[0]);
     * F(n,w) = g[0] (n==1, w>=p[0]);
     * F(n,w) = F(n-1,w) (n>1, w<p[n-1])
     * F(n,w) = max(F(n-1,w), F(n-1,w-p[n-1])+g[n-1]) (n>1, w>=p[n-1])
     * 金矿N，工人W，金量G[]，用工量P[]
     */
    static int getMostGold(int n, int w, int[] g, int[] p) {
        int[] preResults = new int[w];
        int[] results = new int[w];

        //填充边界格子的值
        for (int i = 0; i < w; i++) {
            if (i + 1 < p[0]) {
                preResults[i] = 0;
            } else {
                preResults[i] = g[0];
            }
        }

        //填充其余格子的值，外层循环是金矿数量，内层循环是工人数
        for (int i = 1; i < n; i++) {
            for (int k = 1; k < preResults.length; k++) {
                System.out.print(preResults[k] + " ");
            }
            System.out.println();
            for (int j = 0; j < w; j++) {
                if (j + 1 < p[i]) {
                    results[j] = preResults[j];
                } else {
                    results[j] = Math.max(preResults[j], preResults[j + 1 - p[i]] + g[i]);
                }
            }
            preResults = results;
        }
        for (int k = 0; k < preResults.length; k++) {
            System.out.print(preResults[k] + " ");
        }
        System.out.println();
        return results[w - 1];
    }

    public static void main(String[] args) {
        int[] g = new int[]{400, 500, 200, 300, 350};
        int[] p = new int[]{5, 5, 3, 4, 3};
        System.out.println(getMostGold(5, 10, g, p));
    }
}
