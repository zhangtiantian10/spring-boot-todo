create table task(
	`id` int primary key auto_increment,
  content varchar(255),
  todo_id int ,
  `deleted` boolean default false ,
	foreign key (todo_id) references todo(id)
);