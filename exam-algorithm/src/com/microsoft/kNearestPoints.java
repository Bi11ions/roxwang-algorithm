package com.microsoft;

/**
 * 微软面试题： K 个最近的点
 * 给定一些 points 和一个 origin，从 points 中找到 k 个离 origin 最近的点。按照距离由小到大返回。
 * 如果两个点有相同距离，则按照 x 值来排序；若 x 值也相同，就再按照 y 值排序。
 * <p>
 * 例 1:
 * 输入: points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
 * 输出: [[1,1],[2,5],[4,4]]
 * <p>
 * 例 2:
 * 输入: points = [[0,0],[0,9]], origin = [3, 1], k = 1
 * 输出: [[0,0]]
 * <p>
 * 使用 Heapify 的方法 heapify 时间复杂度 O(n) 然后 pop k 个点出来，时间复杂度 klogn 总共的时间复杂度 O(n+klogn) 如果 n >> k 的话，这种方法的时间复杂度是很优秀的。
 */
public class kNearestPoints {

    // 原始对比坐标；
    private Point originPoint;

    // 实时数组长度
    private int length;

    /**
     * 坐标点
     */
    static class Point implements Comparable<Point> {
        private Integer x;
        private Integer y;

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            int distance = this.x + this.y;
            int distanceOfO = o.x + o.y;
            if (distance > distanceOfO) {
                return 1;
            }

            if (distance < distanceOfO) {
                return -1;
            }

            return this.x > o.x ? 1 : this.y >= o.y ? 1 : -1;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    /**
     * 获取左子树坐标
     *
     * @return 下标
     */
    private static int getLeft(int n, int length) {
        int left = 2 * n + 1;
        return left > length ? length - 1 : left;
    }

    /**
     * 获取右子树坐标
     *
     * @return 下标
     */
    private static int getRight(int n, int length) {
        int right = 2 * n + 2;
        return right > length ? right - 1 : right;
    }

    /**
     * 构建前N个最小堆
     *
     * @param points
     * @param originPoint
     * @param k
     * @return
     */
    public Point[] buildHeap(Point[] points, Point originPoint, int k) {
        if (null == points || points.length < 1) {
            return new Point[0];
        }

        this.length = points.length;
        this.originPoint = originPoint;
        // O(n)
        heapify(points);

        Point[] result = new Point[k];
        // O(K * logn)
        for (int i = 0; i < k; i++) {
            result[i] = pop(points);
        }

        return result;
    }

    private Point pop(Point[] points) {
        Point point = points[0];
        points[0] = points[points.length - 1];
        this.length--;

        siftDown(points, 0);
        return point;
    }

    /**
     * 堆化
     *
     * @param points
     */
    private void heapify(Point[] points) {
        for (int i = length / 2; i >= 0; i--) {
            siftDown(points, i);
        }
    }

    private void siftDown(Point[] points, int index) {
        while (index < length) {
            int left = getLeft(index, length);
            int right = getRight(index, length);
            // 假设当前节点最小
            int min = index;
            // 如果左子树比当前节点小，那么左子树与当前节点交换位置
            if (left < length && compareInstance(points[min], points[left]) > 0) {
                min = left;
            }

            // 如果右子树比当前节点小，那么右子树与当前节点交换位置，右子树如果小于左子树优先交换右子树
            if (right < length && compareInstance(points[min], points[right]) > 0) {
                min = right;
            }

            if (index != min) {
                Point temp = points[index];
                points[index] = points[min];
                points[min] = temp;
                index = min;
            } else {
                break;
            }
        }
    }

    /**
     * 比较二者距离
     *
     * @param left  左节点
     * @param right 右节点
     * @return 1 大于， -1 小于/等于
     */
    public int compareInstance(Point left, Point right) {
        int instanceLeft = getInstanceFromOrigin(left);
        int instanceRight = getInstanceFromOrigin(right);
        if (instanceLeft > instanceRight) {
            return 1;
        }

        if (instanceLeft < instanceRight) {
            return -1;
        }

        return left.x > right.x ? 1 : left.y > right.y ? 1 : -1;
    }

    /**
     * 两坐标之间距离判断。 少了根号步骤
     *
     * @param target 目标坐标
     * @return 距离的平方
     */
    private int getInstanceFromOrigin(Point target) {
        int y = target.y - this.originPoint.y;
        int x = target.x - this.originPoint.x;
        return x * x + y * y;
    }

    public static void main(String[] args) {
        kNearestPoints kNearestPoints = new kNearestPoints();
        Point[] points = new Point[]{new Point(4, 6), new Point(4, 7), new Point(4, 4), new Point(2, 5), new Point(1, 1)};
        Point[] result = kNearestPoints.buildHeap(points, new Point(0, 0), 3);
        for (Point point : result) {
            System.out.println(point);
        }
    }

}
