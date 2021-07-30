Create table Teachers(
    TeacherID int not null,
    TeacherName varchar(255),
    primary key(TeacherID));

Create table Courses(
    CourseID int not null,
    CourseName varchar(255),
    TeacherID int,
    primary key(CourseID),
    foreign key(TeacherID) references Teachers(TeacherID));

Create table Students(
    StudentID int not null,
    StudentName varchar(255),
    primary key(StudentID));

Create table StudentCourses(
    CourseID int not null,
    StudentID int not null,
    primary key(CourseID, StudentID),
    foreign key(CourseID) references Courses(CourseID),
    foreign key(StudentID) references Students(StudentID));

insert into Students
values(123, 'Jack');

insert into Teachers
values(123, 'John T');

insert into Courses
values(111, 'Math');
insert into Courses
values(222, 'Chemist');

insert into StudentCourses
values(111, 123);
insert into StudentCourses
values(222, 123);


select s.studentId, s.studentName, count(sc.courseId)
from Students s, StudentCourses sc
where s.studentId=sc.studentId
group by s.studentId;