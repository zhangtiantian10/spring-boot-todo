create table todo(
	`id` int primary key auto_increment,
  `value` varchar(255),
  `is_complete` bool,
  `date` date,
  `deleted` boolean default false
);
