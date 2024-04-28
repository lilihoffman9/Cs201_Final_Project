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
('Art & Sculpture Exhibition', 'Los Angeles, CA', '2024-11-05 11:00:00', 'Experience breathtaking contemporary art and sculptures by renowned artists.', '/qr_codes/art_sculpture_exhibition.png'),
('Taylor Swift Concert', 'Los Angeles, CA', '2024-07-01 17:00:00', 'Taylor Swift will be performing at the KIA Stadium on April 25th, 2024 at 4pm.', 'img/taylor_swift.png' )

/* Longer Descriptions for logged-in users:

Taylor Swift:
Don't miss the chance to witness Taylor Swift's captivating performance at the KIA Stadium on April 25th, 2024, kicking off at 4pm. Prepare to be swept away by her magnetic stage presence, iconic vocals, and mesmerizing showmanship, creating an atmosphere brimming with excitement and emotion. Join thousands of fellow fans as they sing along to her greatest hits, creating memories that will last a lifetime. With Live Nation ensuring a seamless event, you can relax and immerse yourself in the magic of Swift's music, making this concert an unmissable highlight of the year. Secure your tickets now and get ready for an unforgettable evening of pure entertainment!

Tech Conference 2024:
Mark your calendars for the highly anticipated Tech Conference 2024, set against the backdrop of San Francisco, CA, on September 15th, 2024, starting at 9:00 AM. This comprehensive event promises to gather industry leaders in technology and innovation under one roof, offering a platform for collaboration, learning, and networking. Explore the forefront of technological advancements across diverse sectors, from artificial intelligence to sustainable development. Immerse yourself in dynamic discussions, hands-on workshops, and visionary keynotes aimed at shaping the future of tech. Reserve your spot now to be part of this transformative experience at Tech Conference 2024!

Marathon 2024: 
Embark on a journey of endurance and determination at the 2024 Marathon, set to take place in Boston, MA, on April 19th, 2024, starting at 6:00 AM. Join participants from across the globe in this iconic annual event, where runners test their limits and push themselves to new heights of achievement. Experience the thrill of crossing the finish line amidst the cheers of spectators and fellow runners, creating memories that will last a lifetime. Whether you're a seasoned athlete or a first-time participant, the Boston Marathon offers an unparalleled opportunity to challenge yourself and be part of a truly inspiring community event. Lace up your running shoes and prepare for an unforgettable marathon experience in the heart of historic Boston!

Art & Sculpture Exhibition: 
Discover a world of creativity at
			the Art & Sculpture Exhibition in Los Angeles, CA, on November 5,
			2024, starting at 11:00 AM. Immerse yourself in the captivating realm
			of contemporary art and sculptures crafted by acclaimed artists.
			Engage with the intricate details and profound expressions embedded
			in each masterpiece on display. Delve into the artistic process and
			inspiration behind the works during interactive sessions with the
			creators themselves. This event promises a journey of aesthetic
			delight and intellectual stimulation for art enthusiasts of all ages.

Summer Music Festival: Experience the electrifying
			ambiance of the Summer Music Festival in the heart of New York City
			on June 21, 2024, starting at 2:00 PM. Featuring an eclectic lineup
			of renowned artists and vibrant local bands, this event promises a
			day immersed in rhythmic melodies and soul-stirring performances.
			Dive into the pulsating beats and melodies that will resonate through
			the city, creating an unforgettable atmosphere for music enthusiasts
			of all tastes. Don't miss out on this opportunity to celebrate the
			essence of summer amidst the backdrop of one of the world's most
			iconic cities. Secure your tickets now for a musical journey you
			won't soon forget!

Food Expo 2024: Embark on a journey of endurance
			and determination at the 2024 Marathon, set to take place in Boston,
			MA, on April 19th, 2024, starting at 6:00 AM. Join participants from
			across the globe in this iconic annual event, where runners test
			their limits and push themselves to new heights of achievement.
			Experience the thrill of crossing the finish line amidst the cheers
			of spectators and fellow runners, creating memories that will last a
			lifetime. Whether you're a seasoned athlete or a first-time
			participant, the Boston Marathon offers an unparalleled opportunity
			to challenge yourself and be part of a truly inspiring community
			event. Lace up your running shoes and prepare for an unforgettable
			marathon experience in the heart of historic Boston!


*/
