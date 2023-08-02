create table if not exists warden
(
    id    bigserial primary key,
    name  varchar(50) not null,
    phone varchar(15) not null
);

create table if not exists dormitory
(
    id        bigserial primary key,
    number    integer unique not null,
    address   varchar(50)    not null,
    num_rooms integer unique not null,
    warden    integer,

    constraint dormitory_warden_fk foreign key (warden) references warden (id)

);

create table if not exists room
(
    id         bigserial primary key,
    num_seats  integer not null,
    free_p     integer not null,
    occupied_p integer not null,
    dormitory  integer,

    constraint room_dormitory_fk foreign key (dormitory) references dormitory (id)

);

create table if not exists profile
(
    id     bigserial primary key,
    eco    bool not null,
    deputy bool not null,
    nurse  bool not null
);

create table if not exists department
(
    id        bigserial primary key,
    full_name varchar(50) not null,
    name      varchar(50) not null
);

create table if not exists groups
(
    id         bigserial primary key,
    name       varchar(50) not null,
    number     integer     not null,
    department integer,

    constraint groups_department_fk foreign key (department) references department (id)

);

create table if not exists speciality
(
    id         bigserial primary key,
    name       varchar(50) not null,
    number     integer     not null,
    department integer,

    constraint groups_department_fk foreign key (department) references department (id)
);

create table if not exists role
(
    id   bigserial primary key,
    name varchar(50) not null
);

create table if not exists student
(
    id         bigserial primary key,
    surname    varchar(50) not null,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    age        integer     not null,
    phone      varchar(50) not null,
    groups     integer,
    department integer,
    speciality integer,
    profile    integer,
    role       integer,
    dormitory  integer,
    room       integer,

    constraint student_groups_fk foreign key (groups) references groups (id),
    constraint student_department_fk foreign key (department) references department (id),
    constraint student_speciality_fk foreign key (speciality) references speciality (id),
    constraint student_profile_fk foreign key (profile) references profile (id),
    constraint student_role_fk foreign key (role) references role (id),
    constraint student_dormitory_fk foreign key (dormitory) references dormitory (id),
    constraint student_room_fk foreign key (room) references room (id)
);

create table if not exists employee
(
    id         bigserial primary key,
    surname    varchar(50) not null,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    age        integer     not null,
    phone      varchar(15) not null,
    role       integer,

    constraint employee_role_fk foreign key (role) references role (id)

);

create table if not exists administrator
(
    id bigserial primary key,
    name varchar(50) unique not null,
    role integer,

    constraint employee_role_fk foreign key (role) references role (id)
);

create table if not exists users
(
    id       bigserial primary key,
    login    varchar(50) unique not null,
    password varchar(50)        not null,
    email    varchar(50) unique not null,
    student  integer,
    employee integer,
    administrator integer,

    constraint users_student_fk foreign key (student) references student (id),
    constraint users_employee_fk foreign key (employee) references employee (id),
    constraint users_administrator_fk foreign key (administrator) references administrator (id)
);

create or replace function f(num_room integer)
    returns setof dormitory
as '
    declare
        counter integer = 0;
    begin
        while counter < num_room
            LOOP
                counter = counter + 1;
                insert
                into room (id, num_seats, free_p, occupied_p)
                values (counter, 4, 4, 0)
                ON CONFLICT DO NOTHING;
            END LOOP;
    end;
' language plpgsql;

CREATE OR REPLACE FUNCTION insert_data_after_table_creation()
    RETURNS void AS
'
    BEGIN
        IF EXISTS (SELECT * FROM administrator WHERE id = 1) THEN
        else
            insert into warden (id, name, phone)
            values (1, ''GALINA'', ''380951501940'')
            ON CONFLICT DO NOTHING;

            insert into dormitory (id, number, address, num_rooms, warden)
            values (1, 6, ''Valtera 14'', 525, 1)
            ON CONFLICT DO NOTHING;

            perform f((select num_rooms from dormitory where id = 1));

            insert into profile (id, eco, deputy, nurse)
            values (1, false, false, false)
            ON CONFLICT DO NOTHING;
            insert into profile (id, eco, deputy, nurse)
            values (2, false, false, false)
            ON CONFLICT DO NOTHING;
            insert into profile (id, eco, deputy, nurse)
            values (3, false, false, false)
            ON CONFLICT DO NOTHING;

            insert into department (id, full_name, name)
            values (1, ''comp sinse depart'', ''csd'')
            ON CONFLICT DO NOTHING;

            insert into groups (id, name, number, department)
            values (1, ''ky'', 51, 1)
            ON CONFLICT DO NOTHING;

            insert into speciality (id, name, number, department)
            values (1, ''avtomatization'', ''151'', 1)
            ON CONFLICT DO NOTHING;

            insert into role (id, name)
            values (1, ''student'')
            ON CONFLICT DO NOTHING;
            insert into role (id, name)
            values (2, ''employee'')
            ON CONFLICT DO NOTHING;
            insert into role (id, name)
            values (3, ''admin'')
            ON CONFLICT DO NOTHING;

            insert into student (id, surname, first_name, last_name, age, phone,
                                 groups, department, speciality, profile, role, dormitory, room)
            values (1, ''Golikov'', ''Max'', ''Sergiyovich'', 21, ''380660789987'', 1, 1, 1, 1, 1, null, null)
            ON CONFLICT DO NOTHING;
            insert into student (id, surname, first_name, last_name, age, phone,
                                 groups, department, speciality, profile, role, dormitory, room)
            values (2, ''2'', ''2'', ''2'', 21, ''380660123456'', 1, 1, 1, 2, 1, null, null)
            ON CONFLICT DO NOTHING;
            insert into student (id, surname, first_name, last_name, age, phone,
                                 groups, department, speciality, profile, role, dormitory, room)
            values (3, ''3'', ''3'', ''3'', 17, ''380666987654'', 1, 1, 1, 3, 1, null, null)
            ON CONFLICT DO NOTHING;

            insert into employee (id, surname, first_name, last_name, age, phone, role)
            values (1, ''emp1'', ''emp1'', ''emp1'', 45, ''380111987654'', 2)
            ON CONFLICT DO NOTHING;

            insert into administrator (id, name, role)
            values (1, ''admin'', 3)
            ON CONFLICT DO NOTHING;

            insert into users (id, login, password, email, administrator)
            values (1, ''admin'', ''admin'', ''admin@gmail.com'', 1)
            ON CONFLICT DO NOTHING;
            insert into users (id, login, password, email, student)
            values (2, ''student1'', ''student1'', ''student1'', 1)
            ON CONFLICT DO NOTHING;
            insert into users (id, login, password, email, student)
            values (3, ''student2'', ''student2'', ''student2'', 2)
            ON CONFLICT DO NOTHING;
            insert into users (id, login, password, email, student)
            values (4, ''student3'', ''student3'', ''student3'', 3)
            ON CONFLICT DO NOTHING;
            insert into users (id, login, password, email, employee)
            values (5, ''employee'', ''employee'', ''employee'', 1)
            ON CONFLICT DO NOTHING;
        end if;
    END;
' LANGUAGE plpgsql;

select insert_data_after_table_creation()
