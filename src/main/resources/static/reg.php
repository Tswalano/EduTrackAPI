<?php
  // Include db config
  require_once 'db.php';

  // Init vars
  $lname = $fname = $email = $schoolid = $password = $confirm_password = '';
  $lname_err = $fname_err = $email_err = $password_err = $school_err = $confirm_password_err = '';

  // Process form when post submit
  if($_SERVER['REQUEST_METHOD'] === 'POST'){
    // Sanitize POST
    $_POST = filter_input_array(INPUT_POST, FILTER_SANITIZE_STRING);

    // Put post vars in regular vars
    $lname =  trim($_POST['lname']);
    $fname =  trim($_POST['fname']);
    $email = trim($_POST['email']);
    $schoolid =  trim($_POST['schoolid']);
    $password = trim($_POST['password']);
    $confirm_password = trim($_POST['confirm_password']);

    print_r($schoolid);

    // Validate email
    if(empty($email)){
      $email_err = 'Please enter email';
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
          }
        } else {
          die('Something went wrong');
        }
      }

      unset($stmt);
    }

    // Validating if selected school exists
    if(empty($schoolid)){
      $school_err = 'Please select the school you stationed at';
    }else {
      // Prepare a select statement
      $sql = 'SELECT schoolid FROM school WHERE schoolid = :schoolid';

      if($stmt = $pdo->prepare($sql)){
        // Bind variables
        $stmt->bindParam(':schoolid', $schoolid, PDO::PARAM_STR);

        // Attempt to execute
        if($stmt->execute()){
          // Check if email exists
          if($stmt->rowCount() === 0){

            $school_err = 'Selected school doese not exists';
            print_r($school_err);
            // die("Invalid School");
          }
        } else {
          die('Something went wrong');
        }
      }

      unset($stmt);
    }

    // Validate name
    if(empty($fname)){
      $fname_err = 'Please enter first name';
    }

    if(empty($lname)){
      $lname_err = 'Please enter last name';
    }

    // Validate password
    if(empty($password)){
      $password_err = 'Please enter password';
    } elseif(strlen($password) < 6){
      $password_err = 'Password must be at least 6 characters ';
    }

    // Validate Confirm password
    if(empty($confirm_password)){
      $confirm_password_err = 'Please confirm password';
    } else {
      if($password !== $confirm_password){
        $confirm_password_err = 'Passwords do not match';
      }
    }

    // Make sure errors are empty
    if(empty($fname_err) && empty($lname_err) && empty($school_err) && empty($email_err) && empty($password_err) && empty($confirm_password_err)){
      // Hash password
      $password = password_hash($password, PASSWORD_DEFAULT);

      // Prepare insert query
      $sql = 'INSERT INTO users(first_name,last_name,email,schoolid,password) 
      VALUES(:fname, :lname, :email,(SELECT schoolid FROM school WHERE schoolid = :schoolid),:password)';

      if($stmt = $pdo->prepare($sql)){
        // Bind params
        $stmt->bindParam(':lname', $fname, PDO::PARAM_STR);
        $stmt->bindParam(':fname', $lname, PDO::PARAM_STR);        
        $stmt->bindParam(':email', $email, PDO::PARAM_STR);
        $stmt->bindParam(':schoolid', $schoolid, PDO::PARAM_STR);
        $stmt->bindParam(':password', $password, PDO::PARAM_STR);

        // Attempt to execute
        if($stmt->execute()){
          // Redirect to login
          header('location: login.php');
        } else {
          die('Something went wrong');
        }
      }else {
          die('Something went wrong xxxxx');
        }
      unset($stmt);
    }

    // Close connection
    unset($pdo);
  }
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="_vendor/bootstrap/dist/css/bootstrap.min.css">
  <title>Login To Your Account</title>
</head>
<body style="background-color:#b3dcd9;">
  <div class="container">
    <div class="row">
      <div class="col-md-8 mx-auto">
        <div class="card card-body bg-light mt-5">
          <h2>Create Account</h2>
          <p>Fill in this form to register</p>
          <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">
            <div class="form-row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="fname">First Name</label>
                  <input type="text" name="fname" class="form-control  <?php echo (!empty($fname_err)) ? 'is-invalid' : ''; ?>"
                    value="<?php echo $fname; ?>">
                  <span class="invalid-feedback"><?php echo $fname_err; ?></span>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="lname">Last Name</label>
                  <input type="text" name="lname" class="form-control  <?php echo (!empty($lname_err)) ? 'is-invalid' : ''; ?>"
                    value="<?php echo $lname; ?>">
                  <span class="invalid-feedback"><?php echo $lname_err; ?></span>
                </div>
              </div>
            </div>

            <div class="form-row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="email">Email Address</label>
                  <input type="email" name="email" class="form-control  <?php echo (!empty($email_err)) ? 'is-invalid' : ''; ?>"
                    value="<?php echo $email; ?>">
                  <span class="invalid-feedback"><?php echo $email_err; ?></span>
                  <span class="invalid-feedback"><?php echo $school_err; ?></span>                  
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="school">School Name</label>
                  <select class="custom-select" name="schoolid">
                    <option selected="">Select a school</option>
                    <option value="1">Uptown High School</option>
                    <option value="2">Highland Secondary School</option>
                    <option value="3">South Side High School</option>
                  </select>
                  <span class="invalid-feedback"><?php echo $school_err; ?></span>
                </div>
              </div>
            </div>
            
            <div class="form-row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="password">Password</label>
                  <input type="password" name="password" class="form-control  <?php echo (!empty($password_err)) ? 'is-invalid' : ''; ?>"
                    value="<?php echo $password; ?>">
                  <span class="invalid-feedback"><?php echo $password_err; ?></span>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="confirm_password">Confirm Password</label>
                  <input type="password" name="confirm_password" class="form-control  <?php echo (!empty($confirm_password_err)) ? 'is-invalid' : ''; ?>"
                    value="<?php echo $confirm_password; ?>">
                  <span class="invalid-feedback"><?php echo $confirm_password_err; ?></span>
                </div>
              </div>
            </div>

            <div class="form-row">
              <div class="col">
                <input type="submit" value="Register" class="btn btn-success btn-block">
              </div>
              <div class="col">
                <a href="login.php" class="btn btn-light btn-block">Have an account? Login</a>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
