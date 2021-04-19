DROP DATABASE application_db;

CREATE DATABASE application_db;

USE application_db;

CREATE TABLE Users (
	UserID int NOT NULL AUTO_INCREMENT,
    UserType varchar(1) NOT NULL,
    Username varchar(255) UNIQUE NOT NULL,
    FirstName varchar(255) NOT NULL,
    MiddleName varchar(255) NOT NULL,
    LastName varchar(255) NOT NULL,
    PreferredName varchar(255),
    UserPassword varchar(255) NOT NULL,
    ActiveAccount bool NOT NULL,
    PRIMARY KEY (UserID)
);

CREATE TABLE PasswordChange (
	PasswordChangeID int NOT NULL AUTO_INCREMENT,
    PasswordChangeDate DATETIME,
    PasswordChangeType varchar(255),
    UserChangedID int,
    UserChangingID int,
    PRIMARY KEY (PasswordChangeID),
    FOREIGN KEY (UserChangedID) REFERENCES Users(UserID),
    FOREIGN KEY (UserChangingID) REFERENCES Users(UserID)
);

CREATE TABLE LoginAttempts (
	LoginAttemptsID int NOT NULL AUTO_INCREMENT,
    LoginAttemptsDate DATETIME NOT NULL,
    Success bool NOT NULL,
    Username varchar(255) NOT NULL,
    PRIMARY KEY (LoginAttemptsID)
);

CREATE TABLE Company (
	CompanyID int NOT NULL AUTO_INCREMENT,
    CompanyName varchar(255),
    PointToDollar int,
    Email varchar(255),
    OfficePhone varchar(14),
    CompanyTestDriverID int,
    CompanyTestSponsorID int,
    PRIMARY KEY (CompanyID),
    FOREIGN KEY (CompanyTestDriverID) REFERENCES Users(UserID),
    FOREIGN KEY (CompanyTestSponsorID) REFERENCES Users(UserID)
);
    
CREATE TABLE Sponsor (
	SponsorID int NOT NULL AUTO_INCREMENT,
    CompanyID int NOT NULL,
    UserID int NOT NULL,
    PRIMARY KEY (SponsorID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID)
);

CREATE TABLE Driver (
	DriverID int NOT NULL AUTO_INCREMENT,
    Address varchar(255),
    UserID int NOT NULL,
    PRIMARY KEY (DriverID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE DriverPoints (
	DriverPointsID int NOT NULL AUTO_INCREMENT,
    DriverID int NOT NULL,
    CompanyID int NOT NULL,
    Points int,
    PRIMARY KEY (DriverPointsID),
    FOREIGN KEY (DriverID) REFERENCES Driver(DriverID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID)
);

CREATE TABLE DriverApplications (
	DriverApplicationID int NOT NULL AUTO_INCREMENT,
    ApplicationDate DATETIME,
    CompanyID int,
    DriverID int,
	ApplicationStatus varchar(255),
    Reason varchar(255),
    PRIMARY KEY (DriverApplicationID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID),
    FOREIGN KEY (DriverID) REFERENCES Driver(DriverID)
);

CREATE TABLE PointChanges (
	PointChangeID int NOT NULL AUTO_INCREMENT,
    PointChange int,
    PointTotal int,
    DriverID int,
    SponsorID int,
    CompanyID int,
    Reason varchar(255),
    PointChangeDate DATETIME,
    PRIMARY KEY (PointChangeID),
    FOREIGN KEY (DriverID) REFERENCES Driver(DriverID),
    FOREIGN KEY (SponsorID) REFERENCES Sponsor(SponsorID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID)
);

CREATE TABLE CatalogItems (
	ItemID int NOT NULL AUTO_INCREMENT,
    CompanyID int NOT NULL,
    Price decimal (10,2),
    ItemDescription varchar(255),
    ItemImage varchar(255),
    Quantity int,
    ListingID varchar(255),
    Removed boolean,
    PRIMARY KEY (ItemID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID)
);

CREATE TABLE CatalogPurchases (
	PurchaseID int NOT NULL AUTO_INCREMENT,
    PointCost int,
    MonetaryCost decimal (10,2),
    DriverID int,
    CompanyID int,
    ItemID int,
    PurchaseDate DATETIME,
    PRIMARY KEY (PurchaseID),
    FOREIGN KEY (DriverID) REFERENCES Driver(DriverID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID),
    FOREIGN KEY (ItemID) REFERENCES CatalogItems(ItemID)
);

CREATE TABLE CatalogCart (
	CartID int NOT NULL AUTO_INCREMENT,
    DriverID int,
    CompanyID int,
    ItemID int,
    PRIMARY KEY (CartID),
    FOREIGN KEY (DriverID) REFERENCES Driver(DriverID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID),
    FOREIGN KEY (ItemID) REFERENCES CatalogItems(ItemID)
);

CREATE TRIGGER subtract_points
AFTER INSERT ON CatalogPurchases FOR EACH ROW
	UPDATE DriverPoints
		SET DriverPoints.Points = DriverPoints.Points - NEW.PointCost
        WHERE DriverPoints.DriverID = NEW.DriverID AND
        DriverPoints.CompanyID = NEW.CompanyID;
        
CREATE TRIGGER change_points
AFTER INSERT ON PointChanges FOR EACH ROW
	UPDATE DriverPoints
		SET DriverPoints.Points = DriverPoints.Points + NEW.PointChange
        WHERE DriverPoints.DriverID = NEW.DriverID AND
        DriverPoints.CompanyID = NEW.CompanyID;

DELIMITER //
CREATE TRIGGER add_dummy_company_views
BEFORE INSERT ON Company FOR EACH ROW
BEGIN
	DECLARE driver_username varchar(255);
    DECLARE sponsor_username varchar(255);
    DECLARE driver_user_id int;
    DECLARE sponsor_user_id int;
    SET driver_username := CONCAT(NEW.CompanyName, 'driveraccount@switchview.com');
    SET sponsor_username := CONCAT(NEW.CompanyName, 'sponsoraccount@switchview.com');
    INSERT INTO Users (UserType, Username, FirstName, MiddleName, LastName, PreferredName, UserPassword) VALUES ('D', driver_username, 'Dummy', 'Company', 'Driver', 'DCD', (SELECT SHA2('Password1@', 224)));
    SET driver_user_id := (SELECT UserID FROM Users WHERE Username=driver_username);
    INSERT INTO Driver (Address, UserID) VALUES ('111 Theoretical Road, Fakeville, CA 91292', driver_user_id);
    INSERT INTO Users (UserType, Username, FirstName, MiddleName, LastName, PreferredName, UserPassword) VALUES ('S', sponsor_username, 'Dummy', 'Company', 'Sponsor', 'DCS', (SELECT SHA2('Password1@', 224)));
    SET sponsor_user_id := (SELECT UserID FROM Users WHERE Username=sponsor_username);
    SET NEW.CompanyTestDriverID := driver_user_id;
    SET NEW.CompanyTestSponsorID := sponsor_user_id;
END
//
DELIMITER ;

DELIMITER $$
CREATE TRIGGER complete_dummy_creation
AFTER INSERT ON Company FOR EACH ROW
BEGIN
	INSERT INTO DriverPoints (DriverID, CompanyID, Points) VALUES ((SELECT DriverID FROM Driver WHERE UserID=NEW.CompanyTestDriverID), NEW.CompanyID, 10000);
    INSERT INTO Sponsor (CompanyID, UserID) VALUES (NEW.CompanyID, NEW.CompanyTestSponsorID);
    UPDATE Users SET Username=CONCAT('driveraccount', NEW.CompanyID ,'@switchview.com') WHERE UserID = NEW.CompanyTestDriverID;
    UPDATE Users SET Username=CONCAT('sponsoraccount', NEW.CompanyID ,'@switchview.com') WHERE UserID = NEW.CompanyTestSponsorID;
END
$$
DELIMITER ;