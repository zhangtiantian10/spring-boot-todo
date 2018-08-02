create table user(
	`id` int primary key auto_increment,
  `name` varchar(255),
  `password` varchar(255),
  `deleted` boolean default false
);
