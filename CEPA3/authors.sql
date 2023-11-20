-- Create the Authors database
CREATE DATABASE Authors;

-- Switch to the Authors database
USE Authors;

-- Create the Author table
CREATE TABLE Author (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    author_name VARCHAR(255) NOT NULL
);

-- Create the AuthorDetails table for the 1:1 relationship with Author
CREATE TABLE AuthorDetails (
    author_id INT PRIMARY KEY,
    is_alive BOOLEAN,
    FOREIGN KEY (author_id) REFERENCES Author(author_id)
);

-- Create the Books table
CREATE TABLE Books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    book_title VARCHAR(255) NOT NULL,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES Author(author_id)
);

-- Create the M:M relationship table between Author and Books
CREATE TABLE Author_Books (
    author_id INT,
    book_id INT,
    PRIMARY KEY (author_id, book_id),
    FOREIGN KEY (author_id) REFERENCES Author(author_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

-- Insert data into the Author table
INSERT INTO Author (author_name) VALUES
    ('Paco'),
    ('Manolo');

-- Insert data into the AuthorDetails table
INSERT INTO AuthorDetails (author_id, is_alive) VALUES
    (1, true), -- Author1 is alive
    (2, false); -- Author2 is not alive

-- Insert data into the Books table
INSERT INTO Books (book_title, author_id) VALUES
    ('La Historia Fria', 1), -- Book1 written by Author1
    ('El Cuento Calido', 2); -- Book2 written by Author2

-- Insert data into the Author_Books table
INSERT INTO Author_Books (author_id, book_id) VALUES
    (1, 1), -- Author1 wrote Book1
    (2, 2); -- Author2 wrote Book2