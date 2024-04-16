CREATE TABLE Events (
    eventID INT AUTO_INCREMENT PRIMARY KEY,
    eventName VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    date DATETIME NOT NULL,
    description TEXT
    QRCodePath VARCHAR(255) UNIQUE NOT NULL  -- Storing the file path
);
