CREATE TABLE vote_item (
    id INT AUTO_INCREMENT PRIMARY KEY,    
    name VARCHAR(255) NOT NULL UNIQUE       
);


CREATE TABLE vote_record (
    id INT AUTO_INCREMENT PRIMARY KEY,      
    voter_name VARCHAR(255) NOT NULL,      
    vote_item_id INT NOT NULL,             
    FOREIGN KEY (vote_item_id) REFERENCES vote_item(id) 
);