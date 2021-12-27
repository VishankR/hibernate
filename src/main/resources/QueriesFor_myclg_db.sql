create table image (
       student_id integer not null,
        file_name varchar(255)
    ) engine=InnoDB

create table student (
       id integer not null auto_increment,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    ) engine=InnoDB
alter table image 
       add constraint FKkdnkltse884wuiqwkt4cpuo9m 
       foreign key (student_id) 
       references student (id)