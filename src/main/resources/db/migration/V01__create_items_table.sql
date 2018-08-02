create table todo(
	`id` int primary key auto_increment,
  `value` varchar(255),
  `is_complete` boolean default false,
  `date` timestamp default now(),
  `deleted` boolean default false
);
