DROP TABLE House;
DROP TABLE RealEstateAgentPhone;
DROP TABLE Buyer;
DROP TABLE Seller;
DROP TABLE RealEstateAgent;

CREATE TABLE Seller(
    SocialSecurityNumber NUMBER(9),
    SellerName VARCHAR(34) NOT NULL,
    PhoneNumber NUMBER(10) NOT NULL,
    SpouseName VARCHAR(34) DEFAULT '',
    CONSTRAINT SellerPk PRIMARY KEY(SocialSecurityNumber)
);

CREATE TABLE RealEstateAgent(
    AgentID CHAR(7),
    AgentName VARCHAR(34) NOT NULL,
    OfficeName VARCHAR(20) NOT NULL,
    CONSTRAINT RealEstateAgentPk PRIMARY KEY(AgentID)
);

CREATE Table House(
    HomeID CHAR(7),
    StreetAddress VARCHAR(28) UNIQUE NOT NULL,
    StateName VARCHAR(14) NOT NULL,
    SquareFeet NUMBER(6) NOT NULL,
    AskingPrice NUMBER(10),
    CommisionPercent NUMBER(5, 2),
    SellerID NUMBER(9),
    AgentID CHAR(7),
    CONSTRAINT HousePk PRIMARY KEY(HomeID),
    CONSTRAINT HouseSellerFk FOREIGN KEY(SellerID)
        REFERENCES Seller(SocialSecurityNumber),
    CONSTRAINT HouseAgentFk FOREIGN KEY(AgentID)
        REFERENCES RealEstateAgent(AgentID)
);

CREATE TABLE RealEstateAgentPhone(
    AgentID CHAR(7),
    PhoneNumber NUMBER(10),
    CONSTRAINT PhonePk PRIMARY KEY(PhoneNumber),
    CONSTRAINT PhoneFk FOREIGN KEY(AgentID)
        REFERENCES RealEstateAgent(AgentID)
);

CREATE TABLE Buyer(
    SocialSecurityNumber NUMBER(9),
    BuyerName VARCHAR(34) NOT NULL,
    PhoneNumber NUMBER(10) NOT NULL,
    LowerPriceLimit NUMBER(10) NOT NULL,
    UpperPriceLimit NUMBER(10) NOT NULL,
    AgentID CHAR(7),
    CONSTRAINT BuyerPk PRIMARY KEY(SocialSecurityNumber),
    CONSTRAINT RealEstateAgentRepresentingFk FOREIGN KEY(AgentID)
        REFERENCES RealEstateAgent(AgentID)
);