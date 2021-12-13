drop schema if exists PLANIT;
create schema if not exists PlanIt collate utf8mb4_0900_ai_ci;
use PlanIt;
CREATE TABLE IF NOT EXISTS PlanIt.Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    CONSTRAINT email_UNIQUE UNIQUE (email),
    CONSTRAINT idUsers_UNIQUE UNIQUE (id)
);

CREATE TABLE IF NOT EXISTS PlanIt.Projects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    start DATE NOT NULL,
    finish DATE NOT NULL,
    actual_hours INT DEFAULT 0 NULL,
    actual_cost INT DEFAULT 0 NULL,
    budget INT NOT NULL,
    CONSTRAINT id_UNIQUE UNIQUE (id),
    CONSTRAINT fkuser FOREIGN KEY (user_id)
        REFERENCES Users (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);
create index fkuser_id_idx
    on Projects (user_id);

CREATE TABLE IF NOT EXISTS PlanIt.Tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    project_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    start DATE NOT NULL,
    finish DATE NOT NULL,
    hours INT DEFAULT 0 NULL,
    cost INT DEFAULT 0 NOT NULL,
    CONSTRAINT id_UNIQUE UNIQUE (id),
    CONSTRAINT fkprojectId FOREIGN KEY (project_id)
        REFERENCES Projects (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS PlanIt.Subtasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    task_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    estimated_hours INT NOT NULL,
    cost INT NOT NULL,
    CONSTRAINT id_UNIQUE UNIQUE (id),
    CONSTRAINT fktaskId FOREIGN KEY (task_id)
        REFERENCES Tasks (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

create index fk_idx
	on Subtasks (task_id);
