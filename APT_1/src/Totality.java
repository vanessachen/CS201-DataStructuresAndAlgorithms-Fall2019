public class Totality {
    public int sum(int[] a, String stype) {
        // you add code here

        int e_total = 0;
        int o_total = 0;

        for (int k=0; k<a.length; k++) {
            if (k % 2 == 1) {
                o_total += a[k];
            }
            else if (k % 2 == 0) {
                e_total += a[k];
            }
        }
        if (stype.equals("even")) return e_total;
        else if (stype.equals("odd")) return o_total;
        return e_total+o_total;
    }
}

