public abstract class GenericMartix<E extends Number> {

    protected abstract E add(E o1, E o2);

    protected abstract E multiply(E o1, E o2);

    protected abstract E zero();

    public E[][] addMatrix(E[][] matrix1, E[][] martrix2) {
        if ((matrix1.length != martrix2.length) || (matrix1[0].length != martrix2[0].length)) {
            throw new RuntimeException("The matrix do not have the same size");
        }

        E[][] result = (E[][]) new Number[matrix1.length][matrix1[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                //调用的是add抽象方法。
                result[i][j] = add(matrix1[i][j] ,martrix2[i][j]);
            }
        }
        return result;
    }

    public E[][] multiplyMatrix(E[][] matrix1, E[][] martrix2) {
        if (matrix1[0].length != martrix2.length) {
            throw new RuntimeException("The matrix do not have compatible size");
        }

        E[][] result = (E[][]) new Number[matrix1.length][martrix2[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();
                //调用的是add抽象方法。
                for(int k = 0;k< matrix1[0].length;k++){
                    result[i][j] = add(result[i][j],multiply(matrix1[i][k],martrix2[k][j]));
                }
            }
        }
        return result;
    }

    public static void printResult(Number[][] m1, Number[][] m2, Number[][] m3, char op) {
          for(int i = 0;i<m1.length;i++){
              for(int j = 0;j<m1[0].length;j++){
                  System.out.print(" "+m1[i][j]);
              }

              if(i == m1.length / 2){
                  System.out.print(" "+op+" ");
              }else{
                  System.out.print(" ");
              }

              for(int j = 0 ;j<m2.length;j++){
                  System.out.print(" "+m2[i][j]);
              }

              if(i == m1.length / 2){
                  System.out.print(" = ");
              }else{
                  System.out.print(" ");
              }

              for(int j = 0;j<m3.length;j++){
                  System.out.print(m3[i][j]+" ");
              }
              System.out.println();
          }
    }

}
