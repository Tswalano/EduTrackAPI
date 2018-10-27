<!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="_vendor/bootstrap/dist/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="_assets/css/custom.min.css">     -->
    <link rel="stylesheet" href="_vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="_vendor/toasteo/dist/css/toasteo.css">
    <title>EduTrack Dashboard</title>

    <!-- jQuery library -->
    <script src="_vendor/jquery/dist/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="_vendor/popper.js/dist/popper.min.js"></script>
    <!-- Latest Bootstrap JS -->
    <script src="_vendor/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Sammy JS -->
    <script src="_vendor/sammy/sammy.js"></script>
    <!-- Coustom Script -->
    <script src="_vendor/js/app.js"></script>
    

  </head>

  <body style="background-color:#b3dcd9;">
    <!-- A grey horizontal navbar that becomes vertical on small screens -->
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

      <div class="container">
        <!-- Brand/logo -->
        <a class="navbar-brand" href="#/home"><span id="brand"></span></a>
        <!-- Links -->
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="#/info">Info</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#/about">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#/waiting">Waiting List</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#/add-student">Add Students</a>
          </li>
          <li class="nav-item">
            <a href="javascript:logOut();" class="btn btn-success"><i class="fa fa-user"></i> <span id="loggedUser"></span></a>
          </li>
        </ul>
      </div>

    </nav>
    
    <div id="main">
    </div>

    <script>
    </script>
  </body>
  </html>