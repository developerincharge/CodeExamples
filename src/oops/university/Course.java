package oops.university;

class Course {
    static int maxCapacity = 100;
    String courseName;
    int enrollments;

    String[] enrolledStudents;

    Course (String courseName) {
        this.courseName = courseName;
        this.enrollments = 0;
        this.enrolledStudents = new String[maxCapacity];
    }

    static void setMaxCapacity(int maxCapacity) {
        Course.maxCapacity = maxCapacity;
    }
   void enrollStudent(String studentName) {
       if (enrollments >= maxCapacity) {
           enrolledStudents[enrollments] = studentName;
           this.enrollments++;
           System.out.println(studentName + " has been enrolled in " + courseName);
       } else {
           System.out.println("Cannot enroll " + studentName + ". Course " + courseName + " is at full capacity.");
       }
   }
        void unEnrollStudent(String studentName) {
            for (int i = 0; i < enrollments; i++) {
                if (enrolledStudents[i].equals(studentName)) {
                    enrolledStudents[i] = enrolledStudents[enrollments - 1]; // Move the last student to the current position
                    enrolledStudents[enrollments - 1] = null; // Clear the last position
                    enrollments--;
                    System.out.println(studentName + " has been unenrolled from " + courseName);
                    return;
                }
            }
            System.out.println(studentName + " is not enrolled in " + courseName);


   }

}
