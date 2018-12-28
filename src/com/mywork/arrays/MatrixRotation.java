package com.mywork.arrays;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class MatrixRotation
{
    public int[][][] testCases = { { { 1, 2 }, { 2, 3 }, { 4, 5 }, { 6, 7 } },
            { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } }, { { 1, 2, 3, 4, 5 } },
            { { 1 }, { 2 }, { 3 }, { 4 } },
            { { 1, 2, 3, 4, 5 }, { 100, 101, 12, 2, 4 }, { 10, 11, 12, 13, 14 },
                    { 15, 16, 17, 18, 19 }, { 30, 31, 32, 33, 34 }, { 50, 51, 52, 53, 54 } } };

    public int[] rotationCounts = { 5, 3, 1, 1, 2 };

    public int[][] rotateMatrix(int[][] matrix, int rotations)
    {
        int[][] rotatedMatrix = null;
        int i, m = matrix.length, n = matrix[0].length;
        rotations = rotations % 4;

        rotatedMatrix = new int[n][m];

        for (i = 1; i <= rotations; i++)
        {
            if ((i & 1) == 1)
            {
                rotatedMatrix = copyMatrixValues(matrix, rotatedMatrix, m, n);
            }
            else
            {
                matrix = copyMatrixValues(rotatedMatrix, matrix, n, m);
            }
        }
        if ((rotations & 1) == 1)
            return rotatedMatrix;
        else
            return matrix;
    }

    public int[][] copyMatrixValues(int[][] matrix1, int[][] matrix2, int m, int n)
    {
        int j, k;
        for (j = 0; j < m; j++)
        {
            for (k = 0; k < n; k++)
            {
                matrix2[n - 1 - k][j] = matrix1[j][k];
            }
        }
        return matrix2;
    }

    public void printMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print("" + matrix[i][j] + ", ");
            System.out.println("");
        }
    }

    public static void main(String[] args)
    {
        MatrixRotation matrixRotationObj = new MatrixRotation();
        for (int i = 0; i < matrixRotationObj.testCases.length; i++)
        {
            System.out.println("#############################################");
            System.out.println("Input Matrix: ");
            matrixRotationObj.printMatrix(matrixRotationObj.testCases[i]);
            int[][] rotatedMatrix = null;
            rotatedMatrix = matrixRotationObj.rotateMatrix(matrixRotationObj.testCases[i],
                    matrixRotationObj.rotationCounts[i]);
            System.out.println(
                    "Output Matrix after " + matrixRotationObj.rotationCounts[i] + " anti-clock rotations");
            matrixRotationObj.printMatrix(rotatedMatrix);
            System.out.println("");
        }

    }

}
