-- Adding sample books
INSERT INTO book (title, author, isbn, published_year, copies_available) 
VALUES 
  ('Effective Java', 'Joshua Bloch', '9876543210', 2017, 3),
  ('Clean Code', 'Robert C. Martin', '1231231231', 2008, 5),
  ('Head First Design Patterns', 'Eric Freeman', '1111111111', 2004, 2),
  ('Introduction to Algorithms', 'Thomas H. Cormen', '2222222222', 2009, 4),
  ('Domain-Driven Design', 'Eric Evans', '3333333333', 2003, 6);

-- Adding sample members
INSERT INTO member (name, email, membership_date) 
VALUES 
  ('John Doe', 'john.doe@example.com', '2023-01-01'),
  ('Jane Doe', 'jane.doe@example.com', '2023-01-15'),
  ('Bob Smith', 'bob.smith@example.com', '2022-09-10');

-- Adding sample loans
INSERT INTO loan (loan_date, return_date, status, book_id, member_id) 
VALUES 
  ('2024-11-01', NULL, 'Issued', 1, 1),
  ('2024-11-05', NULL, 'Issued', 3, 2),
  ('2024-11-10', '2024-11-15', 'Returned', 2, 3);

-- Adding sample reservations
INSERT INTO reservation (member_id, book_id, reservation_date) 
VALUES 
  (1, 1, '2024-11-01'),
  (2, 1, '2024-11-02'),
  (3, 2, '2024-11-05');
