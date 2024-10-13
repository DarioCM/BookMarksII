-- Create users table
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create bookmarks table
CREATE TABLE bookmarks (
                           id SERIAL PRIMARY KEY,
                           title VARCHAR(255) NOT NULL,
                           url VARCHAR(255) NOT NULL,
                           user_id INTEGER NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insert initial data into users table
INSERT INTO users (name, email) VALUES
                                    ('John Doe', 'john.doe@example.com'),
                                    ('Jane Smith', 'jane.smith@example.com');

-- Insert initial data into bookmarks table
INSERT INTO bookmarks (title, url, user_id) VALUES
                                                ('Google', 'https://www.google.com', 1),
                                                ('GitHub', 'https://www.github.com', 1),
                                                ('Stack Overflow', 'https://stackoverflow.com', 2);
