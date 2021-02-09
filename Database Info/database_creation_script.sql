CREATE DATABASE application_db;

USE application_db;

CREATE TABLE Users (
	UserID int NOT NULL AUTO_INCREMENT,
    UserType varchar(1) NOT NULL,
    FirstName varchar(255),
    MiddleName varchar(255),
    LastName varchar(255),
    PreferredName varchar(255),
    UserPassword varchar(255),
    LastLogon DATETIME,
    TwoFactorAuth bool,
    PRIMARY KEY (UserID)
);

CREATE TABLE PasswordChange (
	PasswordChangeID int NOT NULL AUTO_INCREMENT,
    PasswordChangeDate DATETIME,
    PasswordChangeType varchar(255),
    UserID int,
    PRIMARY KEY (PasswordChangeID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE LoginAttempts (
	LoginAttemptsID int NOT NULL AUTO_INCREMENT,
    LoginAttemptsDate DATETIME,
    Success bool,
    UserID int,
    PRIMARY KEY (LoginAttemptsID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE Company (
	CompanyID int NOT NULL AUTO_INCREMENT,
    CompanyName varchar(255),
    PointToDollar int,
    Email varchar(255),
    OfficePhone varchar(14),
    PRIMARY KEY (CompanyID)
);
    
CREATE TABLE Sponsor (
	SponsorID int NOT NULL AUTO_INCREMENT,
    CompanyID int,
    PRIMARY KEY (SponsorID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID)
);

CREATE TABLE Driver (
	DriverID int NOT NULL AUTO_INCREMENT,
    Points int,
    DriverApplicationID int,
    Address varchar(255),
    CompanyID int,
    PRIMARY KEY (DriverID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID)
);

CREATE TABLE DriverApplications (
	DriverApplicationID int NOT NULL AUTO_INCREMENT,
    ApplicationDate DATETIME,
    CompanyID int,
    DriverID int,
    ApplicationStatus bool,
    Reason varchar(255),
    Answers varchar(255),
    PRIMARY KEY (DriverApplicationID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID),
    FOREIGN KEY (DriverID) REFERENCES Driver(DriverID)
);

CREATE TABLE PointChanges (
	PointChangeID int NOT NULL AUTO_INCREMENT,
    PointChange int,
    DriverID int,
    SponsorID int,
    CompanyID int,
    Reason varchar(255),
    PointChangeData DATETIME,
    PRIMARY KEY (PointChangeID),
    FOREIGN KEY (DriverID) REFERENCES Driver(DriverID),
    FOREIGN KEY (SponsorID) REFERENCES Sponsor(SponsorID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID)
);

CREATE TABLE CatalogItems (
	ItemID int NOT NULL AUTO_INCREMENT,
    Price decimal (4,2),
    ItemDescription varchar(255),
    ItemImage varchar(255),
    Quantity int,
    PRIMARY KEY (ItemID)
);

CREATE TABLE CatalogItemExclude (
	CompanyID int,
    ItemID int,
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID),
    FOREIGN KEY (ItemID) REFERENCES CatalogItems(ItemID)
);

CREATE TABLE CatalogPurchases (
	PurchaseID int NOT NULL AUTO_INCREMENT,
    PointCost int,
    DriverID int,
    CompanyID int,
    ItemID int,
    PurchaseDate DATETIME,
    PRIMARY KEY (PurchaseID),
    FOREIGN KEY (DriverID) REFERENCES Driver(DriverID),
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID),
    FOREIGN KEY (ItemID) REFERENCES CatalogItems(ItemID)
);