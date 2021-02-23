USE application_db;

INSERT INTO Company (CompanyName, PointToDollar, Email, OfficePhone)
VALUES ('Dummy Company', 100, 'company@gmail.com', '(123) 456-7890');

INSERT INTO Users (UserType, Username, FirstName, MiddleName, LastName, PreferredName, UserPassword, LastLogon, TwoFactorAuth)
VALUES ('D', 'driver@gmail.com', 'Dummy', 'Driver', 'Account', 'DDA', 'password', CURRENT_TIMESTAMP(), False);

INSERT INTO Driver (Points, DriverApplicationID, Address, UserID, CompanyID)
VALUES (500, NULL, '105 Sikes Hall, Clemson, SC 29634', 1, 1);

INSERT INTO Users (UserType, Username, FirstName, MiddleName, LastName, PreferredName, UserPassword, LastLogon, TwoFactorAuth)
VALUES ('S', 'sponsor@gmail.com', 'Dummy', 'Sponsor', 'Account', 'DSA', 'password', CURRENT_TIMESTAMP(), False);

INSERT INTO Sponsor (CompanyID, UserID)
VALUES (1, 2);

INSERT INTO Users (UserType, Username, FirstName, MiddleName, LastName, PreferredName, UserPassword, LastLogon, TwoFactorAuth)
VALUES ('A', 'admin@gmail.com', 'Dummy', 'Admin', 'Account', 'DAA', 'password', CURRENT_TIMESTAMP(), False);