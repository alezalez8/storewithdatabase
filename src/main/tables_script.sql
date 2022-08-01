drop table Client_info;
drop table Orders_Products;
drop table Products;
drop table Orders;
drop table Clients;


create table Clients (
                         id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         name varchar(100) NOT NULL,
                         surename varchar(100) NOT NULL
);

create table Orders(
                       id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                       client_id int NOT NULL,
                       create_date TIMESTAMP,
                       order_done boolean default true
    /*foreign key (client_id) REFERENCES Clients(id)*/
);

create table Products(
                         id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         title varchar(100) NOT NULL,
                         price double NOT NULL,
                         count int default 1
);


create table Client_info(
                            info_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                            age int CHECK ( age > 10 ),
                            phone varchar(10),
                            email varchar(30) UNIQUE NOT NULL ,
                            created_at TIMESTAMP,
                            updated_at DATETIME,
                            foreign key (info_id) REFERENCES Clients(id)
);


INSERT INTO Clients (name, surename) VALUES ('Aleksandr', 'Shunin');
INSERT INTO Clients (name, surename) VALUES ('Aleksey', 'Pupkin');
INSERT INTO Clients (name, surename) VALUES ('Leonid', 'Ivanov');
INSERT INTO Clients (name, surename) VALUES ('Petr', 'Petrov');
INSERT INTO Clients (name, surename) VALUES ('Grigoriy', 'Sidorov');
INSERT INTO Clients (name, surename) VALUES ('Boris', 'Jenkenson');
INSERT INTO Clients (name, surename) VALUES ('Tom', 'Cruis');
INSERT INTO Clients (name, surename) VALUES ('Igor', 'Perepelkin');
INSERT INTO Clients (name, surename) VALUES ('Vlad', 'Severov');


INSERT INTO Orders (client_id, create_date, order_done) VALUES (1, '14.12.19', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (1, '11.05.21', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (1, '12.10.21', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (2, '03.06.21', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (3, '27.11.20', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (3, '15.03.21', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (4, '22.05.21', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (6, '09.09.21', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (6, '19.11.21', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (9, '08.08.19', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (9, '14.06.20', true);
INSERT INTO Orders (client_id, create_date, order_done) VALUES (9, '11.12.21', true);




INSERT INTO Products (title, price, amount) VALUES ('Iphone', 14300, 10);
INSERT INTO Products (title, price, amount) VALUES ('Ipad', 12150, 9);
INSERT INTO Products (title, price, amount) VALUES ('Toy', 485, 200);
INSERT INTO Products (title, price, amount) VALUES ('Clock', 5450, 35);
INSERT INTO Products (title, price, amount) VALUES ('Notebook', 23500, 5);
INSERT INTO Products (title, price, amount) VALUES ('Netbook', 14550, 6);
INSERT INTO Products (title, price, amount) VALUES ('Printer', 5880, 15);
INSERT INTO Products (title, price, amount) VALUES ('Tools', 1200, 24);
INSERT INTO Products (title, price, amount) VALUES ('Soft', 5000, 30);
INSERT INTO Products (title, price, amount) VALUES ('Monitor', 8850, 14);


INSERT INTO Products(id, title, price, amount) VALUES (8,'Tools', 1200, 24);

drop table Orders_Products;

create table Orders_Products(
                                order_id int REFERENCES Orders(id),
                                product_id int REFERENCES Products(id),
                                PRIMARY KEY (order_id, product_id)
);
