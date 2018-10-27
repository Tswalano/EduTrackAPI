<?php

    class Database{
        private $host = 'localhost';
        private $db_name = 'edutrack';
        private $username = 'root';
        private $password = 'mysql';
        private $conn;

        // DB COnnect
        public function connect(){
            $this->conn = null;
            try{
                $this->conn = new PDO('mysql:host='.$this->host.';dbname='.$this->db_name,
                $this->username,$this->password);
                $this->conn->setAttribute(PDO::ATTR_ERRORMODE, PDO::ERRORMODE_EXCEPTION);
            }catch(PDOException $e){
                echo 'Connection Error '.$e.getMessage();
            }

            return $this->conn;
        }
    }
    
?>