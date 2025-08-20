INSERT INTO books (title, author, publisher, genre, book_status) VALUES
('The Hobbit', 'J.R.R. Tolkien', 'Allen & Unwin', 'FANTASY', 'AVAILABLE'),
('The Fellowship of the Ring', 'J.R.R. Tolkien', 'Allen & Unwin', 'FANTASY', 'AVAILABLE'),
('The Two Towers', 'J.R.R. Tolkien', 'Allen & Unwin', 'FANTASY', 'AVAILABLE'),
('The Return of the King', 'J.R.R. Tolkien', 'Allen & Unwin', 'FANTASY', 'AVAILABLE'),
('The Bourne Identity', 'Robert Ludlum', 'Random House', 'ACTION', 'AVAILABLE'),
('The Bourne Supremacy', 'Robert Ludlum', 'Random House', 'ACTION', 'AVAILABLE'),
('The Da Vinci Code', 'Dan Brown', 'Doubleday', 'THRILLER', 'AVAILABLE'),
('Angels & Demons', 'Dan Brown', 'Pocket Books', 'THRILLER', 'AVAILABLE'),
('Inferno', 'Dan Brown', 'Doubleday', 'THRILLER', 'AVAILABLE'),
('Origin', 'Dan Brown', 'Doubleday', 'THRILLER', 'AVAILABLE'),
('Pride and Prejudice', 'Jane Austen', 'T. Egerton', 'ROMANCE', 'AVAILABLE'),
('Sense and Sensibility', 'Jane Austen', 'T. Egerton', 'ROMANCE', 'AVAILABLE'),
('Emma', 'Jane Austen', 'John Murray', 'ROMANCE', 'AVAILABLE'),
('1984', 'George Orwell', 'Secker & Warburg', 'SF', 'AVAILABLE'),
('Animal Farm', 'George Orwell', 'Secker & Warburg', 'SF', 'AVAILABLE'),
('To Kill a Mockingbird', 'Harper Lee', 'J.B. Lippincott & Co.', 'HISTORICAL', 'AVAILABLE'),
('Moby Dick', 'Herman Melville', 'Harper & Brothers', 'ACTION', 'AVAILABLE'),
('The Great Gatsby', 'F. Scott Fitzgerald', 'Scribner', 'HISTORICAL', 'AVAILABLE'),
('War and Peace', 'Leo Tolstoy', 'The Russian Messenger', 'HISTORICAL', 'AVAILABLE'),
('Crime and Punishment', 'Fyodor Dostoevsky', 'The Russian Messenger', 'HISTORICAL', 'AVAILABLE');

INSERT INTO users (name, email) VALUES
('Alice Cooper', 'alice@example.com'),
('Bob Marley', 'bob@example.com'),
('Charlie Swan', 'charlie@example.com'),
('Diana Prince', 'diana@example.com'),
('Ethan Hunt', 'ethan@example.com');

INSERT INTO borrowed_books_history (from_user_id_id, from_book_id_id, borrow_date, return_date) VALUES
(1, 1, TIMESTAMP '2025-08-01 10:00:00', NULL),
(2, 5, TIMESTAMP '2025-08-02 11:30:00', NULL),
(3, 14, TIMESTAMP '2025-07-20 14:00:00', TIMESTAMP '2025-08-05 15:00:00'),
(4, 7, TIMESTAMP '2025-07-15 09:00:00', TIMESTAMP '2025-07-30 18:00:00'),
(5, 18, TIMESTAMP '2025-08-10 12:00:00', NULL);

