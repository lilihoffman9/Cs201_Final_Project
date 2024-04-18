CREATE TABLE Events (
    eventID INT AUTO_INCREMENT PRIMARY KEY,
    eventName VARCHAR(255) UNIQUE NOT NULL,
    location VARCHAR(255) NOT NULL,
    date DATETIME NOT NULL,
    description TEXT,
    QRCodePath VARCHAR(255) UNIQUE NOT NULL  -- Storing the file path
);

INSERT INTO Events (eventName, location, date, description, QRCodePath)
VALUES
('Summer Music Festival', 'New York City, NY', '2024-06-21 14:00:00', 'Join us for a day filled with music from top artists and local bands.', '/qr_codes/summer_music_festival.png'),
('Tech Conference 2024', 'San Francisco, CA', '2024-09-15 09:00:00', 'A comprehensive conference featuring industry leaders in technology and innovation.', '/qr_codes/tech_conference_2024.png'),
('Marathon 2024', 'Boston, MA', '2024-04-19 06:00:00', 'Annual marathon with participants from all over the world.', '/qr_codes/marathon_2024.png'),
('Food Expo 2024', 'Chicago, IL', '2024-08-12 10:00:00', 'Explore culinary delights from famous chefs and local favorites.', '/qr_codes/food_expo_2024.png'),
('Art & Sculpture Exhibition', 'Los Angeles, CA', '2024-11-05 11:00:00', 'Experience breathtaking contemporary art and sculptures by renowned artists.', '/qr_codes/art_sculpture_exhibition.png');

