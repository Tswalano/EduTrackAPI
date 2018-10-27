<?php
  // Include db config
  require_once 'db.php';

  // Init vars
  $email = $password = '';
  $email_err = $password_err = '';

  // Process form when post submit
  if($_SERVER['REQUEST_METHOD'] === 'POST'){
    // Sanitize POST
    $_POST = filter_input_array(INPUT_POST, FILTER_SANITIZE_STRING);

    // Put post vars in regular vars
    $email = trim($_POST['userEmail']);
    $password = trim($_POST['userPassword']);

    // Validate email
    if(empty($email)){
      $data = array(
                  "message" => "Please enter email",
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
    }

    // Validate password
    if(empty($password)){
      $data = array(
                  "message" => "Please enter password",
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
    }

    // Make sure errors are empty
    if(!empty($email) && !empty($password)){
      // Prepare query
      $sql = 'SELECT first_name, email, password, school_name FROM users u JOIN school s ON s.schoolid = u.schoolid WHERE email = :email';

      // Prepare statement
      if($stmt = $pdo->prepare($sql)){
        // Bind params
        $stmt->bindParam(':email', $email, PDO::PARAM_STR);

        // Attempt execute
        if($stmt->execute()){
          // Check if email exists
          if($stmt->rowCount() === 1){
            if($row = $stmt->fetch()){
              $hashed_password = $row['password'];
              if(password_verify($password, $hashed_password)){
                // SUCCESSFUL LOGIN
                session_start();
                $_SESSION['email'] = $email;
                $_SESSION['name'] = $row['first_name'];
                $data = array(
                  "message" => "Success",
                  "username" => $email,
                  "school" => $row['school_name']
                );
                print_r(json_encode($data));
              } else {
                // Display wrong password message
                $data = array(
                  "message" => "The password you entered is not valid",
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
              }
            }
          } else {
            $data = array(
                  "message" => "No account found for that email",
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
          }
        } 
        else {
          $data = array(
                  "message" => "Something went wrong",
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
        }
      }
      // Close statement
      unset($stmt);
    }

    // Close connection
    unset($pdo);
  }
?>