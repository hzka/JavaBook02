import java.util.Scanner;

public class Main {
    static final int MAXNUM = 5;//图的最大顶点数
    static final int MAXVALUES = 65535;//最大值


    public static void main(String[] args) {
//        System.out.println("Hello World!");
        GraphMaterix gm = new GraphMaterix();
        creteGraph(gm);
        outGraph(gm);
        clearGraph(gm);
    }

    private static void clearGraph(GraphMaterix gm) {
        for (int i = 0; i < gm.VertexNum; i++) {
            for (int j = 0; j < gm.VertexNum; j++) {
                gm.EdgeWeight[i][j] = 0;
            }
        }
    }

    private static void outGraph(GraphMaterix gm) {
        for (int i = 0; i < gm.VertexNum; i++) {
            System.out.printf("\t%c", gm.vertex[i]);//第一行输出顶点信息
        }
        System.out.println();
        for (int i = 0; i < gm.VertexNum; i++) {
            System.out.printf("%c", gm.vertex[i]);
            for (int j = 0; j < gm.VertexNum; j++) {
                System.out.println(gm.EdgeWeight[i][j]);
            }
            System.out.println();
        }

    }

    private static void creteGraph(GraphMaterix gm) {
        int i, j, k;
        int weight;//权值
        char startV, endV;//起始、终止顶点
        System.out.println("输入顶点个数和边的个数:");
        Scanner input = new Scanner(System.in);
        gm.VertexNum = input.nextInt();
        gm.EdgeNum = input.nextInt();
        for (i = 0; i < gm.VertexNum; i++) {
            System.out.println("第" + (i + 1) + "个顶点");
            gm.vertex[i] = (input.next().toCharArray())[0];//保存到顶点数组中。
        }
        System.out.println("输入各边的顶点和权值");
        for (k = 0; k < gm.EdgeNum; k++) {
            System.out.println("第" + (k + 1) + "个顶点");
            System.out.println("边的起点为:");
            startV = input.next().charAt(0);
            System.out.println("边的终点为:");
            endV = input.next().charAt(0);
            System.out.println("边的权值为:");
            weight = input.nextInt();
            for (i = 0; gm.vertex[i] != startV; i++) ;//在顶点数组中寻找起点位置
            for (j = 0; gm.vertex[j] != endV; j++) ;//在顶点数组中寻找终点位置
            gm.EdgeWeight[i][j] = weight;
            if (gm.GType == 0) {
                gm.EdgeWeight[j][i] = weight;
            }
        }
    }


    public static class GraphMaterix {
        int GType;//图的类型（0是无向图，1是有向图）
        int VertexNum;//顶点的数量
        int EdgeNum;//边的数量
        char[] vertex = new char[MAXNUM];//保存顶点信息
        int[][] EdgeWeight = new int[MAXNUM][MAXNUM];//保存权值
    }
}
