package pat;

import java.util.*;

/**
 * Created by kimvra on 2019-03-23
 */
class Student implements Comparable<Student>{
    String orderNO;
    int score;
    int locationNum;
    int localRank;
    int rank;

    public Student(int locationNum, String orderNO, int score) {
        this.locationNum = locationNum;
        this.orderNO = orderNO;
        this.score = score;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setLocalRank(int localRank) {
        this.localRank = localRank;
    }

    @Override
    public int compareTo(Student o) {
        return this.score != o.score ? (this.score > o.score ? -1 : 1) : 0;
    }

    @Override
    public String toString() {
        return orderNO + " " + rank + " " + locationNum + " " + localRank + " " + score;
    }
}

public class PAT1025 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            int numOfStu = in.nextInt();
            List<Student> tempList = new ArrayList<>();
            for (int j = 0; j < numOfStu; j++) {
                String orderNO = in.next();
                int score = in.nextInt();
                Student student = new Student(i + 1, orderNO, score);
                studentList.add(student);
                tempList.add(student);
            }
            Collections.sort(tempList);
            int localRank = 1;
            tempList.get(0).setLocalRank(localRank);
            for (int k = 1; k < numOfStu; k++) {
                if (tempList.get(k).score == tempList.get(k - 1).score) {
                    tempList.get(k).setLocalRank(tempList.get(k - 1).localRank);
                } else {
                    tempList.get(k).setLocalRank(k + 1);
                }
            }
        }
        Collections.sort(studentList);
        int rank = 1;
        studentList.get(0).setRank(rank);
        for (int k = 1; k < studentList.size(); k++) {
            if (studentList.get(k).score == studentList.get(k - 1).score) {
                studentList.get(k).setRank(studentList.get(k - 1).rank);
            } else {
                studentList.get(k).setRank(k + 1);
            }
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
