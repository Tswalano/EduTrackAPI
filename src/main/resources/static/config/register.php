<?php
  // Include db config
  require_once 'db.php';

  // Init vars
  $lname = $fname = $email = $school = $password = $confirm_password = '';
  $lname_err = $fname_err = $email_err = $password_err = $school_err = $confirm_password_err = '';

  // Process form when post submit
  if($_SERVER['REQUEST_METHOD'] === 'POST'){
    // Sanitize POST
    $_POST = filter_input_array(INPUT_POST, FILTER_SANITIZE_STRING);

    // Put post vars in regular vars
    $lname =  trim($_POST['lname']);
    $fname =  trim($_POST['fname']);
    $email = trim($_POST['email']);
    $school =  trim($_POST['school']);
    $password = trim($_POST['password']);
    $confirm_password = trim($_POST['confirm_password']);

    // Validate email
    if(empty($email)){
      $email_err = 'Please enter email';
      $data = array(
                  "message" => $email_err,
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
    } else {
      // Prepare a select statement
      $sql = 'SELECT userid FROM users WHERE email = :email';

      if($stmt = $pdo->prepare($sql)){
        // Bind variables
        $stmt->bindParam(':email', $email, PDO::PARAM_STR);

        // Attempt to execute
        if($stmt->execute()){
          // Check if email exists
          if($stmt->rowCount() === 1){
            $email_err = 'Email is already taken';
            $data = array(
                  "message" => $email_err,
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
          }
            
        } else {
          $data = array(
                  "message" => "Something went wrong",
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
        }
      }

      unset($stmt);
    }

    // Validating if selected school exists
    if(empty($school)){
      $school_err = 'Please select the school you stationed at';
      $data = array(
                  "message" => $school_err,
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
      
    }else {
      // Prepare a select statement
      $sql = 'SELECT schoolid FROM school WHERE schoolid = :school';

      if($stmt = $pdo->prepare($sql)){
        // Bind variables
        $stmt->bindParam(':school', $school, PDO::PARAM_STR);

        // Attempt to execute
        if($stmt->execute()){
          // Check if email exists
          if($stmt->rowCount() === 0){

            $school_err = 'Selected school is not registered';
            print_r($school_err);
            // die("Invalid School");
          }
        } else {
          $data = array(
                  "message" => "Something went wrong",
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
        }
      }

      unset($stmt);
    }

    // Validate name
    if(empty($fname)){
      $fname_err = 'Please enter first name';
      $data = array(
                  "message" => $fname_err,
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
    }

    if(empty($lname)){
      $lname_err = 'Please enter last name';
      $data = array(
                  "message" => $lname_err,
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));    
    }

    // Validate password
    if(empty($password)){
      $password_err = 'Please enter password';
      $data = array(
                  "message" => $password_err,
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));        
    } elseif(strlen($password) < 6){
      $password_err = 'Password must be at least 6 characters ';
      $data = array(
                  "message" => $password_err,
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));  
    }

    // Validate Confirm password
    if(empty($confirm_password)){
      $confirm_password_err = 'Please confirm password';
      $data = array(
                  "message" => $confirm_password_err,
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));  
    } else {
      if($password !== $confirm_password){
        $confirm_password_err = 'Passwords do not match';
         $confirm_password_err = 'Please confirm password';
          $data = array(
                  "message" => $confirm_password_err,
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));  
      }
    }

    // Make sure errors are empty
    if(empty($fname_err) && empty($lname_err) && empty($school_err) && empty($email_err) && empty($password_err) && empty($confirm_password_err)){
      // Hash password
      $password = password_hash($password, PASSWORD_DEFAULT);

      // Prepare insert query
      $sql = 'INSERT INTO users(first_name,last_name,email,schoolid,password) 
      VALUES(:fname, :lname, :email,(SELECT schoolid FROM school WHERE schoolid = :school),:password)';

      if($stmt = $pdo->prepare($sql)){
        // Bind params
        $stmt->bindParam(':lname', $fname, PDO::PARAM_STR);
        $stmt->bindParam(':fname', $lname, PDO::PARAM_STR);        
        $stmt->bindParam(':email', $email, PDO::PARAM_STR);
        $stmt->bindParam(':school', $school, PDO::PARAM_STR);
        $stmt->bindParam(':password', $password, PDO::PARAM_STR);

        // Attempt to execute
        if($stmt->execute()){
           $data = array(
                  "message" => "Success",
                  "username" => $email,
                  "school" => $school
                );
                print_r(json_encode($data));
        } else {
           $data = array(
                  "message" => "Something went wrong",
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
        }
      }else {
           $data = array(
                  "message" => "Something went wrong",
                  "username" => "",
                  "school" => ""
                );
                print_r(json_encode($data));
        }
      unset($stmt);
    }

    // Close connection
    unset($pdo);
  }
?>