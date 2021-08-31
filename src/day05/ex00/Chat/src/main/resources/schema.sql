CREATE TABLE users
(
    userId   bigserial not null PRIMARY KEY,
    login    varchar(255) not null,
    password varchar(255) not null
);


CREATE TABLE rooms
(
    idRoom  bigserial not null PRIMARY KEY,
    name    varchar(255) not null,
    ownerId int references users (userId) not null
);

CREATE TABLE messages
(
    idMessages bigserial                     not null PRIMARY KEY,
    text       varchar(255)                  not null,
    authorId   int references users (userId) not null,
    roomId     int references rooms (idRoom) not null,
    date       TIMESTAMP                     not null default NOW()
);



