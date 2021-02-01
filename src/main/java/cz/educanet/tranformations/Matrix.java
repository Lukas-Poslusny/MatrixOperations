package cz.educanet.tranformations;

import kotlin.NotImplementedError;

import java.nio.InvalidMarkException;
import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;
        return 0;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        IMatrix transposedMatrix = matrix.transpose();
        double[][] temp = new double [getRows()][getColumns()];
        for (int y = 0; y < getColumns(); y++) {
            for (int x = 0; x < getRows(); x++) {
                int sum = 0;
                for (int z = 0; z < getRows(); z++) {
                    sum += rawArray[x][z] * transposedMatrix.get(y, z);
                }
                temp[x][y] = sum;
            }
        }
        return MatrixFactory.create(temp);
    }

    @Override
    public IMatrix times(Number scalar) {
        double[][] temp = new double [getRows()][getColumns()];
        for (int y = 0; y < getColumns(); y++) {
            for (int x = 0; x < getRows(); x++) {
                temp[x][y] *= scalar.doubleValue();
            }
        }
        return MatrixFactory.create(temp);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        double[][] temp = new double [getRows()][getColumns()];
        for (int y = 0; y < this.getColumns(); y++) {
            for (int x = 0; x < this.getRows(); x++) {
                temp[x][y] +=  this.get(x, y);
            }
        }
        return MatrixFactory.create(temp);
    }

    @Override
    public double get(int n, int m) {
        return this.rawArray[n][m];
    }

    //region Optional
    @Override
    public IMatrix transpose() {
        double[][] temp = new double [getRows()][getColumns()];
        for (int y = 0; y < this.getColumns(); y++) {
            for (int x = 0; x < this.getRows(); x++) {
                temp[x][y] = this.rawArray[y][x];
            }
        }
        return MatrixFactory.create(temp);
    }

    @Override
    public double determinant() {
        return 0;
    }
    //endregion
    //region Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(rawArray, matrix.rawArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rawArray);
    }
    //endregion
}
