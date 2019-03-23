public class Main {
    public static int[][] array = new int[8][8];//棋盘，放皇后
    public static int map = 0;//存储方案结果数量

    public static void main(String[] args) {
        System.out.println("Eight queens question:");
        findQueen(0);
        System.out.println("All:" + map);
    }

    private static void findQueen(int i) {//寻找皇后节点
        if (i > 7) {//八皇后的解
            map++;
            print();//打印八皇后的解
            return;
        }
        for (int m = 0; m < 8; m++) {//深度回溯，递归算法
            if (check(i, m)) {//检查皇后摆放位置是否合适
                array[i][m] = 1;
                findQueen(i + 1);//寻找下一层节点
                array[i][m] = 0;//清零，避免回溯时出现脏数据
            }
        }
    }

    private static boolean check(int k, int j) {//判断节点是否合适,第一个参数是行，第二个参数是列。
        for (int i = 0; i < 8; i++) {//检查列冲突。
            if (array[i][j] == 1 && i != k)
                return false;
        }
        for (int i = 0; i < 8; i++) {//检查行冲突。
            if (array[k][i] == 1 && i != j)
                return false;
        }
        for (int i = k - 1, m = j - 1; i >= 0 && m >= 0; i--, m--) {//检查左对角线上方。
            if (array[i][m] == 1) {
                return false;
            }
        }
        for (int i = k + 1, m = j + 1; i <= 7 && m <= 7; i++, m++) {//检查左对角线下方。
            if (array[i][m] == 1) {
                return false;
            }
        }
        for (int i = k - 1, m = j + 1; i >= 0 && m <= 7; i--, m++) {//检查右对角线上方。
            if (array[i][m] == 1) {
                return false;
            }
        }
        for (int i = k + 1, m = j - 1; i <= 7 && m >= 0; i++, m--) {//检查右对角线下方。
            if (array[i][m] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void print() {
        System.out.println("方案"+map+":");
        for(int i =0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(array[i][j]==1){
                    System.out.print("o ");
                }else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
