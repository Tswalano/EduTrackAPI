  <div class="container">
    <div class="row">
      <div class="col-md-6 mx-auto mt-5">
        <div class="card card-body bg-light mt-5">
          <h2>Login</h2>
          <p>Fill in your credentials</p>
          <form id="loginForm">   
            <div class="form-group">
              <label for="userEmail">Email Address</label>
              <input type="email" name="userEmail" id="userEmail" class="form-control">
            </div>
            <div class="form-group">
              <label for="userPassword">Password</label>
              <input type="password" name="userPassword" id="userPassword" class="form-control">
            </div>
            <div class="form-row">
              <div class="col">
                <input type="submit" id="login" value="Login" class="btn btn-success btn-block">
              </div>
              <div class="col">
                <a href="#/register" class="btn btn-light btn-block">No account? Register</a>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <!-- Latest Toasteo JS -->
<script src="_vendor/toasteo/dist/js/app.js"></script>
  <script src="_vendor/js/functions.js"></script> 
  <script>
    $(document).ready(function () {
      defaultFunction();
      $("#login").click(function (event) {
        event.preventDefault();
        var data = $("#loginForm").serialize();
        logIn(data);
          
      })
    });
  </script>