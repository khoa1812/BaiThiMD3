create database thithuchanh;

use thithuchanh;

create table Books (
                       id int primary key,
                       title varchar(60),
                       author varchar(60),
                       description varchar(255),
                       quantity int
);

create table Students (
                          student_id int primary key,
                          name varchar(60),
                          class varchar(60)
);

create table BorrowingCards (
                                borrow_id int primary key,
                                book_id int, foreign key (book_id) references Books (id),
                                student_id int, foreign key (student_id) references Students (student_id),
                                status boolean,
                                borrow_date date,
                                return_date date
);

insert into books values (1, '1', '1', '1', 1), (2, '2', '2', '2', 2), (3, '3', '3', '3', 3);

select * from books;



