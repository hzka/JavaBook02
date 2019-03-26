

public class Main {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];//顶点数组
    private int adjMat[][];//邻接矩阵
    private int nVerts = 0;//当前顶点总数
    private StackX theStack;
    private Queue theQueue;

    public static void main(String[] args) {
        Main theGraph = new Main();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);

        System.out.println("visits");

        System.out.print("bfs:");
        theGraph.bfs();
        System.out.print("dfs:");
        theGraph.dfs();
        System.out.println();
//        System.out.println("Hello World!");
    }

    public Main() {//构造图。
        vertexList = new Vertex[MAX_VERTS];//顶点数组

        adjMat = new int[MAX_VERTS][MAX_VERTS];//邻接矩阵
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {//邻接矩阵置零
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX();//初始化深度遍历所需的堆栈
        theQueue = new Queue();//初始化广度遍历所需的队列

    }

    private void addVertex(char a) {//添加顶点
        vertexList[nVerts++] = new Vertex(a);
    }

    private void addEdge(int start, int end) {//添加边
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    private void displayvertex(int v) {//打印v邻接的未访问的节点
        System.out.print(vertexList[v].label + " ");

    }

    private int getAdjUnvisitedVertex(int v) {//获取和v邻接的未访问的顶点。
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVistited == false) {//在同一行且尚未访问过该节点。
                return i;
            }
        }
        return -1;
    }

    private void dfs() {//深度优先搜索遍历
        vertexList[0].wasVistited = true;
        displayvertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVistited = true;
                displayvertex(v);
                theStack.push(v);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVistited = false;//重置，防止后面再次使用dfs。
        }
    }

    private void bfs() {//广度优先搜索遍历
        vertexList[0].wasVistited = true;
        displayvertex(0);
        theQueue.insert(0);
        int v2;
        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVistited = true;
                displayvertex(v2);
                theQueue.insert(v2);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVistited = false;//重置，防止后面再次使用dfs。
        }
    }


    public class Vertex {//图的相关定义
        public char label;//名字
        public boolean wasVistited;//是否被访问

        public Vertex(char label) {
            this.label = label;
            this.wasVistited = false;
        }
    }

    public static class StackX {//自定义栈
        private final int SIZE = 20;
        private int[] st;
        private int top;

        public StackX() {
            st = new int[SIZE];
            top = -1;
        }

        public void push(int j) {
            st[++top] = j;//先++再赋值。
        }

        public int pop() {
            if (top == 0) {
                top = -1;
                return -1;
            }
            return st[--top];
        }

        public int peek() {
            return st[top];
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }

    public class Queue {//自定义队列
        private final int SIZE = 20;
        private int[] queArray;
        private int front;//队头删除和访问
        private int rear;//队尾进行添加

        public Queue() {
            queArray = new int[SIZE];
            front = 0;
            rear = -1;
        }

        public void insert(int j) {//入队
            if (rear == SIZE - 1) {
                rear = -1;
            }
            queArray[++rear] = j;
        }

        public int remove() {//出队
            if (!isEmpty()) {
                return queArray[front++];
            } else {
                return -1;
            }
        }

        public boolean isEmpty() {
            return (rear + 1 == front);
        }
    }
}
