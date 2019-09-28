package com.hjy.LearnStudy.JavaStudy.NetEase.HuYu;

import java.util.*;

/**
 * @author pauljy
 * @program LearnJava
 * @description
 * @date 2019-09-27 19:53
 */
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point = (Point) obj;
            if (point.x == this.x && point.y == this.y) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int res = 1;
        res = prime * res + x;
        res = prime * res + y;
        return res;
    }
}
public class Class4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            List<Point> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                Point point = new Point(x, y);
                list.add(point);
            }
            System.out.println(countAndPoint(list));
        }

    }

    public static int countAndPoint(List<Point> list) {
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Point point = andPoint(list.get(i), list.get(j));
                if (point != null && !set.contains(point)) {
                    set.add(point);
                }
                set.add(list.get(i));
                set.add(list.get(j));
            }
        }
        return set.size();
    }

    public static Point andPoint(Point point1, Point point2) {
        if (point1.x > point2.x && point1.y < point2.y) {
            return new Point(Math.min(point1.x, point2.x), (Math.min(point1.y, point2.y)));
        }
        if (point1.x < point2.x && point1.y > point2.y) {
            return new Point(Math.min(point1.x, point2.x), (Math.min(point1.y, point2.y)));
        }
        return null;
    }

}
