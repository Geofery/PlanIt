drop schema if exists PLANIT;
create schema if not exists PlanIt collate utf8mb4_0900_ai_ci;
use PlanIt;
create table if not exists PlanIt.Users
(
	id int auto_increment,
	username varchar(100) not null,
	email varchar(100) not null,
	password varchar(100) not null,
	constraint email_UNIQUE
		unique (email),
	constraint idUsers_UNIQUE
		unique (id)
);

alter table Users
	add primary key (id);

create table if not exists PlanIt.Projects
(
    id int auto_increment,
    user_id int not null,
    name varchar(100) not null,
    start date not null,
    finish date not null,
	actual_hours int default 0 null,
    actual_cost  int default 0 null,
    budget int not null,
    constraint id_UNIQUE
    unique (id),
    constraint fkuser
    foreign key (user_id) references PlanIt.Users (id)
    on update cascade on delete cascade
    );

create index fkuser_id_idx
    on PlanIt.Projects (user_id);

alter table PlanIt.Projects
    add primary key (id);

create table if not exists PlanIt.Tasks
(
    id int auto_increment,
    project_id int not null,
    name varchar(100) not null,
    start date not null,
    finish date not null,
    hours      int default 0 null,
    cost        int default 0 null,
    constraint id_UNIQUE
    unique (id),
    constraint fkprojectId
    foreign key (project_id) references PlanIt.Projects (id)
    on update cascade on delete cascade
);

alter table PlanIt.Tasks
	add primary key (id);

create table if not exists PlanIt.Subtasks
(
    id int auto_increment,
    task_id int not null,
    name varchar(100) not null,
    estimated_hours int not null,
    cost int not null,
    constraint id_UNIQUE
    unique (id),
    constraint fktaskId
    foreign key (task_id) references PlanIt.Tasks (id)
    on update cascade on delete cascade
);

create index fk_idx
	on Subtasks (task_id);

alter table PlanIt.Subtasks
	add primary key (id);

