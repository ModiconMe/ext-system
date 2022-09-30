DROP TABLE IF EXISTS ro_marriage_certificate;
DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_person;

CREATE TABLE ro_person (
    person_id SERIAL,
    sex smallint not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    patronymic varchar(100),
    date_of_birth date not null,
    PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport (
    passport_id SERIAL,
    person_id integer not null,
    series varchar(10) not null,
    number varchar(10) not null,
    date_issue date not null,
    issue_department varchar(200),
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_birth_certificate (
    certificate_id SERIAL,
    number varchar(20) not null,
    issue_date date not null,
    person_id integer not null,
    father_id integer,
    mother_id integer,
    PRIMARY KEY (certificate_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (father_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (mother_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_marriage_certificate (
    certificate_id SERIAL,
    number varchar(20) not null,
    issue_date date not null,
    husband_id integer not null,
    wife_id integer not null,
    active boolean DEFAULT false,
    end_date date,
    PRIMARY KEY (certificate_id),
    FOREIGN KEY (husband_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (wife_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

INSERT INTO ro_person (sex, first_name, last_name, patronymic, date_of_birth)
VALUES (1, 'Polina1', 'Popova1', 'Igorevna1', '2000-02-25'),
(2, 'Dmitry', 'Popov', 'Olegovich', '1999-07-09'),
(1, 'Alena', 'Popova', 'Dmitrievna', '2020-11-09'),
(2, 'Yuri', 'Popov', 'Dmitriev', '2020-07-09'),
(1, 'Polina2', 'Popova2', 'Igorevna2', '2000-12-25');

INSERT INTO ro_passport (person_id, series, number, date_issue, issue_department)
VALUES (1, '1111', '111111', '2000-02-25', ''),
(2, '2222', '222222', '1999-07-09', ''),
(5, '3333', '333333', '2000-07-09', '');

INSERT INTO ro_birth_certificate (certificate_id, number, issue_date, person_id, father_id, mother_id)
VALUES (1, 'BC11111111', '2020-02-25', 3, 1, 2), (2, 'BC22222222', '2022-11-09', 3, 1, 5);

INSERT INTO ro_marriage_certificate (certificate_id, number, issue_date, husband_id, wife_id, active, end_date)
VALUES (1, 'MC11111111', '2019-02-25', 2, 1, false, '2021-02-25'), (2, 'MC22222222', '2021-11-09', 2, 5, true, null);

INSERT INTO ro_person (sex, first_name, last_name, patronymic, date_of_birth)
VALUES (1, 'Polina', 'Popova', 'Igorevna', '2000-02-25'),
(2, 'Dmitry', 'Popov', 'Olegovich', '1999-07-09');

INSERT INTO ro_passport (person_id, series, number, date_issue, issue_department)
VALUES (1, '1111', '111111', '2000-02-25', ''),
(2, '2222', '222222', '1999-07-09', '')