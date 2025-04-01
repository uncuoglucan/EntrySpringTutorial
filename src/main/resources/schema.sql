CREATE TABLE IF NOT EXISTS Run (
  id INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  started_on timestamp NOT NULL,
  completed_on timestamp NOT NULL,
  km INT NOT NULL,
  location VARCHAR(10) NOT NULL,
  version INT,
  PRIMARY KEY (id)
); 