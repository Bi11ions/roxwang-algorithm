package com.huawei;

import java.util.*;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Grade> grade1Map = new HashMap<>();
        String str = sc.next();
        if (null == str || str.trim().length() < 1) {
            System.out.println("NULL");
            return;
        }

        String[] infoArr = str.trim().split(";");
        for (String info : infoArr) {
            if (null == info || info.trim().length() < 1) {
                continue;
            }

            String[] infoDetailArr = info.trim().split(",");
            if (infoDetailArr.length < 2) {
                continue;
            }

            String studentNum = infoDetailArr[0].trim();
            Grade grade = new Grade();
            grade.setStudentNum(studentNum);
            grade.setGrade(Integer.parseInt(infoDetailArr[1]));
            grade1Map.put(studentNum, grade);
        }

        str = sc.next();
        if (null == str || str.trim().length() < 1) {
            System.out.println("NULL");
            return;
        }

        Map<String, List<Grade>> classMap = new HashMap<>();
        infoArr = str.trim().split(";");
        for (String info : infoArr) {
            if (null == info || info.trim().length() < 1) {
                continue;
            }

            String[] infoDetailArr = info.trim().split(",");
            if (infoDetailArr.length < 2) {
                continue;
            }

            String studentNum = infoDetailArr[0].trim();
            Grade gradeExist = grade1Map.get(studentNum);
            if (null == gradeExist) {
                continue;
            }

            String classNum = studentNum.substring(0, 5);
            Grade grade = new Grade();
            grade.setStudentNum(studentNum);
            grade.setGrade(Integer.parseInt(infoDetailArr[1]) + gradeExist.getGrade());
            List<Grade> classList = classMap.get(classNum);
            if (null == classList) {
                classList = new ArrayList<>();
            }

            classList.add(grade);
            classMap.put(classNum, classList);
        }

        if (classMap.size() < 1) {
            System.out.println("NULL");
            return;
        }

        List<String> classNumList = new ArrayList<>(classMap.keySet());
        classNumList.sort(Comparator.comparingInt(Integer::parseInt));
        for (String classNum : classNumList) {
            System.out.println(classNum);
            List<Grade> gradeList = classMap.get(classNum);
            gradeList.sort((o1, o2) -> {
                Integer grade1 = o1.getGrade();
                Integer grade2 = o2.getGrade();
                if (grade1 > grade2) {
                    return -1;
                }

                if (grade1 < grade2) {
                    return 1;
                }

                int classNum0 = Integer.parseInt(o1.getStudentNum());
                int classNum1 = Integer.parseInt(o2.getStudentNum());
                return Integer.compare(classNum0, classNum1);
            });

            System.out.println(gradeList.stream().map(Grade::getStudentNum).collect(Collectors.joining(";")));
        }
    }

    static class Grade {
        private String studentNum;
        private Integer grade;

        public Integer getGrade() {
            return grade;
        }

        public void setStudentNum(String studentNum) {
            this.studentNum = studentNum;
        }

        public String getStudentNum() {
            return studentNum;
        }

        public void setGrade(Integer grade) {
            this.grade = grade;
        }
    }
}
