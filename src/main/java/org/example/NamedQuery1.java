package org.example;

import jakarta.persistence.*;


@Entity
@Table(name="STUDENT")
@NamedQueries(
        {
                @NamedQuery(
                        name = "findNamedQueryByName",
                        query = "select s.id,s.name,s.address from NamedQuery1 s where s.name = :name"
                )
        }
)
public class NamedQuery1 {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
//    ,generator = "gen"
//    @SequenceGenerator(name = "gen",sequenceName = "seqgen",allocationSize = 1)
        int id;
        String name;
        String address;

//        @OneToMany(mappedBy = "student")
//        Set<Courses> coursesSet=new HashSet<Courses>();

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }



        public void setAddress(String address) {
            this.address = address;
        }

//        public Set<Courses> getCoursesSet() {
//            return coursesSet;
//        }

//    public void toPrint(){
//        System.out.println("Courses: ");
//        for(Courses course:coursesSet){
//            System.out.println(course.getName());
//        }
//    }

//        public void setCoursesSet(Set<Courses> coursesSet) {
//            this.coursesSet = coursesSet;
//        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'';
//                    +
//                    ", coursesSet=" + coursesSet +
//                    '}';
        }

}
