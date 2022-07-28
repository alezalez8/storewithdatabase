drop table Client_info;
drop table Products;
drop table Orders;
drop table Clients;
drop table Orders_Products;


create table Clients (
                         id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         name varchar(100) NOT NULL,
                         surename varchar(100) NOT NULL
);

create table Orders(
                       id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                       client_id int NOT NULL,
                       create_date TIMESTAMP,
                       order_done boolean default true
    /*foreign key (client_id) REFERENCES Clients(id)*/
);

create table Products(
                         id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         title varchar(100) NOT NULL,
                         price double NOT NULL,
                         count int default 1
);


create table Client_info(
                            info_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
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

INSERT INTO Orders (create_date, order_done, client_id) VALUES ('14.12.19', 1, 1);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('11.05.21', 1, 1);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('12.10.21', 1, 1);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('03.06.21', 1, 2);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('27.11.20', 1, 3);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('15.03.21', 1, 3);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('22.05.21', 1, 4);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('09.09.21', 1, 6);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('19.11.21', 1, 6);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('08.08.19', 1, 9);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('14.06.20', 1, 9);
INSERT INTO Orders (create_date, order_done, client_id) VALUES ('11.12.21', 1, 9);




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