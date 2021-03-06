create table grade(
    gid int primary key,
    gname varchar(20) not null,
    gdesc varchar(50)
);

create table student(
    pid int primary key,
    pname varchar(20) not null,
    ssex char(7),
    gid int
);

alter table student add constraint fk_student_gid foreign key(gid) references grade(gid);