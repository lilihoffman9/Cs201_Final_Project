CREATE TABLE Registration (
    registrationID VARCHAR(255) PRIMARY KEY,
    userID VARCHAR(255) NOT NULL,
    eventName VARCHAR(255) NOT NULL,
    registrationTime DATETIME NOT NULL,
    QRCode VARCHAR(255) UNIQUE NOT NULL,
    FOREIGN KEY (userID) REFERENCES Users(userID),
    FOREIGN KEY (eventName) REFERENCES Events(eventName)
);
