INSERT INTO users(login, password)
values ('john', '1111'),
       ('mary', '2222'),
       ('pall', '3333'),
       ('ruth', '4444'),
       ('kate', '5555');


INSERT INTO rooms(name, ownerid)
values ('chatroom №1', (SELECT userId FROM users WHERE login = 'john')),
       ('chatroom №2', (SELECT userId FROM users WHERE login = 'mary')),
       ('chatroom №3', (SELECT userId FROM users WHERE login = 'pall')),
       ('chatroom №4', (SELECT userId FROM users WHERE login = 'ruth')),
       ('chatroom №5', (SELECT userId FROM users WHERE login = 'kate')),
       ('chatroom №6', (SELECT userId FROM users WHERE login = 'john')),
       ('chatroom №7', (SELECT userId FROM users WHERE login = 'mary')),
       ('chatroom №8', (SELECT userId FROM users WHERE login = 'pall')),
       ('chatroom №9', (SELECT userId FROM users WHERE login = 'ruth')),
       ('chatroom №10', (SELECT userId FROM users WHERE login = 'kate'));

INSERT INTO messages(text, authorid, roomid)
values ('hello, I have done it', (SELECT userid FROM users WHERE login = 'john'),
        (SELECT idroom FROM rooms WHERE name = 'chatroom №1')),
       ('Kate, I am here', (SELECT userid FROM users WHERE login = 'pall'),
        (SELECT idroom FROM rooms WHERE name = 'chatroom №10')),
       ('I am alone as always', (SELECT userid FROM users WHERE login = 'mary'),
        (SELECT idroom FROM rooms WHERE name = 'chatroom №2')),
       ('I am stay up until the show', (SELECT userid FROM users WHERE login = 'pall'),
        (SELECT idroom FROM rooms WHERE name = 'chatroom №9')),
       ('Who are you? What are doing  here? Go away ...', (SELECT userid FROM users WHERE login = 'ruth'),
        (SELECT idroom FROM rooms WHERE name = 'chatroom №2'));

