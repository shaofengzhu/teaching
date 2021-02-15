public class fibbo {
    public static void main(String[] args) {

        int result = f(4);

        System.out.println(result);
    }

    static int f(int x) {
        if (x == 0) {
            return 1;
        }

        if (x == 1) {
            return 2;
        }

        int fx_1 = f(x-1);
        int fx_2 = f(x -2);
        return fx_1 + fx_2;
    }
}

